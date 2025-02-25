package it.edu.iisgubbio.oggetti.fattoria;

public class Muffato extends Formaggio{
	
	protected String nomeMuffa;
	protected boolean interno;
	
	public Muffato(String nome, double prezzoAlChilo, int tempoDiStagionatura, String nomeMuffa,
			boolean interno) {
		super(nome, prezzoAlChilo, tempoDiStagionatura);
		this.nomeMuffa = nomeMuffa;
		this.interno = interno;
	}
	
	

}
