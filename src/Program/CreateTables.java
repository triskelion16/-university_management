package Program;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class CreateTables {
	private Connection conn = null;
	private Statement stat = null;
	
	public void createTables() throws Exception {
		
		Class.forName("org.sqlite.JDBC");
		this.conn = DriverManager.getConnection("jdbc:sqlite:baza_pensum.s3db");
		System.out.println("Pomyœlnie utworzono po³¹czenie z baz¹ danych.");
		
		stat = conn.createStatement();
		
		
		//------------------------ Tabela Pracownicy --------------------------
		String usunPracownicyTab = "DROP TABLE Pracownicy";
        stat.execute(usunPracownicyTab);
		
        String createPracownicyTab = "CREATE TABLE IF NOT EXISTS Pracownicy " +
                                  "(idPracownik INTEGER PRIMARY KEY AUTOINCREMENT, " +
        		                  "imie      			 nvarchar(30)      NOT NULL, " +
                                  "nazwisko  			 nvarchar(40)      NOT NULL, " +
        		                  "katedra    			 int               NOT NULL, " +
                                  "stopienNaukowy   	 int		       NOT NULL, " +
        						  "funkcja		   	     int		       NOT NULL, " +
        						  "pensum		    	 int		       NOT NULL, " +
        						  "przydzieloneGodziny	 int		       NOT NULL)";
        
        
        String usunPrzedmiotyTab = "DROP TABLE Przedmioty";
        stat.execute(usunPrzedmiotyTab);
        
        
        //--------------------- Tabela Przedmioty --------------------------
        String createPrzedmiotyTab = "CREATE TABLE IF NOT EXISTS Przedmioty " +
                                    "(idPrzedmiot INTEGER PRIMARY KEY AUTOINCREMENT, " +
        		                    "nazwaPrzedmiot         varchar(50)      NOT NULL, " +
                                    "katedra                int		         NOT NULL, " +
        		                    "wyklady    			int     		 NOT NULL, " +
                                    "cwiczenia              int              NOT NULL, " +
                                    "laboratoria            int              NOT NULL, " +
        		                    "czyObsadzony           boolean          NOT NULL)";
        		                    
         
        //--------------------- Tabela Przydzia³y --------------------------
        String usunPrzydzialyTab = "DROP TABLE Przydzialy";
        stat.execute(usunPrzydzialyTab);
        
        String createPrzydzialyTab = "CREATE TABLE IF NOT EXISTS Przydzialy " +
        		                      "(idPrzydzial INTEGER PRIMARY KEY AUTOINCREMENT, " +
        		                      "idPracownik         int        NOT NULL, " +
        		                      "idPrzedmiot         int        NOT NULL)"; 
        
        
        //--------------------- Tabela Studenci --------------------------
        String usunStudenciTab = "DROP TABLE Studenci";
        stat.execute(usunStudenciTab);
        
        String createStudenciTab = "CREATE TABLE IF NOT EXISTS Studenci " +
        		                      "(idStudent INTEGER PRIMARY KEY AUTOINCREMENT, " +
        		                      "imie      			 nvarchar(30)      NOT NULL, " +
                                      "nazwisko  			 nvarchar(40)      NOT NULL, " +
            		                  "kierunek    			 int               NOT NULL, " +
                                      "tryb				   	 int		       NOT NULL, " +
            						  "nrSemestru	   	     int		       NOT NULL, " +
            						  "grupa		    	 int		       NOT NULL)";
        
        
        
        stat.execute(createPracownicyTab);
        System.out.println("Tabela 'Pracownicy' zosta³a utworzona pomyœlnie.");
        stat.execute(createPrzedmiotyTab);
        System.out.println("Tabela 'Przedmioty' zosta³a utworzona pomyœlnie.");
        stat.execute(createPrzydzialyTab);
        System.out.println("Tabela 'Przydzia³y' zosta³a utworzona pomyœlnie.");
        stat.execute(createStudenciTab);
        System.out.println("Tabela 'Studenci' zosta³a utworzona pomyœlnie.");
       
        
        stat.close();
        conn.close();
        System.out.println("Po³¹czenie zosta³o pomyœlnie zamkniête.\n");
    }
}