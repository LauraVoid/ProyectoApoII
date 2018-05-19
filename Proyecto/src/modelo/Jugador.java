package modelo;

public class Jugador {
	
	private String nombre;
	private int puntos;
	private Jugador siguiente;
	private Jugador anterior;
	private Moneda raiz;
	
	public Jugador(String nom, int pu) {
		this.nombre=nom;
		this.puntos=pu;
		raiz=null;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getPuntos() {
		return puntos;
	}

	public void setPuntos(int puntos) {
		this.puntos = puntos;
	}

	public Jugador getSiguiente() {
		return siguiente;
	}

	public void setSiguiente(Jugador siguiente) {
		this.siguiente = siguiente;
	}
	

	public Jugador getAnterior() {
		return anterior;
	}

	public void setAnterior(Jugador anterior) {
		this.anterior = anterior;
	}

	public Moneda getRaiz() {
		return raiz;
	}

	public void setRaiz(Moneda raiz) {
		this.raiz = raiz;
	}
	
	public void addJugador(Jugador nuevo) {
		
		if(siguiente ==null) {
			siguiente=nuevo;
			siguiente.setAnterior(siguiente);
		}
	}
	
	
	
	

}
