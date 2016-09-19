package DAO_Packages;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import Obiekty.Student;

public class StudentDAO extends Database{
	
	public StudentDAO() throws Exception {
		super();
	}
	
	//***************************************************************************
	//------------------- Dodanie studenta ------------------------------------
	
	public void dodajStudenta(Student student) throws Exception {
		
		if(student == null)
			throw new Exception("Nie mo¿na zapisaæ obiektu 'Student', który nie istnieje!");
		
		String insertQuery = "INSERT INTO Studenci(imie, nazwisko, kierunek, tryb, nrSemestru, grupa) VALUES(?,?,?,?,?,?)";
		
		PreparedStatement stmt = this.conn.prepareStatement(insertQuery);
		stmt.setString(1, student.getImie());
		stmt.setString(2, student.getNazwisko());
		stmt.setInt(3, student.getKierunek());
		stmt.setInt(4, student.getTryb());
		stmt.setInt(5, student.getNrSemestru());
		stmt.setInt(6, student.getGrupa());
		
		stmt.execute();
		stmt.close();
		
		System.out.println("*** Pomyœlnie dodano studenta do bazy danych ***");
	}
	
	
	//****************************************************************************
	//-------------------- Aktualizacja studenta -------------------------------

	public void aktualizujStudenta(Student student) throws Exception {
		if(student == null)
			throw new Exception("Obiekt 'Student' nie mo¿e byæ pusty!");
		
		String updateQuery = "UPDATE Studenci SET imie = ?, nazwisko = ?, kierunek = ?, tryb = ?, nrSemestru = ?, grupa = ? WHERE idStudent = ?";
		
		PreparedStatement stmt = this.conn.prepareStatement(updateQuery);
		stmt.setString(1, student.getImie());
		stmt.setString(2, student.getNazwisko());
		stmt.setInt(3, student.getKierunek());
		stmt.setInt(4, student.getTryb());
		stmt.setInt(5, student.getNrSemestru());
		stmt.setInt(6, student.getGrupa());
		stmt.setInt(8, student.getIdStudent());
		
		stmt.execute();
		stmt.close();
		
		System.out.println("\n*** Pomyœlnie zaktuazizowano studenta w bazie danych ***");
	}
	
	
	//****************************************************************************
	//------------------------ Usuñ studenta -----------------------------------
	
	public void usunStudenta(int id) throws Exception {
		if(id == 0)
			throw new Exception("Nale¿y podaæ ID usuwanego studenta!");
		
		String deleteQuery = "DELETE FROM Studenci WHERE idStudent = ?";
		
		PreparedStatement stmt = this.conn.prepareStatement(deleteQuery);
		stmt.setInt(1, id);
		
		stmt.execute();
		stmt.close();
		
		System.out.println("*** Pomyœlnie usuniêto studenta z bazy danych ***");
	}
	
	
	//*******************************************************************
	//--------------------- Lista studentów ---------------------------
	
	public List<Student> pobierzStudentow(int id) throws Exception {
		List<Student> listaStudentow = new ArrayList<Student>();
		
		String selectQuery = "SELECT * FROM Studenci";
		
		if(id > 0) selectQuery += " WHERE idStudent = ?";
		
		PreparedStatement stmt = this.conn.prepareStatement(selectQuery);
		
		if(id > 0) stmt.setInt(1, id);
		
		ResultSet rs = stmt.executeQuery();
		
		while(rs.next()) {
			Student student = new Student();
			student.setIdStudent(rs.getInt("idStudent"));
			student.setImie(rs.getString("imie"));
			student.setNazwisko(rs.getString("nazwisko"));
			student.setKierunek(rs.getInt("kierunek"));
			student.setTryb(rs.getInt("tryb"));
			student.setNrSemestru(rs.getInt("nrSemestru"));
			student.setGrupa(rs.getInt("grupa"));
			
			listaStudentow.add(student);
		}
		
		rs.close();
		stmt.close();
		
		return listaStudentow;
	}
	
	
	//*******************************************************************
	//--------------------- Student w bazie -----------------------
	
	public Student pobierzStudenta(int id) throws Exception  {
		List<Student> listaStudentow = this.pobierzStudentow(id);
			
		if(listaStudentow.size() > 0) return listaStudentow.get(0);
			
		else return null;
	}
		
}// koniec: Class
