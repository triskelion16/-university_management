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
				
				System.out.println("\nWybierz funkcj�: ");
				
				while(cyfra) {
					try {
						akcja = Integer.parseInt(bufor.readLine());
						cyfra = false;
					} catch(NumberFormatException e) {
						System.out.println("*** B��d! Poprawny format to warto�� liczbowa! ***");	
						System.out.println("\nWybierz funkcj�: ");
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
						System.out.println("*** B��d! Podana warto�� jest nieprawid�owa! ***");
						
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
		System.out.println("Na jakie konto chcesz si� zalogowa�:\n");
		System.out.println("1 - Konto dziekana");
		System.out.println("2 - Konto kierownika katedry 'Ekonomii i statystyki'");
		System.out.println("3 - Konto kierownika katedry 'Informatyki'");
		System.out.println("4 - Konto kierownika katedry 'Zastosowa� informatyki'");
		System.out.println("5 - Konto kierownika katedry 'Zastosowa� matematyki");
		System.out.println("-------------------------------------------------------------");
		System.out.println("0 - Wyj�cie z programu");
		
	}
	
	public static void logowanieDlaDziekana() throws Exception {
		
		BufferedReader bufor = new BufferedReader(new InputStreamReader(System.in));
		
		String haslo;
		
		haslo = "dziekan";
		
		System.out.println("\nProsz� poda� has�o:");
		
		String haslo2 = bufor.readLine();
		
		if(haslo.equals(haslo2))
		{
			MenuGlowneDziekan.funkcjaGlowna();
		}
		else System.out.println("\nPodane has�o jest nieprawid�owe, nast�pi powr�t do menu wyboru.");
	}
	
	public static void logowanieDlaKierownika1() throws Exception {
		
		BufferedReader bufor = new BufferedReader(new InputStreamReader(System.in));
        
		String haslo;
		
		haslo = "kierownik1";
		
		System.out.println("\nProsz� poda� has�o:");
		
		String haslo2 = bufor.readLine();
		
		if(haslo.equals(haslo2))
		{
			MenuGlowneKierownikKatedry.funkcjaGlowna();
		}
		else System.out.println("\nPodane has�o jest nieprawid�owe, nast�pi powr�t do menu wyboru.");
	}
	
	public static void logowanieDlaKierownika2() throws Exception {
		
		BufferedReader bufor = new BufferedReader(new InputStreamReader(System.in));
		
		String haslo;
		
		haslo = "kierownik2";
		
		System.out.println("\nProsz� poda� has�o:");
		
		String haslo2 = bufor.readLine();
		
		if(haslo.equals(haslo2))
		{
			MenuGlowneKierownikKatedry.funkcjaGlowna();
		}
		else System.out.println("\nPodane has�o jest nieprawid�owe, nast�pi powr�t do menu wyboru.");
	}
	
	public static void logowanieDlaKierownika3() throws Exception {
		
		BufferedReader bufor = new BufferedReader(new InputStreamReader(System.in));

		String haslo;
		
		haslo = "kierownik3";

		System.out.println("\nProsz� poda� has�o:");
		
		String haslo2 = bufor.readLine();
		
		if(haslo.equals(haslo2))
		{
			MenuGlowneKierownikKatedry.funkcjaGlowna();
		}
		else System.out.println("\nPodane has�o jest nieprawid�owe, nast�pi powr�t do menu wyboru.");
	}
	
	public static void logowanieDlaKierownika4() throws Exception {
		
		BufferedReader bufor = new BufferedReader(new InputStreamReader(System.in));
        
		String haslo;
		
		haslo = "kierownik4";

		System.out.println("\nProsz� poda� has�o:");
		
		String haslo2 = bufor.readLine();
		
		if(haslo.equals(haslo2))
		{
			MenuGlowneKierownikKatedry.funkcjaGlowna();
		}
		else System.out.println("\nPodane has�o jest nieprawid�owe, nast�pi powr�t do menu wyboru.");
	}
}