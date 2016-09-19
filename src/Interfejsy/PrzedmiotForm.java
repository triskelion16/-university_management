package Interfejsy;

import java.util.List;

import DAO_Packages.PrzedmiotDAO;
import Obiekty.Przedmiot;

public class PrzedmiotForm extends Wyjatki{
	
	private PrzedmiotDAO przedmiotDAO;
	
	public PrzedmiotForm() throws Exception {
		super();
		this.przedmiotDAO = new PrzedmiotDAO();
	}
	
	
	//***************************************************************************
	//------------------- Dodanie przedmiotu ------------------------------------
	
	public void dodajPrzedmiot() throws Exception {
		Przedmiot przedmiot = new Przedmiot();
		
		System.out.println("\n***   Dodawanie nowego przedmiotu  ***");
		System.out.println("-----------------------------------\n");
		System.out.println("Podaj nazw� przedmiotu: ");
		przedmiot.setNazwaPrzedmiot(bufor.readLine());
		System.out.println("Podaj katedr�: \n1 - Ekonometrii i statystyki\n2 - Informatyki\n3 - Zastosowa� informatyki\n4 - Zastosowa� matematyki");
		przedmiot.setKatedra(stringToIntBez0());
		System.out.println("Podaj ilo�� godzin wyk�ad�w:");
		przedmiot.setWyklady(stringToInt());
		System.out.println("Podaj ilo�� godzin �wicze�:");
		przedmiot.setCwiczenia(stringToInt());
		System.out.println("Podaj ilo�� godzin laboratori�w:");
		przedmiot.setLaboratoria(stringToInt());
		
		przedmiotDAO.dodajPrzedmiot(przedmiot);
	}
	
	
	//****************************************************************************
	//-------------------- Aktualizacja przedmiotu -------------------------------
	
	public void aktualizujPrzedmiot() throws Exception {
		Przedmiot przedmiot = new Przedmiot();
		
		int tmp2 = 0;
		
		System.out.println("\n***   Aktualizacja danych przedmiotu  ***");
		System.out.println("-----------------------------------------\n");
		System.out.println("Podaj ID przedmiotu, kt�ry ma zosta� zaktualizowany: ");
		System.out.println("(0 - wy�wietl list� przedmiot�w)");
		
		tmp2 = stringToInt();
		if(tmp2 == 0) {
			wyswietlListePrzedmiotow();
			System.out.println("\n\nPodaj ID przedmiotu, kt�ry ma zosta� zaktualizowany: ");
			tmp2 = stringToIntBez0();
		}
		
		//---- Sprawdzenie czy przedmiot jest w bazie ----
			Przedmiot przedmiotBaza = przedmiotDAO.pobierzPrzedmiot(tmp2);
		
		if(przedmiotBaza != null) {
			przedmiot.setIdPrzedmiot(tmp2);
				
			System.out.println("Podaj now� nazw� przedmiotu: ");
			przedmiot.setNazwaPrzedmiot(bufor.readLine());
			System.out.println("Podaj now� katedr�: \n1 - Ekonometrii i statystyki\n2 - Informatyki\n3 - Zastosowa� informatyki\n4 - Zastosowa� matematyki");
			przedmiot.setKatedra(stringToIntBez0());
			System.out.println("Podaj now� ilo�� godzin wyk�ad�w:");
			przedmiot.setWyklady(stringToInt());
			System.out.println("Podaj now� ilo�� godzin �wicze�:");
			przedmiot.setCwiczenia(stringToInt());
			System.out.println("Podaj now� ilo�� godzin laboratori�w:");
			przedmiot.setLaboratoria(stringToInt());
				
			przedmiotDAO.aktualizujPrzedmiot(przedmiot);
		}
		else System.out.println("* W bazie danych nie istnieje przedmiot o podanym ID *");
	}
	
	
	//****************************************************************************
	//------------------------ Usuwanie przedmiotu -------------------------------
	
	public void usunPrzedmiot() throws Exception {
		
		int tmp;
		
		System.out.println("\n***   Usuwanie przedmiotu z bazy danych  ***");
		System.out.println("-----------------------------------------\n");
		System.out.println("Podaj ID przedmiotu, kt�ry ma zosta� usuni�ty: ");
		System.out.println("(0 - wy�wietl list� przedmiot�w)");
		
		tmp = stringToInt();
		if(tmp == 0) {
			wyswietlListePrzedmiotow();
			System.out.println("\n\nPodaj ID przedmiotu, kt�ry ma zosta� usuni�ty: ");
			tmp = stringToIntBez0();
		}
		
		//---- Sprawdzenie czy przedmiot jest w bazie ----
		Przedmiot przedmiotBaza = przedmiotDAO.pobierzPrzedmiot(tmp);
		
		if(przedmiotBaza != null) {
			if(przedmiotBaza.isCzyObsadzony() == false) przedmiotDAO.usunPrzedmiot(tmp);
			else System.out.println("* Nie mo�na usun�� przedmiotu, kt�ry jest prowadzony przez pracownika *");
		}
		else System.out.println("* W bazie danych nie istnieje przedmiot o podanym ID *");
	}
	
	
	//*********************************************************************************
	//-------------------- Lista wszystkich przedmiot�w -------------------------------
	
	public void wyswietlListePrzedmiotow() throws Exception {
		String pomocnicza = null;
		int tmp = 0;
		
		List<Przedmiot> listaPrzedmiotow = przedmiotDAO.pobierzPrzedmioty(0); 
		
		if(listaPrzedmiotow == null) System.out.println("* W bazie danych nie ma �adnych przedmiot�w *");
		
		else {
			System.out.println("\n***     Lista przedmiotow     ***");
			System.out.println("---------------------------------\n");
			System.out.println("ID\tNazwa przedmiotu\t\tWyk�ady\t\t�wiczenia\tLaboratoria\tCzy obsadzony\tKatedra\n");
			for(Przedmiot przedmiot: listaPrzedmiotow) {
				System.out.print(przedmiot.getIdPrzedmiot() + "\t");
				System.out.print(przedmiot.getNazwaPrzedmiot() + "\t\t");
				System.out.print(przedmiot.getWyklady() + "\t\t");
				System.out.print(przedmiot.getCwiczenia() + "\t\t");
				System.out.print(przedmiot.getLaboratoria() + "\t\t");
				System.out.print(przedmiot.isCzyObsadzony() + "\t\t");
				
				tmp = przedmiot.getKatedra();
				if(tmp == 1) pomocnicza = "Ekonometrii i statystyki";
				else if(tmp == 2) pomocnicza = "Informatyki             ";
				else if(tmp == 3) pomocnicza = "Zastosowa� informatyki  ";
				else if(tmp == 4) pomocnicza = "Zastosowa� matematyki   ";
				else pomocnicza = "b.d.";
				System.out.print( pomocnicza + "\n");
				
			}
		}
	}
	
}//koniec class