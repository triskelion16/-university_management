package DAO_Packages;

import java.sql.Connection;
import java.sql.DriverManager;

//-----------Klasa nadrzêdna dla .DAO------------


public class Database {
	
	protected Connection conn = null;
	
	public Database() throws Exception {
		Class.forName("org.sqlite.JDBC");
		this.conn = DriverManager.getConnection("jdbc:sqlite:baza_pensum.s3db");
		//System.out.println("*** Pomyœlnie utworzono po³¹czenie z baz¹ danych ***");
	}
	
	public void closeConnection() throws Exception {
		if(!this.conn.isClosed()) {
			this.conn.close();
			System.out.println("*** Po³¹czenie z baz¹ danych zosta³o pomyœlnie zamkniête. ***");
		}
	}
}