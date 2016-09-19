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
		System.out.println("***      Menu: Student     ***");
		System.out.println("\nDostêpne funkcje:\n");
		System.out.println("1 - Dodaj nowego studenta");
		System.out.println("2 - Edytuj istniej¹cego studenta");
		System.out.println("3 - Usuñ studenta z bazy danych");
		System.out.println("4 - Wyœwietl listê wszystkich studentów");
		System.out.println("0 - Wróæ do poprzedniego menu");
		System.out.println();
	}
}
