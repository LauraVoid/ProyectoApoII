package modelo;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import excepciones.NoExisteException;
import interfaz.PanelJuego;

public class Zuma {

	public ArrayList<Bola> bolitas;
	private Jugador primerJugador;
	private Bola primerBola;
	private Rana ranita;

	public Zuma() {

		primerBola = null;
		bolitas = new ArrayList<Bola>();
		bolitas.add(new BolaNormal("VERDE", 0, PanelJuego.MAX_POSY, false));
		bolitas.add(new BolaNormal("AZUL", -30, PanelJuego.MAX_POSY, false));
		bolitas.add(new BolaNormal("NEGRO", -60, PanelJuego.MAX_POSY, false));
		bolitas.add(new BolaNormal("AMARILLO", -90, PanelJuego.MAX_POSY, false));
		bolitas.add(new BolaNormal("ROJO", -120, PanelJuego.MAX_POSY, false));
		ranita = new RanaNormal("c", 290, 200);
	}

	public ArrayList<Bola> getBolitas() {
		return bolitas;
	}

	public void setBolitas(ArrayList<Bola> bolitas) {
		this.bolitas = bolitas;
	}

	public Jugador getPrimerJugador() {
		return primerJugador;
	}

	public void setPrimerJugador(Jugador primerJugador) {
		this.primerJugador = primerJugador;
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
