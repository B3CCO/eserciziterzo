package it.edu.iisgubbio.oggetti.animali.cani;

public class Cane {
	
	private String nome;
	private String razza;
	private int anno;
	private int grammiCibo;
	private String nomeProprietario;
	
	public Cane(){
		
	}

	public Cane(String nome, String razza, int anno, int grammiCibo, String nomeProprietario) {
		super();
		this.nome = nome;
		this.razza = razza;
		this.anno = anno;
		this.grammiCibo = grammiCibo;
		this.nomeProprietario = nomeProprietario;
	}
	
	
	public String toString() {
		return "si chiama "+nome+" è di razza "+ razza+ ", ha "+anno+" anni"+", mangia "+grammiCibo+"  grammi al giorno"+" appartiene a "+nomeProprietario;
	}
	
	//metodo verifica proprietario che dato un nome dice se è il proprietario oppure no
	
	/**
	 * verifica il nome del proprietario
	 * @param nome il nome del propiretario da controllare
	 * @return true se il nome inserito è uguale a quello del proprietario
	 */
	public boolean verificaProprietario(String nome) {
		
		if(nomeProprietario.equals(nome)) {  
			return true;
			
		}else {
			return false;
		}
		// return nomeProprietario.equals(nome); 
		
	}
	
	//implementare nella classe cane il metodo età che dato un anno restituisce l'età del cane
	
	/**
	 * metodo che dato un anno, restituisce l'età del cane
	 * @param anno l'anno a cui è riferita l'età
	 * @return calcola l'età del cane nell'anno specificato
	 */
	public int età(int anno) {	
		return anno-this.anno;
	}
	
	
	

}
