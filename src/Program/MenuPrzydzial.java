package Program;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import Interfejsy.PrzydzialForm;

public class MenuPrzydzial {
	
	public static void funkcjaPrzydzial() throws Exception {
		
		try {
			int akcja = -1;
			PrzydzialForm przydzial = new PrzydzialForm();
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
						przydzial.dodajPrzydzial();
						menu();
						break;
						
					case 2:
						przydzial.usunPrzydzial();
						menu();
						break;
						
					case 3:
						przydzial.wyswietlListePrzydzialow();
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
	System.out.println("***      Menu: Przydzia�u     ***");
	System.out.println("\nDost�pne funkcje:\n");
	System.out.println("1 - Przydziel pracownika do przedmiotu");
	System.out.println("2 - Usuni�cie powi�zania");
	System.out.println("3 - Wy�wietl list� wszystkich przydzia��w");
	System.out.println("0 - Wr�� do poprzedniego menu");
	System.out.println();
}
}
