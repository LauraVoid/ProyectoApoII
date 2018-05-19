package modelo;

public class Poder {
	
	private Poder der;
	private Poder izq;
	private int velocidad;
	
	public Poder(int vel) {
		this.velocidad=vel;
		der=null;
		izq=null;
	}
	
	
	public int getVelocidad() {
		return velocidad;
	}


	public void setVelocidad(int velocidad) {
		this.velocidad = velocidad;
	}


	public Poder getDer() {
		return der;
	}
	public void setDer(Poder der) {
		this.der = der;
	}
	public Poder getIzq() {
		return izq;
	}
	public void setIzq(Poder izq) {
		this.izq = izq;
	}
	
	

}
