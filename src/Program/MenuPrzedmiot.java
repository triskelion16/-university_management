package Program;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import Interfejsy.PrzedmiotForm;

public class MenuPrzedmiot {
	
	public static void funkcjaPrzedmiot() throws Exception {
			
			try {
				int akcja = -1;
				PrzedmiotForm przedmiot = new PrzedmiotForm();
				BufferedReader bufor = new BufferedReader(new InputStreamReader(System.in));
				
				menu();
				
				while(akcja != 0) {
					boolean cyfra = true;
					
					System.out.println("\nWybierz funkcj�: ");
					
					while(cyfra) {
						try {
							akcja = Integer.parseInt(bufor.readLine());
							cyfra = false;
						} catch(NumberFormatException e) {
							System.out.println("*** B��d! Poprawny format to warto�� liczbowa! ***");	
							System.out.println("\nWybierz funkcj�: ");
						}
					}// koniec: while
				
					switch(akcja) {
						case 1:
							przedmiot.dodajPrzedmiot();
							menu();
							break;
							
						case 2:
							przedmiot.aktualizujPrzedmiot();
							menu();
							break;
							
						case 3:
							przedmiot.usunPrzedmiot();
							menu();
							break;
							
						case 4:
							przedmiot.wyswietlListePrzedmiotow();
							menu();
							break;
							
						case 0:
							break;
							
						default:
							System.out.println("*** B��d! Podana warto�� jest nieprawid�owa! ***");
					}// koniec: switch
				}// koniec: while
				
			} catch (Exception e) {
				System.out.println(e.getMessage());
				e.printStackTrace();
		}
	}
		
	private static void menu() throws Exception {
		System.out.println("\n\n\n********************************");
		System.out.println("***      Menu: Przedmiot     ***");
		System.out.println("\nDost�pne funkcje:\n");
		System.out.println("1 - Dodaj nowy przedmiot");
		System.out.println("2 - Edytuj istniej�cy przedmiot");
		System.out.println("3 - Usu� przedmiot z bazy danych");
		System.out.println("4 - Wy�wietl list� wszystkich przedmiot�w");
		System.out.println("0 - Wr�� do poprzedniego menu");
		System.out.println();
	}
}
