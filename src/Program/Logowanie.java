package Program;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Logowanie {
	
	public static void logowanieDoSystemu() throws Exception {	
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
				}// end while
			
				switch(akcja) {
					case 1:
						Logowanie.logowanieDlaDziekana();
						menu();
						break;
						
					case 2:
						Logowanie.logowanieDlaKierownika1();
						menu();
						break;
						
					case 3:
						Logowanie.logowanieDlaKierownika2();
						menu();
						break;
						
					case 4:
						Logowanie.logowanieDlaKierownika3();
						menu();
						break;
						
					case 5:
						Logowanie.logowanieDlaKierownika4();
						menu();
						break;
						
					case 0:
						break;
						
					default:
						System.out.println("*** B³¹d! Podana wartoœæ jest nieprawid³owa! ***");
						
				}// end switch
			}// end while
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}
	
	private static void menu() throws Exception {
		
		System.out.println("\n\n\n***********************************************************");
		System.out.println("***                  Logowanie do systemu               ***\n\n");
		System.out.println("Na jakie konto chcesz siê zalogowaæ:\n");
		System.out.println("1 - Konto dziekana");
		System.out.println("2 - Konto kierownika katedry 'Ekonomii i statystyki'");
		System.out.println("3 - Konto kierownika katedry 'Informatyki'");
		System.out.println("4 - Konto kierownika katedry 'Zastosowañ informatyki'");
		System.out.println("5 - Konto kierownika katedry 'Zastosowañ matematyki");
		System.out.println("-------------------------------------------------------------");
		System.out.println("0 - Wyjœcie z programu");
		
	}
	
	public static void logowanieDlaDziekana() throws Exception {
		
		BufferedReader bufor = new BufferedReader(new InputStreamReader(System.in));
		
		String haslo;
		
		haslo = "dziekan";
		
		System.out.println("\nProszê podaæ has³o:");
		
		String haslo2 = bufor.readLine();
		
		if(haslo.equals(haslo2))
		{
			MenuGlowneDziekan.funkcjaGlowna();
		}
		else System.out.println("\nPodane has³o jest nieprawid³owe, nast¹pi powrót do menu wyboru.");
	}
	
	public static void logowanieDlaKierownika1() throws Exception {
		
		BufferedReader bufor = new BufferedReader(new InputStreamReader(System.in));
        
		String haslo;
		
		haslo = "kierownik1";
		
		System.out.println("\nProszê podaæ has³o:");
		
		String haslo2 = bufor.readLine();
		
		if(haslo.equals(haslo2))
		{
			MenuGlowneKierownikKatedry.funkcjaGlowna();
		}
		else System.out.println("\nPodane has³o jest nieprawid³owe, nast¹pi powrót do menu wyboru.");
	}
	
	public static void logowanieDlaKierownika2() throws Exception {
		
		BufferedReader bufor = new BufferedReader(new InputStreamReader(System.in));
		
		String haslo;
		
		haslo = "kierownik2";
		
		System.out.println("\nProszê podaæ has³o:");
		
		String haslo2 = bufor.readLine();
		
		if(haslo.equals(haslo2))
		{
			MenuGlowneKierownikKatedry.funkcjaGlowna();
		}
		else System.out.println("\nPodane has³o jest nieprawid³owe, nast¹pi powrót do menu wyboru.");
	}
	
	public static void logowanieDlaKierownika3() throws Exception {
		
		BufferedReader bufor = new BufferedReader(new InputStreamReader(System.in));

		String haslo;
		
		haslo = "kierownik3";

		System.out.println("\nProszê podaæ has³o:");
		
		String haslo2 = bufor.readLine();
		
		if(haslo.equals(haslo2))
		{
			MenuGlowneKierownikKatedry.funkcjaGlowna();
		}
		else System.out.println("\nPodane has³o jest nieprawid³owe, nast¹pi powrót do menu wyboru.");
	}
	
	public static void logowanieDlaKierownika4() throws Exception {
		
		BufferedReader bufor = new BufferedReader(new InputStreamReader(System.in));
        
		String haslo;
		
		haslo = "kierownik4";

		System.out.println("\nProszê podaæ has³o:");
		
		String haslo2 = bufor.readLine();
		
		if(haslo.equals(haslo2))
		{
			MenuGlowneKierownikKatedry.funkcjaGlowna();
		}
		else System.out.println("\nPodane has³o jest nieprawid³owe, nast¹pi powrót do menu wyboru.");
	}
}