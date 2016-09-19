package Program;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class MenuGlowneDziekan {
	
	public static void funkcjaGlowna() throws Exception {
		try {
			int akcja = -1;
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
						MenuPracownik.funkcjaPracownik();
						menu();
						break;
						
					case 3:
						MenuPrzedmiot.funkcjaPrzedmiot();
						menu();
						break;
						
					case 4:
						MenuStudent.funkcjaStudent();
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
		System.out.println("2 - Menu: Pracownik");
		System.out.println("3 - Menu: Przedmiot");
		System.out.println("4 - Menu: Student");
		System.out.println("\n9 - Wyœwietl raport");
		System.out.println("------------------------");
		System.out.println("0 - Wyloguj");
		System.out.println();
	}
	
}

