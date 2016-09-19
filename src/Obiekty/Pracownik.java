package Obiekty;

public class Pracownik {
	
	private int idPracownika;
	private String imie;
	private String nazwisko;
	private int katedra;
	private int stopienNaukowy;
	private int funkcja;
	private int pensum;
	private int przydzieloneGodziny;
	
	
	public int getIdPracownika() {
		return idPracownika;
	}
	public void setIdPracownika(int idPracownika) {
		this.idPracownika = idPracownika;
	}
	public String getImie() {
		return imie;
	}
	public void setImie(String imie) {
		this.imie = imie;
	}
	public String getNazwisko() {
		return nazwisko;
	}
	public void setNazwisko(String nazwisko) {
		this.nazwisko = nazwisko;
	}
	public int getKatedra() {
		return katedra;
	}
	public void setKatedra(int katedra) {
		this.katedra = katedra;
	}
	public int getStopienNaukowy() {
		return stopienNaukowy;
	}
	public void setStopienNaukowy(int stopienNaukowy) {
		this.stopienNaukowy = stopienNaukowy;
	}
	public int getFunkcja() {
		return funkcja;
	}
	public void setFunkcja(int funkcja) {
		this.funkcja = funkcja;
	}
	public int getPensum() {
		return pensum;
	}
	public void setPensum(int pensum) {
		this.pensum = pensum;
	}
	public int getPrzydzieloneGodziny() {
		return przydzieloneGodziny;
	}
	public void setPrzydzieloneGodziny(int przydzieloneGodziny) {
		this.przydzieloneGodziny = przydzieloneGodziny;
	}
}
