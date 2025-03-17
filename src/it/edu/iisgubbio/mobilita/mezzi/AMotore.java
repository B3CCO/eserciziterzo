package it.edu.iisgubbio.mobilita.mezzi;

public class AMotore extends MezzoDiTrasporto{
	
	private double rumorosita;
	private String carburante;
	
	public AMotore() {
		super();
	}

	public AMotore(String nome,double costo,double rumorosita, String carburante) {
		super(nome,costo);
		this.rumorosita = rumorosita;
		this.carburante = carburante;
		
	}
	
	@Override
	public String toString() {
		
		return "Mezzo motorizzato: "+nome+" ("+costo+"€ ) che emette "+rumorosita+"db di rumore, consuma "+carburante;
		
	}
	
	public boolean possibileCentriAbitati() {
		return rumorosita<68;
	}

	public double getRumorosita() {
		return rumorosita;
	}

	public void setRumorosita(double rumorosita) {
		this.rumorosita = rumorosita;
	}

	public String getCarburante() {
		return carburante;
	}

	public void setCarburante(String carburante) {
		this.carburante = carburante;
	}
	
}
