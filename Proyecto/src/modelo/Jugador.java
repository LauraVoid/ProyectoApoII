package modelo;

public class Jugador {
	
	private String nombre;
	private int puntos;
	private Jugador siguiente;
	
	public Jugador(String nom, int pu) {
		this.nombre=nom;
		this.puntos=pu;
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
	
	
	

}