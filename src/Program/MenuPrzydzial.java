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
						System.out.println("*** B³¹d! Podana wartoœæ jest nieprawid³owa! ***");
				}// koniec: switch
			}// koniec: while
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
	}
}
	
private static void menu() throws Exception {
	System.out.println("\n\n\n********************************");
	System.out.println("***      Menu: Przydzia³u     ***");
	System.out.println("\nDostêpne funkcje:\n");
	System.out.println("1 - Przydziel pracownika do przedmiotu");
	System.out.println("2 - Usuniêcie powi¹zania");
	System.out.println("3 - Wyœwietl listê wszystkich przydzia³ów");
	System.out.println("0 - Wróæ do poprzedniego menu");
	System.out.println();
}
}
