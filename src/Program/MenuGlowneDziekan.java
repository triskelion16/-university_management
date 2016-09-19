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
						System.out.println("*** B��d! Podana warto�� jest nieprawid�owa! ***");
						
				}// koniec: switch
			}// koniec: while
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}// koniec funkcjaGlowna
	
	
	private static void menu() throws Exception {
		System.out.println("\n\n********************************");
		System.out.println("***       Menu g��wne        ***");
		System.out.println("\nDost�pne funkcje:\n");
		System.out.println("1 - Menu: Przydzia�u");
		System.out.println("2 - Menu: Pracownik");
		System.out.println("3 - Menu: Przedmiot");
		System.out.println("4 - Menu: Student");
		System.out.println("\n9 - Wy�wietl raport");
		System.out.println("------------------------");
		System.out.println("0 - Wyloguj");
		System.out.println();
	}
	
}

