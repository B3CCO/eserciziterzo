package it.edu.iisgubbio.oggetti.vivaio;

public class Prova {

	public static void main(String[] args) {
		Commestibile fragole= new Commestibile("fragole",10);
		
		fragole.setQuantità(24);
		fragole.setStagioneProduzione("primavera");
		
		System.out.println(fragole);
		
		Bonsai economico= new Bonsai ("acero",30,21);
		
		System.out.println(economico);
		
		if(economico.vecchio()) {
			System.out.println("bell' acquisto");
		}
		
		int numeroImballi=0;
		numeroImballi+=fragole.getQuantità()/fragole.getUnitaPerImballo();
		
		if(fragole.getQuantità()%fragole.getUnitaPerImballo()>0) {
			numeroImballi++;
		}
		
		System.out.println(numeroImballi);

	}

}
