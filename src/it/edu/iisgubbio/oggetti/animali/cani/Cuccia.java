package it.edu.iisgubbio.oggetti.animali.cani;

public class Cuccia {
	//interno/esterno,prezzo,numeroPosti,colore
	
	private boolean interno;
	private double prezzo;
	private int numeroPosti;
	private String colore;
	
	public boolean isInterno() {
		return interno;
	}
	public void setInterno(boolean interno) {
		this.interno = interno;
	}
	public double getPrezzo() {
		return prezzo;
	}
	public void setPrezzo(double prezzo) {
		this.prezzo = prezzo;
	}
	public int getNumeroPosti() {
		return numeroPosti;
	}
	public void setNumeroPosti(int numeroPosti) {
		this.numeroPosti = numeroPosti;
	}
	public String getColore() {
		return colore;
	}
	public void setColore(String colore) {
		this.colore = colore;
	}
	
	//deve stampare sempre il numero dei posti, il prezzo, e se interno o esterno, inserire il colore solo se inserito
	public String toString() {
		if(interno==true) {
			if(colore==null) {
				return "la cuccia è da interno "+"costa "+prezzo+"€"+" può ospitare "+numeroPosti+" cani/e";
			}else {
				return "la cuccia è da interno "+"costa "+prezzo+"€"+" può ospitare "+numeroPosti+" cani/e"+ " è di colore "+colore;
			}
			
		}else {
			if(colore==null) {
				return "la cuccia è da esterno "+"costa "+prezzo+"€"+" può ospitare "+numeroPosti+" cani/e";
			}else {
				return "la cuccia è da esterno "+"costa "+prezzo+"€"+" può ospitare "+numeroPosti+" cani/e"+ " è di colore "+colore;
			}
			
		}
	}
	
	
}
