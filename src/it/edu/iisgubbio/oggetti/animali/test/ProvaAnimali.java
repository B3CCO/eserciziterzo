package it.edu.iisgubbio.oggetti.animali.test;

import it.edu.iisgubbio.oggetti.animali.cani.Cane;
import it.edu.iisgubbio.oggetti.animali.cani.Cuccia;

public class ProvaAnimali {

	public static void main(String[] args) {
		Cane pippo;
		pippo=new Cane("pippo","bassotto",2010,515,"pagnoni");
		Cane kira = new Cane("kira","golden retriver", 5, 760,"rossi");
		Cuccia cuccia = new Cuccia();
		
		//cuccia per esterno ci va un cane solo e costa 87$
		cuccia.setInterno(true);
		cuccia.setPrezzo(87);
		cuccia.setNumeroPosti(3);
		cuccia.setColore(null);
		
		
		System.out.println(pippo.toString());
		System.out.println(kira.toString());
		System.out.println(cuccia);
		System.out.println(pippo.verificaProprietario("becchetti"));
		System.out.println(pippo.età(2025));
		
		
		
		
		

	}

}
