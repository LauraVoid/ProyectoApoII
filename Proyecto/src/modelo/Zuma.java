package modelo;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import excepciones.NoExisteException;
import interfaz.PanelJuego;

public class Zuma {

	
	private Jugador primerJugador;
	private Bola primerBola;
	private Rana ranita;

	public Zuma() {

		primerBola = null;
		
		addBolaAlFinal(new BolaNormal(darColorAleatorio(), 0, PanelJuego.MAX_POSY, false));
		addBolaAlFinal(new BolaNormal(darColorAleatorio(), -30, PanelJuego.MAX_POSY, false));
		addBolaAlFinal(new BolaNormal(darColorAleatorio(), -60, PanelJuego.MAX_POSY, false));
		addBolaAlFinal(new BolaNormal(darColorAleatorio(), -90, PanelJuego.MAX_POSY, false));
		addBolaAlFinal(new BolaNormal(darColorAleatorio(), -120, PanelJuego.MAX_POSY, false));
		addBolaAlFinal(new BolaNormal(darColorAleatorio(), -150, PanelJuego.MAX_POSY, false));
		addBolaAlFinal(new BolaNormal(darColorAleatorio(), -180, PanelJuego.MAX_POSY, false));
		addBolaAlFinal(new BolaNormal(darColorAleatorio(), -210, PanelJuego.MAX_POSY, false));
		addBolaAlFinal(new BolaNormal(darColorAleatorio(), -240, PanelJuego.MAX_POSY, false));
		addBolaAlFinal(new BolaNormal(darColorAleatorio(), -270, PanelJuego.MAX_POSY, false));
		addBolaAlFinal(new BolaNormal(darColorAleatorio(), -300, PanelJuego.MAX_POSY, false));
		addBolaAlFinal(new BolaNormal(darColorAleatorio(), -330, PanelJuego.MAX_POSY, false));
		
		ranita = new RanaNormal("c", 290, 200);
	}
	
	
	public Jugador getPrimerJugador() {
		return primerJugador;
	}

	public void setPrimerJugador(Jugador primerJugador) {
		this.primerJugador = primerJugador;
	}
	
	public Rana getRanita() {
		return ranita;
	}

	public void setRanita(Rana ranita) {
		this.ranita = ranita;
	}

	public Bola getPrimerBola() {
		return primerBola;
	}

	public void setPrimerBola(Bola primerBola) {
		this.primerBola = primerBola;
	}
	/** Retorna un numero aleatorio entre 4 y 1 en el cada uno representa
	 * un color 
	 * @return int color
	 */
	public int darColorAleatorio() {
	      return (int) (Math.random() * (5 - 1)+1);
	}
	
	/**
	 * Agrega una nueva bola al final de la lista enlazada 
	 * 
	 * @param nueva
	 *            Bola nueva !=null
	 */
	public void addBolaAlFinal(Bola nueva) {
		Bola actual =primerBola;

		if (actual == null) {
			setPrimerBola(nueva);
		} else {
			while(actual.getSiguiente()!=null) {
				actual=actual.getSiguiente();
			}
		actual.setSiguiente(nueva);
		nueva.setAnterior(actual);
		}

	}
	
	
	/**
	 * Localiza la bola que se encuentre en esa area seleccionada
	 * @param posX
	 * @param posY
	 * @return bola buscada
	 */
	public Bola buscarBolaPosicion(int posX, int posY) {
		Bola actual =primerBola;
		Bola buscada= null;
		
		while(actual!=null&&(!actual.areaX(posX)&&actual.areaY(posY))) {
			actual=actual.getSiguiente();
		}
		buscada=actual;
		
		return buscada;

	}
	
	public void addBolaAntesDe(Bola nueva,int posX, int posY) throws NoExisteException{
		Bola actual =primerBola;

		if (primerBola == null) {
			throw new NoExisteException("No existe la bola");
		} else {
			nueva.setSiguiente(buscarBolaPosicion( posX,  posY));
			buscarBolaPosicion( posX,  posY).getAnterior().setSiguiente(nueva);
			
		
		}

	}


	/**
	 * Verifica si el primerJugador no existe, de lo contrario llama al método
	 * recursivo
	 * 
	 * @param nuevo
	 *            Jugador nuevo a agregar nuevo!=null
	 */
	public void addJugador(Jugador nuevo) {

		if (primerJugador == null) {
			primerJugador = nuevo;
		} else
			primerJugador.addJugador(nuevo);

	}

	/**
	 * Verifica si el primerJugador es el Jugador a eliminar, de lo contrario
	 * utiliza un método recursivo
	 * 
	 * @param eliminar
	 *            Jugador a eliminar eliminar !=null
	 */
	public void removeJugador(Jugador eliminar) {

		if (primerJugador.equals(eliminar)) {
			primerJugador = primerJugador.getSiguiente();
		} else
			primerJugador.removeJugador(eliminar);

	}

	/**
	 * Verifica si el primerJugador es el buscado, de lo contrario hace el llamado
	 * recursivo
	 * 
	 * @param nomJug
	 *            Nombre del Jugador a buscar
	 * @return Jugador encontrado
	 */
	public Jugador buscarJugador(String nomJug) throws NoExisteException {

		if (primerJugador.getNombre().equals(nomJug)) {
			return primerJugador;
		} else {
			if(primerJugador.buscarJugador(nomJug)==null) {
				throw new NoExisteException(nomJug);
			}else{
			return primerJugador.buscarJugador(nomJug);
		}
		}

	}

	

	/**
	 * retorna una lista con todos los jugadores
	 * 
	 * @return lista de los jugadores lista!=null
	 */

	public ArrayList<Jugador> darListaJugadores() {
		ArrayList<Jugador> lista = new ArrayList<Jugador>();
		Jugador j1 = primerJugador;

		while (j1 != null) {

			lista.add(j1);
			j1 = j1.getSiguiente();
		}

		return lista;

	}

	/**
	 * Retorna la lista de jugadores ordenada por sus nombre utilizando el método de
	 * ordenamiento por burbuja
	 * 
	 * @return lista de jugadores ordenados
	 */

	public ArrayList<Jugador> listaOrdenadaNombre() {
		ArrayList<Jugador> lista = darListaJugadores();
		int tamanio = lista.size();

		for (int i = tamanio; i > 0; i--) {
			for (int j = 0; j < i - 1; j++) {
				if (lista.get(j).compareTo(lista.get(j + 1)) > 0) {
					Jugador temp = lista.get(j);

					lista.set(j, lista.get(j + 1));
					lista.set(j + 1, temp);
				}

			}

		}

		return lista;
	}

	/**
	 * Retorna la lista ordenada por apellido de cada Jugador
	 * 
	 * @return lista ordenada lista!=null
	 */

	public ArrayList<Jugador> listaOrdenadaApellido() {
		ArrayList<Jugador> lista = darListaJugadores();
		int tamanio = lista.size();

		for (int i = tamanio; i > 0; i--) {
			for (int j = 0; j < i - 1; j++) {

				if (new ComparadorApellido().compare(lista.get(j), lista.get(j + 1)) > 0) {
					Jugador temp = lista.get(j);

					lista.set(j, lista.get(j + 1));
					lista.set(j + 1, temp);
				}

			}

		}

		return lista;

	}

	/**
	 * Guarda el estado del juego actual
	 * 
	 * @param jugador
	 *            Jugador a guardar jugador !=null;
	 */

	public void serializar(Jugador jugador) {

		try {
			FileOutputStream fileO = new FileOutputStream("Archivos/Datos.dat");

			ObjectOutputStream objectO = new ObjectOutputStream(fileO);

			objectO.writeObject(jugador);
			objectO.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Retorna el Jugador guardado
	 * 
	 * @return Jugador guardado
	 * @throws Exception
	 */
	public Jugador deserializar() throws Exception {

		Jugador descerializado = null;

		FileInputStream fil;

		fil = new FileInputStream("Archivos/Datos.dat");

		ObjectInputStream objec = new ObjectInputStream(fil);

		descerializado = (Jugador) objec.readObject();

		if (objec != null) {
			objec.close();
		}

		return descerializado;

	}

}
