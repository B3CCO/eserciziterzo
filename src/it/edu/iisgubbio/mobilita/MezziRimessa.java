package it.edu.iisgubbio.mobilita;

import it.edu.iisgubbio.mobilita.mezzi.AMotore;
import it.edu.iisgubbio.mobilita.mezzi.AMuscoli;
import it.edu.iisgubbio.mobilita.mezzi.Automobile;
import it.edu.iisgubbio.mobilita.mezzi.Bicicletta;
import it.edu.iisgubbio.mobilita.mezzi.MezzoDiTrasporto;
import it.edu.iisgubbio.mobilita.mezzi.Motocicletta;
import it.edu.iisgubbio.mobilita.mezzi.Skateboard;
import it.edu.iisgubbio.mobilita.mezzi.Terrestre;

public class MezziRimessa{

	public static void main(String[] args) {
		
		MezzoDiTrasporto moto= new MezzoDiTrasporto("moto",1000);
		System.out.println(moto);
		System.out.println(moto.importoRata(5));
		
		AMuscoli muscoli=new AMuscoli("triciclo",150,"bicipiti");
		System.out.println(muscoli);
		System.out.println(muscoli.parteAlta());
		
		Bicicletta bicicletta=new Bicicletta(340,8);
		bicicletta.setNumeroDiRapporti(13);
		System.out.println(bicicletta);
		System.out.println(bicicletta.leggera());
		
		Skateboard skate = new Skateboard("skateboard",340);
		Skateboard skateLungo = new Skateboard("skateboard",340,90);
		System.out.println(skate);
		System.out.println(skateLungo);
		System.out.println(skate.longboard());
		System.out.println(skateLungo.longboard());
		
		AMotore elicottero=new AMotore("elicottero",50000,67,"gasolio");
		System.out.println(elicottero);
		System.out.println(elicottero.possibileCentriAbitati());
		
		Terrestre terrestre= new Terrestre();
		terrestre.setNome("motocarro di Luigi");
		terrestre.setCarburante("benzina");
		terrestre.setVelocita(130);
		System.out.println(terrestre);
		System.out.println(terrestre.tempoDiPercorrenza(100));
		
		Motocicletta motocicletta= new Motocicletta("MotoGuzzi",1,345);
		motocicletta.setNumeroPosti(3);
		System.out.println(motocicletta);
		System.out.println(motocicletta.puoTrasportare(4));
		
		Automobile auto=new Automobile("Maserati di Mario",1,4);
		auto.setTarga("BF5567UU");
		System.out.println(auto);
		
		
		
	}

}
