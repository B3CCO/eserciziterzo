package it.edu.iisgubbio.oggetti.figure;

public class Cerchio {
	double raggio;
	
	public Cerchio (double x) {
		raggio=x;
	}
	
	public Cerchio() {
		raggio=1;
	}
	
	
	public void setRaggio(double raggio) {
		this.raggio = raggio;
	}
	
	public double getRaggio() {
		return raggio;
	}
	
	
	public double diametro() {
		return raggio*2;
	}
	public double circonferenza() {
		double c= 2*Math.PI*raggio;
		return c;
	}
	
}

