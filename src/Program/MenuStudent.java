package Program;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import Interfejsy.StudentForm;

public class MenuStudent {
	
	public static void funkcjaStudent() throws Exception {
			
			try {
				int akcja = -1;
				StudentForm student = new StudentForm();
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
							student.dodajStudenta();
							menu();
							break;
							
						case 2:
							student.aktualizujStudenta();
							menu();
							break;
							
						case 3:
							student.usunStudenta();
							menu();
							break;
							
						case 4:
							student.wyswietlListeStudentow();
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
		System.out.println("***      Menu: Student     ***");
		System.out.println("\nDost�pne funkcje:\n");
		System.out.println("1 - Dodaj nowego studenta");
		System.out.println("2 - Edytuj istniej�cego studenta");
		System.out.println("3 - Usu� studenta z bazy danych");
		System.out.println("4 - Wy�wietl list� wszystkich student�w");
		System.out.println("0 - Wr�� do poprzedniego menu");
		System.out.println();
	}
}
