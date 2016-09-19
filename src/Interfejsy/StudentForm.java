package Interfejsy;

import java.util.List;

import DAO_Packages.StudentDAO;
import Obiekty.Student;

public class StudentForm extends Wyjatki{
	
	private StudentDAO studentDAO;
	
	public StudentForm() throws Exception {
		super();
		this.studentDAO = new StudentDAO();
	}
	
	
	//***************************************************************************
	//------------------- Dodanie studenta ------------------------------------
	
	public void dodajStudenta() throws Exception {
		Student student = new Student();
		
		System.out.println("\n***   Dodawanie nowego studenta  ***");
		System.out.println("-----------------------------------\n");
		System.out.println("Podaj imi�: ");
		student.setImie(bufor.readLine());
		System.out.println("Podaj nazwisko: ");
		student.setNazwisko(bufor.readLine());
		System.out.println("Podaj kierunek studi�w: \n1 - Informatyka\n2 - Informatyka i ekonometria");
		student.setKierunek(stringToIntBez0());
		System.out.println("Podaj tryb studi�w: \n1 - stacjonarny\n2 - zaoczny");
		student.setTryb(stringToIntBez0());
		System.out.println("Podaj numer semestru: ");
		student.setNrSemestru(stringToIntBez0());
		System.out.println("Podaj numer grupy: ");
		student.setGrupa(stringToIntBez0());
		
		studentDAO.dodajStudenta(student);
	}
	
	
	//****************************************************************************
	//-------------------- Aktualizacja studenta -------------------------------
	
	public void aktualizujStudenta() throws Exception {
		Student student = new Student();
		
		int tmp2 = 0;
		
		System.out.println("\n***   Aktualizacja danych studenta  ***");
		System.out.println("-----------------------------------------\n");
		System.out.println("Podaj ID studenta, kt�ry ma zosta� zaktualizowany: ");
		System.out.println("(0 - wy�wietl list� student�w)");
		
		tmp2 = stringToInt();
		if(tmp2 == 0) {
			wyswietlListeStudentow();
			System.out.println("\n\nPodaj ID studenta, kt�ry ma zosta� zaktualizowany: ");
			tmp2 = stringToIntBez0();
		}
		
		//---- Sprawdzenie czy student jest w bazie ----
			Student studentBaza = studentDAO.pobierzStudenta(tmp2);
		
		if(studentBaza != null) {
			student.setIdStudent(tmp2);
				
			System.out.println("Podaj nowe imi�: ");
			student.setImie(bufor.readLine());
			System.out.println("Podaj nowe nazwisko: ");
			student.setNazwisko(bufor.readLine());
			System.out.println("Podaj kierunek studi�w: \n1 - Informatyka\n2 - Informatyka i ekonometria");
			student.setKierunek(stringToIntBez0());
			System.out.println("Podaj tryb studi�w: \n1 - stacjonarny\n2 - zaoczny");
			student.setTryb(stringToIntBez0());
			System.out.println("Podaj numer semestru: ");
			student.setNrSemestru(stringToIntBez0());
			System.out.println("Podaj numer grupy: ");
			student.setGrupa(stringToIntBez0());
				
			studentDAO.aktualizujStudenta(student);
		}
		else System.out.println("* W bazie danych nie istnieje student o podanym ID *");
	}
	
	
	//****************************************************************************
	//------------------------ Usuwanie studenta -------------------------------
	
	public void usunStudenta() throws Exception {
		
		int tmp;
		
		System.out.println("\n***   Usuwanie studenta z bazy danych  ***");
		System.out.println("-----------------------------------------\n");
		System.out.println("Podaj ID studenta, kt�ry ma zosta� usuni�ty: ");
		System.out.println("(0 - wy�wietl list� student�w)");
		
		tmp = stringToInt();
		if(tmp == 0) {
			wyswietlListeStudentow();
			System.out.println("\n\nPodaj ID studenta, kt�ry ma zosta� usuni�ty: ");
			tmp = stringToIntBez0();
		}
		
		//---- Sprawdzenie czy student jest w bazie ----
		Student studentBaza = studentDAO.pobierzStudenta(tmp);
		
		if(studentBaza != null)  studentDAO.usunStudenta(tmp);
		else System.out.println("* W bazie danych nie istnieje student o podanym ID *");
	}
	
	
	//*********************************************************************************
	//-------------------- Lista wszystkich student�w -------------------------------
	
	public void wyswietlListeStudentow() throws Exception {
		String pomocnicza = null;
		int tmp = 0;
		
		List<Student> listaStudentow = studentDAO.pobierzStudentow(0); 
		
		if(listaStudentow == null) System.out.println("* W bazie danych nie ma �adnych student�w *");
		
		else {
			System.out.println("\n***     Lista student�w     ***");
			System.out.println("---------------------------------\n");
			System.out.println("ID\tImi�\tNazwisko\tTryb studi�w\tNr semestru\tNr grupy\tKierunek studi�w\n");
			for(Student student: listaStudentow) {
				System.out.print(student.getIdStudent() + "\t");
				System.out.print(student.getImie() + "\t");
				System.out.print(student.getNazwisko() + "\t\t");
				
				tmp = student.getTryb();
				if(tmp == 1) pomocnicza = "stacjonarny";
				else if(tmp == 2) pomocnicza = "zaoczny    ";
				else pomocnicza = "b.d.";
				System.out.print(pomocnicza + "\t");
				
				System.out.print(student.getNrSemestru() + "\t\t");
				System.out.print(student.getGrupa() + "\t\t");
				
				tmp = student.getKierunek();
				if(tmp == 1) pomocnicza = "Informatyka";
				else if(tmp == 2) pomocnicza = "Informatyka i ekonometria";
				else pomocnicza = "b.d.";
				System.out.print( pomocnicza + "\n");
			}
		}
	}
	
}//koniec class
