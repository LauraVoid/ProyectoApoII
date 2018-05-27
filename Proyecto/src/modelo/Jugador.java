package modelo;

import java.io.Serializable;
import java.util.ArrayList;

public class Jugador implements Comparable<Jugador>, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
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
	/**
	 * Retorna el peso del árbol
	 * 
	 * @return cantidad de monedas del arbol
	 */

	public int cantidadMonedas() {

		if (raiz == null) {
			return 0;
		} else
			return raiz.contar();
	}
	/**
	 * Retorna las monedas del arbol en una lista
	 * 
	 * @return lista con las monedas del arbol
	 */

	public ArrayList<Moneda> darListaMonedas() {
		ArrayList<Moneda> lista = new ArrayList<Moneda>();

		if (raiz != null) {

			lista.add(raiz);
			Moneda izq = raiz.getIzq();
			Moneda der = raiz.getDer();

			int cantidad = cantidadMonedas();

			while (cantidad >= 0) {

				if (izq != null) {
					lista.add(izq);
					izq = izq.getIzq();
				}
				if (der != null) {
					lista.add(der);
					der = der.getDer();
				}
				cantidad--;

			}
		}

		return lista;

	}
	/**
	 * Crea una lista con las monedas organizadas de menor a mayor con el método de
	 * seleccion
	 * 
	 * @return lista con las monedas ordenadas
	 */

	public ArrayList<Moneda> darListaMonOrdenadaDen() {

		ArrayList<Moneda> lista = darListaMonedas();
		int tam = lista.size();

		for (int i = 0; i < tam - 1; i++) {

			Moneda menor = lista.get(i);
			int num = 1;

			for (int j = i + 1; j < tam; j++) {

				if (lista.get(j).getDenominacion() < menor.getDenominacion()) {
					menor = lista.get(j);
					num = j;
				}
			}
			Moneda tem = lista.get(i);
			lista.set(i, menor);
			lista.set(num, tem);

		}

		return lista;
	}

}
