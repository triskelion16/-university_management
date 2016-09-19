package DAO_Packages;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import Obiekty.Pracownik;

public class PracownikDAO extends Database{
	
	public PracownikDAO() throws Exception {
		super();
	}
	
	//***************************************************************************
	//------------------- Dodanie pracownika ------------------------------------
	
	public void dodajPracownika(Pracownik pracownik) throws Exception {
		
		if(pracownik == null)
			throw new Exception("Nie mo¿na zapisaæ obiektu 'Pracownik', który nie istnieje!");
		
		String insertQuery = "INSERT INTO Pracownicy(imie, nazwisko, katedra, stopienNaukowy, funkcja, pensum, przydzieloneGodziny) VALUES(?,?,?,?,?,?,?)";
		
		PreparedStatement stmt = this.conn.prepareStatement(insertQuery);
		stmt.setString(1, pracownik.getImie());
		stmt.setString(2, pracownik.getNazwisko());
		stmt.setInt(3, pracownik.getKatedra());
		stmt.setInt(4, pracownik.getStopienNaukowy());
		stmt.setInt(5, pracownik.getFunkcja());
		stmt.setInt(6, pracownik.getPensum());
		stmt.setInt(7, 0);
		
		stmt.execute();
		stmt.close();
		
		System.out.println("*** Pomyœlnie dodano pracownika do bazy danych ***");
	}
	
	
	//****************************************************************************
	//-------------------- Aktualizacja pracownika -------------------------------

	public void aktualizujPracownika(Pracownik pracownik) throws Exception {
		if(pracownik == null)
			throw new Exception("Obiekt 'Pracownik' nie mo¿e byæ pusty!");
		
		String updateQuery = "UPDATE Pracownicy SET imie = ?, nazwisko = ?, katedra = ?, stopienNaukowy = ?, funkcja = ?, pensum = ?, przydzieloneGodziny = ? WHERE idPracownik = ?";
		
		PreparedStatement stmt = this.conn.prepareStatement(updateQuery);
		stmt.setString(1, pracownik.getImie());
		stmt.setString(2, pracownik.getNazwisko());
		stmt.setInt(3, pracownik.getKatedra());
		stmt.setInt(4, pracownik.getStopienNaukowy());
		stmt.setInt(5, pracownik.getFunkcja());
		stmt.setInt(6, pracownik.getPensum());
		stmt.setInt(7, 0);
		stmt.setInt(8, pracownik.getIdPracownika());
		
		stmt.execute();
		stmt.close();
		
		System.out.println("\n*** Pomyœlnie zaktuazizowano pracownika w bazie danych ***");
	}
	
	
	//****************************************************************************
	//------------------------ Usuñ pracownika -----------------------------------
	
	public void usunPracownika(int id) throws Exception {
		if(id == 0)
			throw new Exception("Nale¿y podaæ ID usuwanego pracownika!");
		
		String deleteQuery = "DELETE FROM Pracownicy WHERE idPracownik = ?";
		
		PreparedStatement stmt = this.conn.prepareStatement(deleteQuery);
		stmt.setInt(1, id);
		
		stmt.execute();
		stmt.close();
		
		System.out.println("*** Pomyœlnie usuniêto pracownika z bazy danych ***");
	}
	
	
	//*******************************************************************
	//--------------------- Lista pracowników ---------------------------
	
	public List<Pracownik> pobierzPracownikow(int id) throws Exception {
		List<Pracownik> listaPracownikow = new ArrayList<Pracownik>();
		
		String selectQuery = "SELECT * FROM Pracownicy";
		
		if(id > 0) selectQuery += " WHERE idPracownik = ?";
		
		PreparedStatement stmt = this.conn.prepareStatement(selectQuery);
		
		if(id > 0) stmt.setInt(1, id);
		
		ResultSet rs = stmt.executeQuery();
		
		while(rs.next()) {
			Pracownik p = new Pracownik();
			p.setIdPracownika(rs.getInt("idPracownik"));
			p.setImie(rs.getString("imie"));
			p.setNazwisko(rs.getString("nazwisko"));
			p.setKatedra(rs.getInt("katedra"));
			p.setStopienNaukowy(rs.getInt("stopienNaukowy"));
			p.setFunkcja(rs.getInt("funkcja"));
			p.setPensum(rs.getInt("pensum"));
			p.setPrzydzieloneGodziny(rs.getInt("przydzieloneGodziny"));
			
			listaPracownikow.add(p);
		}
		
		rs.close();
		stmt.close();
		
		return listaPracownikow;
	}
	
	
	//*******************************************************************
	//--------------------- Pracownik w bazie -----------------------
	
	public Pracownik pobierzPracownika(int id) throws Exception  {
		List<Pracownik> listaPracownikow = this.pobierzPracownikow(id);
			
		if(listaPracownikow.size() > 0) return listaPracownikow.get(0);
			
		else return null;
	}
		
		
	//*******************************************************************
	//-------------------- ustaw przydzielone godziny ---------------
		
	public void przydzielGodziny(Pracownik pracownik) throws Exception {
		if(pracownik == null)
				throw new Exception("* B³¹d przy próbie ustawienia godzin *");
		
		String updateQuery = "UPDATE Pracownicy SET przydzieloneGodziny = ? WHERE idPracownik = ?";
			
		PreparedStatement stmt = this.conn.prepareStatement(updateQuery);
		stmt.setInt(1, pracownik.getPrzydzieloneGodziny());
		stmt.setInt(2, pracownik.getIdPracownika());
		
		stmt.execute();
		stmt.close();
	}
	
}// koniec: Class
