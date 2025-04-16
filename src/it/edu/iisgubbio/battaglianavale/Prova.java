package it.edu.iisgubbio.battaglianavale;

public class Prova {

	public static void main(String[] args) {
		/*Pezzo pezzo= new Pezzo(3,2);
		System.out.println(pezzo);
		System.out.println(pezzo.colpo(3, 2));
		System.out.println(pezzo);
		System.out.println("colpito? "+pezzo.isColpito());*/
		
		Nave nave1= new Nave("amerigo",1,1,3,true);
		boolean preso=nave1.colpo(1,1);
		boolean preso1=nave1.colpo(2,1);
		boolean preso2=nave1.colpo(3,1);
		System.out.println(nave1);
		System.out.println("affondata? "+nave1.affondata());
		
		Nave nave2=new Nave("vespucci",2,1,3,true);
		System.out.println(nave2);
		System.out.println("Sovrappone? "+nave2.sovrappone(nave1));

	}

}
