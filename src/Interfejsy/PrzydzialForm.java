package Interfejsy;

import java.util.List;

import DAO_Packages.PracownikDAO;
import DAO_Packages.PrzedmiotDAO;
import DAO_Packages.PrzydzialDAO;
import Obiekty.Pracownik;
import Obiekty.Przedmiot;
import Obiekty.Przydzial;

public class PrzydzialForm extends Wyjatki{
	
	private PrzydzialDAO przydzialDAO;
	
	public PrzydzialForm() throws Exception {
		super();
		this.przydzialDAO = new PrzydzialDAO();
	}
	
	
	//***********************************************************************************************
	//------------------- Przydzielanie pracownika do przedmiotu ------------------------------------
	
	public void dodajPrzydzial() throws Exception {
		
		Przydzial przydzial = new Przydzial();
		
		PrzedmiotDAO przedmiotDAO = new PrzedmiotDAO();
		PracownikDAO pracownikDAO = new PracownikDAO();
		int pomocnicza = 0;
		int tmp = 0;
		int pensum = 0;
		int godziny = 0;
		int suma = 0;
		int roznica = 0;
		String nazwa = null;
		boolean nieMaWBazie = true;
		
		
		if(przedmiotDAO.pobierzDostepnePrzedmioty() != null) { // Czy s¹ dostêpne przedmioty
			
			System.out.println("\n\n**************************************");
			System.out.println("***   Dodawanie nowego przydzia³u  ***\n\n");
			
			
			//-------- Lista dostêpnych przedmiotów -----------
			List<Przedmiot> listaPrzedmiotow = przedmiotDAO.pobierzDostepnePrzedmioty();
			
			System.out.println("\n***     Lista dostêpnych przedmiotów     ***");
			System.out.println("--------------------------------------------\n");
			System.out.println("ID\tNazwa przedmiotu\t\tWyk³ady\t\tÆwiczenia\tLaboratoria\tKatedra\n");
			for(Przedmiot przedmiot: listaPrzedmiotow) {				
				System.out.print(przedmiot.getIdPrzedmiot() + "\t");
				System.out.print(przedmiot.getNazwaPrzedmiot() + "\t\t");
				System.out.print(przedmiot.getWyklady() + "\t\t");
				suma = przedmiot.getWyklady();
				System.out.print(przedmiot.getCwiczenia() + "\t\t");
				suma += przedmiot.getCwiczenia();
				System.out.print(przedmiot.getLaboratoria() + "\t\t");
				suma += przedmiot.getLaboratoria();
				
				tmp = przedmiot.getKatedra();
				if(tmp == 1) nazwa = "Ekonometrii i statystyki";
				else if(tmp == 2) nazwa = "Informatyki             ";
				else if(tmp == 3) nazwa = "Zastosowañ informatyki  ";
				else if(tmp == 4) nazwa = "Zastosowañ matematyki   ";
				else nazwa = "b.d.";
				System.out.print(nazwa + "\n");
			}
		
			while(nieMaWBazie) {
				System.out.println("\n\nPodaj ID przedmiotu: ");
				pomocnicza = stringToIntBez0();
				Przedmiot przedmiotDoPrzydzielenia = przedmiotDAO.pobierzPrzedmiot(pomocnicza);
			
				if(przedmiotDoPrzydzielenia != null && przedmiotDoPrzydzielenia.isCzyObsadzony() == false) {
					nieMaWBazie = false;
					
					przedmiotDoPrzydzielenia.setIdPrzedmiot(pomocnicza);  //  
					przedmiotDoPrzydzielenia.setCzyObsadzony(true);       //  Ustawia czyObsadzony na true
					przedmiotDAO.czyObsadzony(przedmiotDoPrzydzielenia);  //
				}
				else System.out.println("* W bazie danych nie istnieje przedmiot o podanym ID lub nie mo¿na go obsadziæ *");
			}
			przydzial.setIdPrzedmiot(pomocnicza);  // Przydzielenie przedmiotu
			
			
			//------------------- Wyœwietlenie pracowników ---------------------------------
			List<Pracownik> listaPracownikow = pracownikDAO.pobierzPracownikow(0);
			
			if(listaPracownikow == null) System.out.println("* W bazie danych nie ma ¿adnych pracowników *");
			
			else {
				System.out.println("\n***     Lista pracowników     ***");
				System.out.println("---------------------------------\n");
				System.out.println("ID\tTytu³\t\tImiê\t\tNazwisko\t\tKatedra\t\t\t\tPozosta³o godzin do osi¹gniêcia pensum\n");
				for(Pracownik pracownik: listaPracownikow) {
					System.out.print(pracownik.getIdPracownika() + "\t");
					
					tmp = pracownik.getStopienNaukowy();
					if(tmp == 1) nazwa = "mgr";
					else if(tmp == 2) nazwa = "dr";
					else if(tmp == 3) nazwa = "dr hab.";
					else if(tmp == 4) nazwa = "prof.";
					else nazwa = "b.d.";
					System.out.print(nazwa + "\t\t");
					
					System.out.print(pracownik.getImie() + "\t\t");
					System.out.print(pracownik.getNazwisko() + "\t\t");
					
					tmp = pracownik.getKatedra();
					if(tmp == 1) nazwa = "Ekonometrii i statystyki";
					else if(tmp == 2) nazwa = "Informatyki             ";
					else if(tmp == 3) nazwa = "Zastosowañ informatyki  ";
					else if(tmp == 4) nazwa = "Zastosowañ matematyki   ";
					else nazwa = "b.d.";
					System.out.print(nazwa + "\t");
					
					pensum = pracownik.getPensum();
					godziny = pracownik.getPrzydzieloneGodziny();
					roznica = pensum - godziny;
					if(roznica != 0) System.out.println(roznica);
					else System.out.println("!!! PRZEKROCZONO !!!");
				}
			}
			
			nieMaWBazie = true;
			while(nieMaWBazie) {
				System.out.println("Podaj ID pracownika: ");
				pomocnicza = stringToIntBez0();
				Pracownik pracownikPrzydzielany = pracownikDAO.pobierzPracownika(pomocnicza);
				
				if(pracownikPrzydzielany != null) {
					nieMaWBazie = false;
					
					suma += pracownikPrzydzielany.getPrzydzieloneGodziny();
					
					pracownikPrzydzielany.setIdPracownika(pomocnicza);         //  
					pracownikPrzydzielany.setPrzydzieloneGodziny(suma);     //  Ustawia przydzielone godziny
					pracownikDAO.przydzielGodziny(pracownikPrzydzielany);      //
				}
				else System.out.println("* W bazie danych nie istnieje pracownik o podanym ID *");
				
			}
			przydzial.setIdPracownik(pomocnicza); // Przydzielenie pracownika
		
			przydzialDAO.dodajPrzydzial(przydzial); // Dodanie do bazy danych
			
		}
		else System.out.println("* Wszystkie przedmioty s¹ obsadzone *");
	}
	
	
	//****************************************************************************
	//------------------------ Usuwanie przydzia³u -------------------------------
	
	public void usunPrzydzial() throws Exception {
		
		PrzedmiotDAO przedmiotDAO = new PrzedmiotDAO();
		PracownikDAO pracownikDAO = new PracownikDAO();
		int pomocnicza = 0;
		int godziny = 0;
		
		System.out.println("\n***   Usuwanie przydzialu z bazy danych  ***");
		System.out.println("-----------------------------------------\n");
		
		wyswietlListePrzydzialow();
		
		System.out.println("\nPodaj ID przydzialu, który ma zostaæ usuniêty: ");
		pomocnicza = stringToIntBez0();
		
		//---- Sprawdzenie czy przydzia³ jest w bazie ----
		Przydzial przydzial = przydzialDAO.pobierzPrzydzial(pomocnicza);
		
		if(przydzial != null) {
			
			Przedmiot przedmiotRozdziel = przedmiotDAO.pobierzPrzedmiot(pomocnicza);
			
			przedmiotRozdziel.setIdPrzedmiot(pomocnicza);   //  
			przedmiotRozdziel.setCzyObsadzony(false);       //  Ustawia czyObsadzony na false
			przedmiotDAO.czyObsadzony(przedmiotRozdziel);   //
			
			
			Pracownik pracownikRozdziel = pracownikDAO.pobierzPracownika(pomocnicza);
			
			godziny = przedmiotRozdziel.getWyklady() + przedmiotRozdziel.getCwiczenia() + przedmiotRozdziel.getLaboratoria();
			godziny -= pracownikRozdziel.getPrzydzieloneGodziny();
			
			pracownikRozdziel.setIdPracownika(pomocnicza);         //  
			pracownikRozdziel.setPrzydzieloneGodziny(godziny);     //  Ustawia przydzielone godziny
			pracownikDAO.przydzielGodziny(pracownikRozdziel);      //
			
			
			przydzialDAO.usunPrzydzial(pomocnicza);
		}
		else System.out.println("* W bazie danych nie istnieje przydzia³ o podanym ID *");
	}
	
	
	//*********************************************************************************
	//-------------------- Lista przydzia³ów ------------------------------------------
	
	public void wyswietlListePrzydzialow() throws Exception {
		PrzedmiotDAO przedmiotDAO = new PrzedmiotDAO();
		PracownikDAO pracownikDAO = new PracownikDAO();
		
		int tmp = 0;
		int tmp2 = 0;
		String pomocnicza = null;
		
		List<Przydzial> listaPrzydzialow = przydzialDAO.pobierzPrzydzialy(0);
		
		if(listaPrzydzialow == null) System.out.println("* W bazie danych nie ma ¿adnych przydzia³ów *");
		
		else {
			System.out.println("\n***     Lista przydzia³ów     ***");
			System.out.println("---------------------------------\n");
			System.out.println("ID\tNazwa przedmiotu\t\tDane prowaadz¹cego\n");
			for(Przydzial przydzial: listaPrzydzialow) {
				
				
				System.out.print(przydzial.getIdPrzydzial() + "\t");
				
				tmp = przydzial.getIdPrzedmiot();
				Przedmiot przedmiot = przedmiotDAO.pobierzPrzedmiot(tmp);
				System.out.print(przedmiot.getNazwaPrzedmiot() + "\t\t");
				
				
				tmp = przydzial.getIdPracownik();
				Pracownik pracownik = pracownikDAO.pobierzPracownika(tmp); 
				
				tmp2 = pracownik.getStopienNaukowy();
				if(tmp2 == 1) pomocnicza = "mgr";
				else if(tmp2 == 2) pomocnicza = "dr";
				else if(tmp2 == 3) pomocnicza = "dr hab.";
				else if(tmp2 == 4) pomocnicza = "prof.";
				else pomocnicza = "b.d.";
				
				System.out.print(pomocnicza + "\t");
				System.out.println(pracownik.getImie() +" "+ pracownik.getNazwisko());
			}
		}
	}
	
}//koniec class