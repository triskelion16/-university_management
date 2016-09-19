package Program;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import Interfejsy.PracownikForm;
import Interfejsy.PrzedmiotForm;

public class MenuGlowneKierownikKatedry {
	
	public static void funkcjaGlowna() throws Exception {
		try {
			int akcja = -1;
			PracownikForm pracownik = new PracownikForm();
			PrzedmiotForm przedmiot = new PrzedmiotForm();
			BufferedReader bufor = new BufferedReader(new InputStreamReader(System.in));
			
			menu();
			
			while(akcja != 0) {
				boolean cyfra = true;
				
				System.out.println("\nWybierz funkcjê: ");
				
				while(cyfra) {
					try {
						akcja = Integer.parseInt(bufor.readLine());
						cyfra = false;
					} catch(NumberFormatException e) {
						System.out.println("*** B³¹d! Poprawny format to wartoœæ liczbowa! ***");	
						System.out.println("\nWybierz funkcjê: ");
					}
				}// koniec: while
			
				switch(akcja) {
					case 1:
						MenuPrzydzial.funkcjaPrzydzial();
						menu();
						break;
						
					case 2:
						pracownik.wyswietlListePracownikow();
						menu();
						break;
						
					case 3:
						przedmiot.wyswietlListePrzedmiotow();
						menu();
						break;
						
					case 9:
						Raport.wyswietlRaport();
						menu();
						break;
						
					case 0:
						break;
						
					default:
						System.out.println("*** B³¹d! Podana wartoœæ jest nieprawid³owa! ***");
						
				}// koniec: switch
			}// koniec: while
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}// koniec funkcjaGlowna
	
	
	private static void menu() throws Exception {
		System.out.println("\n\n********************************");
		System.out.println("***       Menu g³ówne        ***");
		System.out.println("\nDostêpne funkcje:\n");
		System.out.println("1 - Menu: Przydzia³u");
		System.out.println("2 - Wyœwietl pracowników");
		System.out.println("3 - Wyœwietl przedmioty");
		System.out.println("\n9 - Wyœwietl raport");
		System.out.println("------------------------");
		System.out.println("0 - Wyloguj");
		System.out.println();
	}
	
}

