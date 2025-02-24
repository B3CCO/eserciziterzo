package it.edu.iisgubbio.oggetti.fattoria;

public class Fattoria {

	public static void main(String[] args) {
		Prodotto carote = new Prodotto("carote",2.50);
		System.out.println(carote.toString());
		
		double p=carote.calcolaPrezzo(4);
		System.out.println(p);
		
		Ortaggio pomodoro=new Ortaggio("pomodoro",2,true);
		double m=pomodoro.calcolaPrezzo(0.5);
		System.out.println(pomodoro);
		System.out.println(m);
		
	}

}
