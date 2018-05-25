package modelo;

public class Moneda {
	
	private Moneda der;
	private Moneda izq;
	private int denominacion;
	
	public Moneda(int deno) {
		this.denominacion=deno;
	}
	
	public int getDenominacion() {
		return denominacion;
	}
	public void setDenominacion(int denominacion) {
		this.denominacion = denominacion;
	}
	public Moneda getDer() {
		return der;
	}
	public void setDer(Moneda der) {
		this.der = der;
	}
	public Moneda getIzq() {
		return izq;
	}
	public void setIzq(Moneda izq) {
		this.izq = izq;
	}
	/**
	 * Agrega una nueva moneda al arbol según su denominación
	 * @param nueva Moneda nueva a agregar
	 * nueva!=null
	 */
	public void addMoneda(Moneda nueva) {

		if (nueva.getDenominacion() <=denominacion) {
			if (izq == null) {
				izq = nueva;
			} else
				izq.addMoneda(nueva);
		} else if (nueva.getDenominacion() >denominacion) {
			if (der == null) {
				der = nueva;
			} else
				der.addMoneda(nueva);
		}
	}
	/**
	 * Retorna la Moneda de menor denominacion del subárbol derecho
	 * @return Moneda de menor denominacion
	 */
	public Moneda darMenor() {
		if (getIzq() == null) {
			return this;
		} else
			return izq.darMenor();
	}
	/**
	 * Elimina la Moneda que llega como parametro del árbol
	 * @param eliminar Moneda a eliminar
	 * eliminar !=null
	 * @return Retorna el árbol una vez eliminada la Moneda
	 */
	public Moneda eliminarMoneda(Moneda eliminar) {

		if (equals(eliminar)) {
			// caso1

			if (getIzq() == null && getDer() == null) {
				return null;
			}
			// caso2
			else if (getIzq() == null) {

				return der;

			} else if (getDer() == null) {
				return izq;

			}
			// caso3
			else {
				Moneda menor = der.darMenor();
				der = der.eliminarMoneda(menor);
				menor.izq = izq;
				menor.der = der;

				return menor;
			}

		}

		else if (eliminar.getDenominacion() < denominacion) {
			izq = izq.eliminarMoneda(eliminar);
		} else

			der = der.eliminarMoneda(eliminar);
		return this;
	}
	

	
	
}
