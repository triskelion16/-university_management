package Program;

import java.util.List;

import DAO_Packages.PracownikDAO;
import Obiekty.Pracownik;

public class Raport {
	
	
	public static void wyswietlRaport() throws Exception {
		
		PracownikDAO pracownikDAO = new PracownikDAO();
		
		int tmp = 0;
		int pensum = 0;
		int godziny = 0;
		int roznica = 0;
		String nazwa = null;
		
		List<Pracownik> listaPracownikow = pracownikDAO.pobierzPracownikow(0);
		
		
		if(listaPracownikow == null) System.out.println("* W bazie danych nie ma ¿adnych pracowników *");
		
		else {
			System.out.println("\n**************************************************************************************");
			System.out.println("*************                           Raport                           *************");
			System.out.println("**************************************************************************************\n\n");
			
			//System.out.println("\n***     Lista pracowników     ***");
			//System.out.println("---------------------------------\n");
			System.out.println("ID\tTytu³\t\tImiê\t\tNazwisko\t\tKatedra\t\t\t\tCzy prawid³owo przydzielono liczbê godzin\n");
			for(Pracownik pracownik: listaPracownikow) {
				
				if(pracownik.getPensum() != pracownik.getPrzydzieloneGodziny()) {
					
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
					if(roznica > 0) System.out.println("--- Przydzielono za ma³o godzin ---");
					else System.out.println("+++ Przekroczono liczbê godzin +++");
				}
			}
		}
	}
}
