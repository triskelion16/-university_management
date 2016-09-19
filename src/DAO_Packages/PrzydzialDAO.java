package DAO_Packages;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import Obiekty.Przydzial;

public class PrzydzialDAO extends Database {
	
	public PrzydzialDAO() throws Exception {
		super();
	}
	
	
	//***************************************************************************
	//------------------------ Przydzielenie ------------------------------------
	
	public void dodajPrzydzial(Przydzial przydzial) throws Exception {
		
		if(przydzial == null)
			throw new Exception("Nie mo¿na zapisaæ obiektu 'Przydzial', który nie istnieje!");
		
		String insertQuery = "INSERT INTO Przydzialy(idPracownik, idPrzedmiot) VALUES(?,?)";
		
		PreparedStatement stmt = this.conn.prepareStatement(insertQuery);
		stmt.setInt(1, przydzial.getIdPracownik());
		stmt.setInt(2, przydzial.getIdPrzedmiot());
		
		stmt.execute();
		stmt.close();
		
		System.out.println("*** Pomyœlnie dodano nowy przydzia³ do bazy danych ***");
	}
	
	
	//****************************************************************************
	//--------------------------- Rozdzielenie -----------------------------------
	
	public void usunPrzydzial(int id) throws Exception {
		if(id == 0)
			throw new Exception("Nale¿y podaæ ID usuwanego przydzia³u!");
		
		String deleteQuery = "DELETE FROM Przydzialy WHERE idPrzydzial = ?";
		
		PreparedStatement stmt = this.conn.prepareStatement(deleteQuery);
		stmt.setInt(1, id);
		
		stmt.execute();
		stmt.close();
		
		System.out.println("*** Pomyœlnie usuniêto przydzia³ z bazy danych ***");
	}
	
	
	//*******************************************************************
	//--------------------- Lista przydzia³ów ---------------------------
	
	public List<Przydzial> pobierzPrzydzialy(int id) throws Exception {
		List<Przydzial> listaPrzydzialow = new ArrayList<Przydzial>();
		
		String selectQuery = "SELECT * FROM Przydzialy";
		
		if(id > 0) selectQuery += " WHERE idPrzydzial = ?";
		
		PreparedStatement stmt = this.conn.prepareStatement(selectQuery);
		
		if(id > 0) stmt.setInt(1, id);
		
		ResultSet rs = stmt.executeQuery();
		
		while(rs.next()) {
			Przydzial p = new Przydzial();
			p.setIdPrzydzial(rs.getInt("idPrzydzial"));
			p.setIdPracownik(rs.getInt("idPracownik"));
			p.setIdPrzedmiot(rs.getInt("idPrzedmiot"));
			
			listaPrzydzialow.add(p);
		}
		
		rs.close();
		stmt.close();
		
		return listaPrzydzialow;
	}
	
	//*******************************************************************
	//---------------------- Przydzial w bazie --------------------------
	
		public Przydzial pobierzPrzydzial(int id) throws Exception  {
			List<Przydzial> listaPrzydzialow = this.pobierzPrzydzialy(id);
			
			if(listaPrzydzialow.size() > 0) return listaPrzydzialow.get(0);
			
			else return null;
		}
	
}// koniec: Class
