package Program;

import DAO_Packages.Database;

public class Program {

	public static void main(String[] args) throws Exception {
			
			//CreateTables ct = new CreateTables();
			//ct.createTables();
			
			naglowek();
			
			Logowanie.logowanieDoSystemu();
			
			Database db = new Database();
			db.closeConnection();
			
			komunikatKoncowy();
		
		}
		
	
	
		public static void naglowek() throws Exception {
			System.out.println("****************************************************************");
			System.out.println("***                   ZARZ¥DZANIE  PENSUM                    ***");
			System.out.println("****************************************************************");
		}
		
		public static void komunikatKoncowy() throws Exception {
			System.out.println("\n************************************************************");
			System.out.println("          -= Program zosta³ poprawnie zakoñczony =-");
			System.out.println("************************************************************");
		}
		
}