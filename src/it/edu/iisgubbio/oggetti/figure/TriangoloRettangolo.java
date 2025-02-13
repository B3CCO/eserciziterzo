package it.edu.iisgubbio.oggetti.figure;

public class TriangoloRettangolo {
	double catetoMinore;
	double catetoMaggiore;
	
	public void setcatetoMinore(double catetoMinore) {
		this.catetoMinore = catetoMinore;
	}
	
	public double getcatetoMinore() {
		return catetoMinore;
	}
	
	public void setcatetoMaggiore(double catetoMaggiore) {
		this.catetoMaggiore = catetoMaggiore;
	}
	
	public double getcatetoMaggiore() {
		return catetoMaggiore;
	}

	
	public TriangoloRettangolo(double catetoMinore , double catetoMaggiore) {
		this.catetoMinore= catetoMinore;
		this.catetoMaggiore= catetoMaggiore;
	}
	
	public double ipotenusa() {
		double i= Math.sqrt(catetoMinore*catetoMinore + catetoMaggiore*catetoMaggiore);
		return i;
	}
	
	public double perimetro() {
		double p=catetoMinore+catetoMaggiore+ipotenusa();
		return p;
	}
	
	public double area() {
		double a= (catetoMinore*catetoMaggiore)/2;
		return a;
	}
	
	public String toString() {
		return "Triangolo rettangolo" + " "+ catetoMinore+ " * " + catetoMaggiore;
	}
}
