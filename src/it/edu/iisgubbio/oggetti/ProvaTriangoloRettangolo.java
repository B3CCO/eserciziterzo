package it.edu.iisgubbio.oggetti;

import it.edu.iisgubbio.oggetti.figure.TriangoloRettangolo;

public class ProvaTriangoloRettangolo {

	public static void main(String[] args) {
		TriangoloRettangolo t;
		t= new TriangoloRettangolo(0,0);
		
		t.setcatetoMinore(10);
		t.setcatetoMaggiore(20);
		
		System.out.println(t.toString());
		System.out.println(t.ipotenusa());
		System.out.println(t.perimetro());
		System.out.println(t.area());
		
	}

}
