package it.edu.iisgubbio.battaglianavale;

public class Nave {
	
	private Pezzo[] pezzi;
	private String nome;
	
	/**
	 * costruisce una nave nuova
	 * @param x inizio della nave
	 * @param y inizio della nave
	 * @param lunghezza della nave
	 * @param direzione se true, è orizzontale, altrimenti verticale
	 */
	public Nave(String nome,int x,int y,int lunghezza, boolean direzione) {
		super();
		this.nome=nome;
		pezzi=new Pezzo[lunghezza];
		for(int i=0;i<lunghezza;i++) {
			if(direzione) {
				pezzi[i]=new Pezzo(x++,y);
			}else {
				pezzi[i]=new Pezzo(x,y++);
			}
		}
	}
	
	/**
	 * 
	 * @return nome della nave
	 */
	public String getNome() {
		return nome;
	}
	
	/**
	 * vettore dei pezzi che compongonoi la nave
	 * @return
	 */
	public Pezzo[] getPezzi() {
		return pezzi;
	}
	
	/**
	 * serve a capire se la nave è stata affondata
	 * @return
	 */
	public boolean affondata() {
		int a=0;
		boolean aff=false;
		for(int i=0;i<pezzi.length;i++) {
			if(pezzi[i].isColpito()==true) {
				a+=1;
			}
		}
		if(a==pezzi.length) {
			aff=true;
		}
		return aff;
		
	}
	
	/**
	 * 
	 * @param x cordinata orizzontale
	 * @param y cordinata verticale
	 * @return risultato del colpo true se preso, false se non preso
	 */
	public boolean colpo(int x,int y) {
		boolean colpito=false;
		for(int i=0;i<pezzi.length;i++) {
			if(pezzi[i].colpo(x, y)) {
				colpito= true;
			}
		}
		return colpito;
	}
	
	/**
	 * verifica se le navi si sovrappongono oppure no
	 * @param altra Nave nuova da controllare se sovrappone con questo
	 * @return true se le navi si sovrappongono, false se  non si sovrappongono
	 */
	public boolean sovrappone(Nave altra) {
		boolean sovrappone=false;
		for(int iNave1=0;iNave1<pezzi.length;iNave1++){
			for(int iAltra=0; iAltra<altra.pezzi.length; iAltra++) {
				// TODO bisognerebbe lasciare uno spazio tra una nave e l'altra
				if(pezzi[iNave1].x==altra.pezzi[iAltra].x && pezzi[iNave1].y==altra.pezzi[iAltra].y) {
					sovrappone=true;
				}
			}
		}
		return sovrappone;
		
		
	}

	@Override
	public String toString() {
		String descrizione="Nave: "+nome;
		for(int i=0;i<pezzi.length;i++) {
			descrizione+= "\n"+i+": "+pezzi[i].toString();
		}
		return descrizione;
	}
	
}
