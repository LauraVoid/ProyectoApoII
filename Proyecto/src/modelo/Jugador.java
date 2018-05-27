package modelo;

public class Jugador implements Comparable<Jugador> {

	private String nombre;
	private int edad;
	private int puntos;
	private Jugador siguiente;
	private Jugador anterior;
	private Moneda raiz;

	public Jugador(String nom, int edad, int pu) {
		this.nombre = nom;
		this.edad = edad;
		this.puntos = pu;
		raiz = null;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
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
	

	/**
	 * Returna el Jugador anterior segun la lista
	 * 
	 * @return Jugador anterior
	 */

	public Jugador getAnterior() {
		return anterior;
	}

	/**
	 * Modifica el jugador anterior de la lista
	 * 
	 * @param anterior!=null
	 */

	public void setAnterior(Jugador anterior) {
		this.anterior = anterior;
	}

	/**
	 * Retorna la Moneda raiz del arbol
	 * 
	 * @return raiz del arbol
	 */

	public Moneda getRaiz() {
		return raiz;
	}

	/**
	 * Modifica la raiz del arbol
	 * 
	 * @param raiz!=null
	 */

	public void setRaiz(Moneda raiz) {
		this.raiz = raiz;
	}

	/**
	 * Agrega un nuevo jugador a la lista
	 * 
	 * @param nuevo
	 *            Jugador nuevo a agregar nuevo!=null
	 */
	public void addJugador(Jugador nuevo) {
		if (siguiente == null) {
			siguiente = nuevo;
			siguiente.setAnterior(this);
		} else
			siguiente.addJugador(nuevo);
	}

	/**
	 * Elimina un Jugador que llega por parametro de la lista de forma recursiva
	 * 
	 * @param eliminar
	 *            Jugador a eliminar eliminar!=null
	 */
	public void removeJugador(Jugador eliminar) {

		if (siguiente.equals(eliminar)) {
			Jugador sig = siguiente.getSiguiente();
			this.setSiguiente(sig);
		} else
			siguiente.removeJugador(eliminar);
	}

	/**
	 * Busca de forma recursiva el Jugador que se deseea buscar
	 * 
	 * @param nom
	 *            Nombre del Jugador a buscar nom !=null
	 * @return Jugador encontrado
	 */
	public Jugador buscarJugador(String nom) {
		if (getNombre().equals(nom)) {
			return this;
		} else if (siguiente != null) {
			return siguiente.buscarJugador(nom);
		} else
			return null;
	}

	/**
	 * Agrega una nueva moneda al arbol
	 * 
	 * @param nueva
	 *            Moneda nueva a agregar nueva!=null
	 */

	public void addMoneda(Moneda nueva) {

		if (raiz == null) {
			raiz = nueva;

		} else
			raiz.addMoneda(nueva);

	}

	/**
	 * Elimina una Moneda del árbol
	 * 
	 * @param eliminar
	 *            Moneda a eliminar eliminar!=null
	 */
	public void removeMoneda(Moneda eliminar) {
		raiz = raiz.eliminarMoneda(eliminar);

	}
	/**
	 * Compara los nombre de dos jugadores
	 * @param Jugador a comparar
	 * Jugador!=null 
	 * @return retorna un número que indica lexicografixamente el nombre mayor
	 */

	@Override
	public int compareTo(Jugador ju) {
		return nombre.compareTo(ju.getNombre());
	}

}
