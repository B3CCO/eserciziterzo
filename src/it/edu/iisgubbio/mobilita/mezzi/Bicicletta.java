package it.edu.iisgubbio.mobilita.mezzi;

public class Bicicletta extends AMuscoli{
	
	private int numeroDiRapporti;
	private double peso;
	
	
	public Bicicletta(double costo,double peso) {
		super("bicicletta",costo,"polpacci");
		this.peso = peso;
	}
	
	@Override
	public String toString() {
		String descrizione= "Bicicletta: pesa "+peso+"Kg";
		if(peso<10) {
			descrizione+= " (leggera) costa "+costo+"€ (ha "+numeroDiRapporti+" rapporti)";
		}else {
			descrizione+=" (pesante) costa "+costo+"€ (ha "+numeroDiRapporti+" rapporti)";
		}
		return descrizione;
	}
	
	public boolean leggera() {
		return peso<10;
	}

	public int getNumeroDiRapporti() {
		return numeroDiRapporti;
	}

	public void setNumeroDiRapporti(int numeroDiRapporti) {
		this.numeroDiRapporti = numeroDiRapporti;
	}

	public double getPeso() {
		return peso;
	}

	public void setPeso(double peso) {
		this.peso = peso;
	}
	
	

}
