package it.edu.iisgubbio.battaglianavale;

public class Pezzo {
	protected int x;
	protected int y;
	private boolean colpito;
	
	/**
	 * il metodo serve per sparare contro il pezzo
	 * @param x cordinate colonna del colpo
	 * @param y cordinate riga del colpo
	 * @return true se il pezzo è stato colpito
	 */
	public boolean colpo(int x,int y) {
		if(x==this.x && y==this.y) {
			this.colpito=true;
			return true;
		}else {
			return false;
		}
		
	}
	
	public Pezzo(int x, int y) {
		super();
		this.x = x;
		this.y = y;
		this.colpito=false;
		
	}
	
	
	public boolean isColpito() {
		return colpito;
	}

	/**
	 * verifica se il pezzo è stato colpito
	 * @retrun true se è stato colpito
	 */
	@Override
	public String toString() {
		String descrizione="Cordinate pezzo: x=" + x + ", y=" + y;
		if(colpito==true) {
			descrizione+=" è stato colpito";
		}else {
			descrizione+=" non è stato colpito";
		}
		return descrizione;
	}
}
