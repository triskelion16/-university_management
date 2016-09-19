package Program;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import Interfejsy.PracownikForm;

public class MenuPracownik {
	
	public static void funkcjaPracownik() throws Exception {
			
			try {
				int akcja = -1;
				PracownikForm pracownik = new PracownikForm();
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
							pracownik.dodajPracownika();
							menu();
							break;
							
						case 2:
							pracownik.aktualizujPracownika();
							menu();
							break;
							
						case 3:
							pracownik.usunPracownika();
							menu();
							break;
							
						case 4:
							pracownik.wyswietlListePracownikow();
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
		System.out.println("***      Menu: Pracownik     ***");
		System.out.println("\nDost�pne funkcje:\n");
		System.out.println("1 - Dodaj nowego pracownika");
		System.out.println("2 - Edytuj istniej�cego pracownika");
		System.out.println("3 - Usu� pracownika z bazy danych");
		System.out.println("4 - Wy�wietl list� wszystkich pracownik�w");
		System.out.println("0 - Wr�� do poprzedniego menu");
		System.out.println();
	}
}
