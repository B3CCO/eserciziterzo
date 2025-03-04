package it.edu.iisgubbio.oggetti.fattoria;

public class Muffato extends Formaggio{
	
	protected String nomeMuffa;
	protected boolean interno;
	
	public Muffato(String nome, double prezzoAlChilo, String nomeMuffa) {
		super(nome, prezzoAlChilo, 0, false);
		this.nomeMuffa = nomeMuffa;
		this.interno = true;
	}

	public void setInterno(boolean interno) {
		this.interno = interno;
	}
	
	@Override
	public String toString() {
		String descrizione=nome +" "+ prezzoAlChilo+"€/Kg"+" è stagionato: "+tempoDiStagionatura+" mese/i"+" muffa: "+nomeMuffa;
		if(!dop) {
			descrizione += " il formaggio non è DOP";
			
		}else {
			descrizione+= " il formagio è DOP";
		}
		if(!interno) {
			descrizione+= " la muffa è esterna";
		}else {
			descrizione+= " la muffa è interna";
		}
		return descrizione;
		
	}
	
	
	
	

}
