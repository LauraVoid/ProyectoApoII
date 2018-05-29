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
	/**
	 * Agrega un nuevo poder al arbol según su velocidad
	 * @param nuevo Poder nuevo a agregar
	 * nuevo!=null
	 */
	public void addPoder(Poder nuevo) {

		if (nuevo.getVelocidad() <=velocidad) {
			if (izq == null) {
				izq = nuevo;
			} else
				izq.addPoder(nuevo);
		} else if (nuevo.getVelocidad() >velocidad) {
			if (der == null) {
				der = nuevo;
			} else
				der.addPoder(nuevo);
		}
	}
	public Poder buscarPoder(int num) {
		
		if(velocidad==num) {
			return this;
		}else if(velocidad>=num) {
			if(izq!=null) {
				return izq.buscarPoder(num);
			}else
				return null;
		}else if(der!=null) {
			return der.buscarPoder(num);
		}else return null;
	}
	
	

}
