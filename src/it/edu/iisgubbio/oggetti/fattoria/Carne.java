package it.edu.iisgubbio.oggetti.fattoria;

public class Carne extends Prodotto{
	
	private boolean tipoMacellazione;
	private boolean carneBianca;
	
	public Carne(String nome, double prezzoAlChilo, boolean tipoMacellazione, boolean carneBianca) {
		super(nome, prezzoAlChilo);
		this.tipoMacellazione = tipoMacellazione;
		this.carneBianca = carneBianca;
	}
	
	@Override
	public String toString() {
		String descrizione=nome +" "+ prezzoAlChilo+"€/Kg";
		if(!tipoMacellazione) {
			descrizione += " NON Kosher";
			
		}else {
			descrizione += " Kosher";
		}
		if(!carneBianca) {
			descrizione += " [carne rossa]";
			
		}else {
			descrizione +=" [carne bianca]";
		}
		return descrizione;
	}

	public boolean isTipoMacellazione() {
		return tipoMacellazione;
	}

	public boolean isCarneBianca() {
		return carneBianca;
	}


}
