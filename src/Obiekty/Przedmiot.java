package Obiekty;

public class Przedmiot {
	
	private int idPrzedmiot;
	private String nazwaPrzedmiot;
	private int katedra;
	private int wyklady;
	private int cwiczenia;
	private int laboratoria;
	private boolean czyObsadzony;
	
	
	public int getIdPrzedmiot() {
		return idPrzedmiot;
	}
	public void setIdPrzedmiot(int idPrzedmiot) {
		this.idPrzedmiot = idPrzedmiot;
	}
	public String getNazwaPrzedmiot() {
		return nazwaPrzedmiot;
	}
	public void setNazwaPrzedmiot(String nazwaPrzedmiot) {
		this.nazwaPrzedmiot = nazwaPrzedmiot;
	}
	public int getKatedra() {
		return katedra;
	}
	public void setKatedra(int katedra) {
		this.katedra = katedra;
	}
	public int getWyklady() {
		return wyklady;
	}
	public void setWyklady(int wyklady) {
		this.wyklady = wyklady;
	}
	public int getCwiczenia() {
		return cwiczenia;
	}
	public void setCwiczenia(int cwiczenia) {
		this.cwiczenia = cwiczenia;
	}
	public int getLaboratoria() {
		return laboratoria;
	}
	public void setLaboratoria(int laboratoria) {
		this.laboratoria = laboratoria;
	}
	public boolean isCzyObsadzony() {
		return czyObsadzony;
	}
	public void setCzyObsadzony(boolean czyObsadzony) {
		this.czyObsadzony = czyObsadzony;
	}

}
