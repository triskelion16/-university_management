package Interfejsy;

import java.util.List;

import DAO_Packages.PracownikDAO;
import Obiekty.Pracownik;

public class PracownikForm extends Wyjatki{
	
	private PracownikDAO pracownikDAO;
	
	public PracownikForm() throws Exception {
		super();
		this.pracownikDAO = new PracownikDAO();
	}
	
	
	//***************************************************************************
	//------------------- Dodanie pracownika ------------------------------------
	
	public void dodajPracownika() throws Exception {
		Pracownik pracownik = new Pracownik();
		int pomocnicza = 0;
		int tmp = 0;
		
		System.out.println("\n***   Dodawanie nowego pracownika  ***");
		System.out.println("-----------------------------------\n");
		System.out.println("Podaj imi�: ");
		pracownik.setImie(bufor.readLine());
		System.out.println("Podaj nazwisko: ");
		pracownik.setNazwisko(bufor.readLine());
		System.out.println("Podaj katedr�: \n1 - Ekonometrii i statystyki\n2 - Informatyki\n3 - Zastosowa� informatyki\n4 - Zastosowa� matematyki");
		pracownik.setKatedra(stringToIntBez0());
		System.out.println("Podaj stopie� naukowy: \n1 - mgr\n2 - dr\n3 - dr hab.\n4 - prof.");
		pracownik.setStopienNaukowy(stringToIntBez0());
		System.out.println("Podaj funkcj�: \n0 - brak\n1 - kierownik katedry\n2 - prodziekan\n3 - dziekan\n4 - prorektor\n5 - rektor");
		pracownik.setFunkcja(tmp = stringToInt());
		
		if(tmp == 1) pomocnicza = 100;
		else if(tmp == 2) pomocnicza = 90;
		else if(tmp == 3) pomocnicza = 80;
		else if(tmp == 4) pomocnicza = 70;
		else if(tmp == 5) pomocnicza = 60;
		else pomocnicza = 120;
		
		pracownik.setPensum(pomocnicza);
		
		pracownikDAO.dodajPracownika(pracownik);
	}
	
	
	//****************************************************************************
	//-------------------- Aktualizacja pracownika -------------------------------
	
	public void aktualizujPracownika() throws Exception {
		Pracownik pracownik = new Pracownik();
		
		int pomocnicza = 0;
		int tmp = 0;
		int tmp2 = 0;
		
		System.out.println("\n***   Aktualizacja danych pracownika  ***");
		System.out.println("-----------------------------------------\n");
		System.out.println("Podaj ID pracownika, kt�ry ma zosta� zaktualizowany: ");
		System.out.println("(0 - wy�wietl list� pracownik�w)");
		
		tmp2 = stringToInt();
		if(tmp2 == 0) {
			wyswietlListePracownikow();
			System.out.println("\n\nPodaj ID pracownika, kt�ry ma zosta� zaktualizowany: ");
			tmp2 = stringToIntBez0();
		}
		
		//---- Sprawdzenie czy pracownik jest w bazie ----
			Pracownik pracownikBaza = pracownikDAO.pobierzPracownika(tmp2);
		
		if(pracownikBaza != null) {
			pracownik.setIdPracownika(tmp2);
				
			System.out.println("Podaj nowe imi�: ");
			pracownik.setImie(bufor.readLine());
			System.out.println("Podaj nowe nazwisko: ");
			pracownik.setNazwisko(bufor.readLine());
			System.out.println("Podaj katedr�: \n1 - Ekonometrii i statystyki\n2 - Informatyki\n3 - Zastosowa� informatyki\n4 - Zastosowa� matematyki");
			pracownik.setKatedra(stringToIntBez0());
			System.out.println("Podaj stopie� naukowy: \n1 - mgr\n2 - dr\n3 - dr hab.\n4 - prof.");
			pracownik.setStopienNaukowy(stringToIntBez0());
			System.out.println("Podaj funkcj�: \n0 - brak\n1 - kierownik katedry\n2 - prodziekan\n3 - dziekan\n4 - prorektor\n5 - rektor");
			pracownik.setFunkcja(tmp = stringToInt());
				
			if(tmp == 1) pomocnicza = 100;
			else if(tmp == 2) pomocnicza = 90;
			else if(tmp == 3) pomocnicza = 80;
			else if(tmp == 4) pomocnicza = 70;
			else if(tmp == 5) pomocnicza = 60;
			else pomocnicza = 120;
			pracownik.setPensum(pomocnicza);
				
			pracownikDAO.aktualizujPracownika(pracownik);
		}
		else System.out.println("* W bazie danych nie istnieje pracownik o podanym ID *");
	}
	
	
	//****************************************************************************
	//------------------------ Usuwanie pracownika -------------------------------
	
	public void usunPracownika() throws Exception {
		
		int tmp;
		
		System.out.println("\n***   Usuwanie pracownika z bazy danych  ***");
		System.out.println("-----------------------------------------\n");
		System.out.println("Podaj ID pracownika, kt�ry ma zosta� zwolniony: ");
		System.out.println("(0 - wy�wietl list� pracownik�w)");
		
		tmp = stringToInt();
		if(tmp == 0) {
			wyswietlListePracownikow();
			System.out.println("\n\nPodaj ID pracownika, kt�ry ma zosta� zwolniony: ");
			tmp = stringToIntBez0();
		}
		
		//---- Sprawdzenie czy pracownik jest w bazie ----
		Pracownik pracownikBaza = pracownikDAO.pobierzPracownika(tmp);
		
		if(pracownikBaza != null) {
			
			//Czy mo�na zwolni� pracownika
			if(pracownikBaza.getPrzydzieloneGodziny() == 0) pracownikDAO.usunPracownika(tmp);
			else System.out.println("* Nie mo�na zwolni� pracownika, kt�ry prowadzi zaj�cia *");
			
		}
		else System.out.println("* W bazie danych nie istnieje pracownik o podanym ID *");
	}
	
	
	//*********************************************************************************
	//-------------------- Lista wszystkich pracownik�w -------------------------------
	
	public void wyswietlListePracownikow() throws Exception {
		String pomocnicza = null;
		int tmp = 0;
		
		List<Pracownik> listaPracownikow = pracownikDAO.pobierzPracownikow(0); 
		
		if(listaPracownikow == null) System.out.println("* W bazie danych nie ma �adnych pracownik�w *");
		
		else {
			System.out.println("\n***     Lista pracownik�w     ***");
			System.out.println("---------------------------------\n");
			System.out.println("ID\tTutu�\tImi�\tNazwisko\t\tPensum\tIlo�� godzin\tKatedra\t\t\t\tFunkcja\n");
			for(Pracownik pracownik: listaPracownikow) {
				System.out.print(pracownik.getIdPracownika() + "\t");
				
				tmp = pracownik.getStopienNaukowy();
				if(tmp == 1) pomocnicza = "mgr";
				else if(tmp == 2) pomocnicza = "dr";
				else if(tmp == 3) pomocnicza = "dr hab.";
				else if(tmp == 4) pomocnicza = "prof.";
				else pomocnicza = "b.d.";
				System.out.print(pomocnicza + "\t");
				
				System.out.print(pracownik.getImie() + "\t");
				System.out.print(pracownik.getNazwisko() + "\t\t");
				System.out.print(pracownik.getPensum() + "\t");
				System.out.print(pracownik.getPrzydzieloneGodziny() + "\t\t");
				
				tmp = pracownik.getKatedra();
				if(tmp == 1) pomocnicza = "Ekonometrii i statystyki";
				else if(tmp == 2) pomocnicza = "Informatyki             ";
				else if(tmp == 3) pomocnicza = "Zastosowa� informatyki  ";
				else if(tmp == 4) pomocnicza = "Zastosowa� matematyki   ";
				else pomocnicza = "b.d.";
				System.out.print( pomocnicza + "\t");
				
				tmp = pracownik.getFunkcja();
				if(tmp == 0) pomocnicza = "brak";
				else if(tmp == 1) pomocnicza = "kierownik katedry";
				else if(tmp == 2) pomocnicza = "prodziekan";
				else if(tmp == 3) pomocnicza = "dziekan";
				else if(tmp == 4) pomocnicza = "prorektor";
				else if(tmp == 5) pomocnicza = "rektor";
				else pomocnicza = "b.d.";
				System.out.println(pomocnicza);
			}
		}
	}
	
}//koniec class
