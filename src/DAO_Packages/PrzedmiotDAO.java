package DAO_Packages;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import Obiekty.Przedmiot;

public class PrzedmiotDAO extends Database {
	
	public PrzedmiotDAO() throws Exception {
		super();
	}
	
	
	//***************************************************************************
	//------------------- Dodanie przedmiotu ------------------------------------
	
	public void dodajPrzedmiot(Przedmiot przedmiot) throws Exception {
		
		if(przedmiot == null)
			throw new Exception("Nie mo¿na zapisaæ obiektu 'Przedmiot', który nie istnieje!");
		
		String insertQuery = "INSERT INTO Przedmioty(nazwaPrzedmiot, katedra, wyklady, cwiczenia, laboratoria, czyObsadzony) VALUES(?,?,?,?,?,?)";
		
		PreparedStatement stmt = this.conn.prepareStatement(insertQuery);
		stmt.setString(1, przedmiot.getNazwaPrzedmiot());
		stmt.setInt(2, przedmiot.getKatedra());
		stmt.setInt(3, przedmiot.getWyklady());
		stmt.setInt(4, przedmiot.getCwiczenia());
		stmt.setInt(5, przedmiot.getLaboratoria());
		stmt.setBoolean(6, false);
		
		stmt.execute();
		stmt.close();
		
		System.out.println("*** Pomyœlnie dodano przedmiot do bazy danych ***");
	}
	
	
	//****************************************************************************
	//-------------------- Aktualizacja przedmiotu -------------------------------

	public void aktualizujPrzedmiot(Przedmiot przedmiot) throws Exception {
		if(przedmiot == null)
			throw new Exception("Obiekt 'Przedmiot' nie mo¿e byæ pusty!");
		
		String updateQuery = "UPDATE Przedmioty SET nazwaPrzedmiot = ?, katedra = ?, wyklady = ?, cwiczenia = ?, laboratoria = ?, czyObsadzony = ? WHERE idPrzedmiot = ?";
		
		PreparedStatement stmt = this.conn.prepareStatement(updateQuery);
		stmt.setString(1, przedmiot.getNazwaPrzedmiot());
		stmt.setInt(2, przedmiot.getKatedra());
		stmt.setInt(3, przedmiot.getWyklady());
		stmt.setInt(4, przedmiot.getCwiczenia());
		stmt.setInt(5, przedmiot.getLaboratoria());
		stmt.setBoolean(6, false);
		stmt.setInt(7, przedmiot.getIdPrzedmiot());
		
		stmt.execute();
		stmt.close();
		
		System.out.println("\n*** Pomyœlnie zaktuazizowano przedmiot w bazie danych ***");
	}
	
	
	//****************************************************************************
	//------------------------ Usuñ przedmiot -----------------------------------
	
	public void usunPrzedmiot(int id) throws Exception {
		if(id == 0)
			throw new Exception("Nale¿y podaæ ID usuwanego przedmiotu!");
		
		String deleteQuery = "DELETE FROM Przedmioty WHERE idPrzedmiot = ?";
		
		PreparedStatement stmt = this.conn.prepareStatement(deleteQuery);
		stmt.setInt(1, id);
		
		stmt.execute();
		stmt.close();
		
		System.out.println("*** Pomyœlnie usuniêto przedmiot z bazy danych ***");
	}
	
	
	//*******************************************************************
	//----------------- Lista wszystkich przedmiotów --------------------
	
	public List<Przedmiot> pobierzPrzedmioty(int id) throws Exception {
		List<Przedmiot> listaPrzedmiotow = new ArrayList<Przedmiot>();
		
		String selectQuery = "SELECT * FROM Przedmioty";
		
		if(id > 0) selectQuery += " WHERE idPrzedmiot = ?";
		
		PreparedStatement stmt = this.conn.prepareStatement(selectQuery);
		
		if(id > 0) stmt.setInt(1, id);
		
		ResultSet rs = stmt.executeQuery();
		
		while(rs.next()) {
			Przedmiot p = new Przedmiot();
			p.setIdPrzedmiot(rs.getInt("idPrzedmiot"));
			p.setNazwaPrzedmiot(rs.getString("nazwaPrzedmiot"));
			p.setKatedra(rs.getInt("katedra"));
			p.setWyklady(rs.getInt("wyklady"));
			p.setCwiczenia(rs.getInt("cwiczenia"));
			p.setLaboratoria(rs.getInt("laboratoria"));
			p.setCzyObsadzony(rs.getBoolean("czyObsadzony"));
			
			listaPrzedmiotow.add(p);
		}
		
		rs.close();
		stmt.close();
		
		return listaPrzedmiotow;
	}
	
	//*******************************************************************
	//--------------------- Przedmiot w bazie -----------------------
	
	public Przedmiot pobierzPrzedmiot(int id) throws Exception  {
		List<Przedmiot> listaPrzedmiotow = this.pobierzPrzedmioty(id);
			
		if(listaPrzedmiotow.size() > 0) return listaPrzedmiotow.get(0);
			
		else return null;
	}
		
	
	//*******************************************************************
	//----------------- Lista dostêpnych przedmiotów --------------------
		
	public List<Przedmiot> pobierzDostepnePrzedmioty() throws Exception {
		List<Przedmiot> listaPrzedmiotow = new ArrayList<Przedmiot>();
			
		String selectQuery = "SELECT * FROM Przedmioty WHERE czyObsadzony = ?";
			
		PreparedStatement stmt = this.conn.prepareStatement(selectQuery);
		
		stmt.setBoolean(1, false);
		
		ResultSet rs = stmt.executeQuery();
			
		while(rs.next()) {
			Przedmiot p = new Przedmiot();
			p.setIdPrzedmiot(rs.getInt("idPrzedmiot"));
			p.setNazwaPrzedmiot(rs.getString("nazwaPrzedmiot"));
			p.setKatedra(rs.getInt("katedra"));
			p.setWyklady(rs.getInt("wyklady"));
			p.setCwiczenia(rs.getInt("cwiczenia"));
			p.setLaboratoria(rs.getInt("laboratoria"));
			p.setCzyObsadzony(rs.getBoolean("czyObsadzony"));
				
			listaPrzedmiotow.add(p);
		}
			
		rs.close();
		stmt.close();
		
		if(listaPrzedmiotow.size() > 0) return listaPrzedmiotow;
		
		else return null;
	}
	
	
	//*******************************************************************
	//--------- set czyObsadzony ------------
	
	public void czyObsadzony(Przedmiot przedmiot) throws Exception {
		if(przedmiot == null)
			throw new Exception("* B³¹d przy próbie obsadzenia przedmiotu *");
		
		String updateQuery = "UPDATE Przedmioty SET czyObsadzony = ? WHERE idPrzedmiot = ?";
		
		PreparedStatement stmt = this.conn.prepareStatement(updateQuery);
		stmt.setBoolean(1, przedmiot.isCzyObsadzony());
		stmt.setInt(2, przedmiot.getIdPrzedmiot());
		
		stmt.execute();
		stmt.close();
	}
	
}// koniec: Class
