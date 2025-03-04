package it.edu.iisgubbio.oggetti.fattoria;

public class Formaggio extends Prodotto{
	// tempostagionatura e se sia dop si/no
	//questa classe ha 2 costrutori 1 che imposta tutte le proprietà e un'altro che imposta nome,prezzoalchilo,
	//e periodo di stagionatura e serve a creare formaggi npn dop
	protected int tempoDiStagionatura;
	protected boolean dop;
	
	public Formaggio(String nome, double prezzoAlChilo, int tempoDiStagionatura, boolean dop) {
		super(nome, prezzoAlChilo);
		this.tempoDiStagionatura = tempoDiStagionatura;
		this.dop = dop;
	}

	public Formaggio(String nome, double prezzoAlChilo, int tempoDiStagionatura) {
		super(nome, prezzoAlChilo);
		this.tempoDiStagionatura = tempoDiStagionatura;
		dop=false;
	}

	public void setTempoDiStagionatura(int tempoDiStagionatura) {
		this.tempoDiStagionatura = tempoDiStagionatura;
	}


	public void setDop(boolean dop) {
		this.dop = dop;
	}

	@Override
	public String toString() {
		if(dop==true) {
			if(tempoDiStagionatura>0){
				return "Formaggio: "+nome+ " costa "+prezzoAlChilo+"€ al chilo"+ " è stagionato: "+tempoDiStagionatura+" mese/i"+", il formaggio è DOP";
			}else {
				return "Formaggio: "+nome+ " costa "+prezzoAlChilo+"€ al chilo"+ " non è stagionato"+", il formaggio è Dop";
			}	
		}else {
			if(tempoDiStagionatura>0) {
				return "Formaggio: "+nome+" costa "+prezzoAlChilo+"€ al chilo"+" è stagionato: "+tempoDiStagionatura+" mesi"+", il formaggio non è DOP";
			}else {
				return "Formaggio: "+nome+" costa "+prezzoAlChilo+"€ al chilo"+" non è stagionato"+", il formaggio non è DOP";
			}
			
		}
		
	}
	
	
}
