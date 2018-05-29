package modelo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import excepciones.NoExisteBolaException;
import excepciones.NoExisteException;

public class Zuma implements Contable{

	private Jugador primerJugador;
	private Bola primerBola;
	private Rana ranita;
	private Caja cajita;
	
	public Zuma() {

		primerBola = null;
		
		for(int i=0; i>=Bola.MIN_POSX; i-=Bola.ANCHO_BOLA) {
			addBolaAlFinal(new BolaNormal(darColorAleatorio(), i, Bola.MAX_POSY, false));
		}
		ranita = new RanaNormal("c", 290, 200);
	}
	public Zuma(String n) {
		
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

	/**
	 * Retorna un numero aleatorio entre 4 y 1 en el cada uno representa un color
	 * 
	 * @return int color
	 */
	public int darColorAleatorio() {
		return (int) (Math.random() * (5 - 1) + 1);
	}
	/**
	 * Recorre la lista hasta encontrar el ultimo 
	 * @return bola Ultima bola de las lista
	 *  bola !=null
	 */
	public Bola darUltima() {
		Bola bola=primerBola;
		while(bola.getSiguiente()!=null) {
			
			bola=bola.getSiguiente();
		}
		
		return bola;
	}

	/**
	 * Agrega una nueva bola al final de la lista enlazada
	 * 
	 * @param nueva
	 *            Bola nueva !=null
	 */
	public void addBolaAlFinal(Bola nueva) {
		Bola actual = primerBola;

		if (actual == null) {
			setPrimerBola(nueva);
		} else {
			while (actual.getSiguiente() != null) {
				actual = actual.getSiguiente();
			}
			actual.setSiguiente(nueva);
			nueva.setAnterior(actual);
		}

	}

	/**
	 * Localiza la bola que se encuentre en esa area seleccionada
	 * 
	 * @param posX
	 * @param posY
	 * @return bola buscada
	 */
	public Bola buscarBolaPosicion(int posX, int posY) throws NoExisteBolaException {
		Bola actual = primerBola;
		Bola buscada = null;

		while (actual != null && !(actual.areaBola(posX, posY))) {
			actual = actual.getSiguiente();
		}
		buscada = actual;
		if (buscada == null)
			throw new NoExisteBolaException();

		return buscada;

	}

	/**
	 * Agreg
	 * @param nueva
	 * @param posX
	 * @param posY
	 * @throws NoExisteBolaException
	 */
	public void addBolaAntesDe(Bola nueva, int posX, int posY) throws NoExisteBolaException {
		System.out.println("color add bola " +nueva.getColor());

		if (primerBola == null) {
			throw new NoExisteBolaException();
		} else {
		    aumentarPosiciones(posX, posY);
			nueva.setSiguiente(buscarBolaPosicion(posX, posY));
			buscarBolaPosicion(posX, posY).getAnterior().setSiguiente(nueva);
			nueva.setAnterior(buscarBolaPosicion(posX, posY).getAnterior());
			buscarBolaPosicion(posX, posY).setAnterior(nueva);
			eliminarBola(nueva, posX, posY);
			sumarMonedas(nueva, posX, posY);
		}
	}
////
	/**
	 * Retorna la posicion X de la bola anterior a la bola seleccionada
	 * 
	 * @param posX
	 * @param posY
	 * @return pos Bola
	 * @throws NoExisteBolaException
	 */
	public int darPosXBolaAnterior(int posX, int posY) throws NoExisteBolaException {
		return buscarBolaPosicion(posX, posY).getAnterior().getPosX();

	}

	/**
	 * Retorna la posicion Y de la bola anterior a la bola seleccionada
	 * 
	 * @param posX
	 * @param posY
	 * @return
	 * @throws NoExisteBolaException
	 */
	public int darPosYBolaAnterior(int posX, int posY) throws NoExisteBolaException {
		return buscarBolaPosicion(posX, posY).getAnterior().getPosY();
	}

	/**
	 * Aumenta las posiciones de las bolas, empezando desde la primera hasta la
	 * seleccionada
	 * 
	 * @param posX
	 * @param posY
	 * 
	 */
	// Aqui estoy tratando de que cuando este abajo aumente el x de las bolas desde
	// la primera hasta la que selecciono, si esta a la izquierda que le disminuya a
	// y
	// a las mismas bolas, pero eso se descontrola.
	/**public void aumentarPosiciones(int posX, int posY) throws NoExisteBolaException {
		Bola actual = primerBola;

		while (actual != null && (actual != buscarBolaPosicion(posX, posY))) {

			if (actual.getPosX() >= Bola.MIN_POSX && actual.getPosY() == Bola.MAX_POSY )
				actual.setPosX(actual.getPosX() + Bola.ANCHO_BOLA);
			
			if ((actual.getPosX() >= Bola.MAX_POSX) && (actual.getPosY() <= Bola.MAX_POSY))
				actual.setPosY(actual.getPosY() - Bola.ALTO_BOLA);
			if ((actual.getPosY() <= Bola.MIN_POSY) && (actual.getPosX() <= Bola.MAX_POSX))
				actual.setPosX(actual.getPosX() - Bola.ANCHO_BOLA);
			if ((actual.getPosX() <= Bola.ANCHO_BOLA) && (actual.getPosY() <= Bola.SEGUNDA_POSY))
				actual.setPosY(actual.getPosY() + Bola.ALTO_BOLA);
			

 			actual = actual.getSiguiente();
		}
	}*/
	
	public void aumentarPosiciones(int posX, int posY) throws NoExisteBolaException {
		Bola actual = primerBola;
		boolean esta=true;
		int resta=0;
		int faltante=0;

		while (actual != null && (actual != buscarBolaPosicion(posX, posY))) {

			if (actual.getPosX() <= Bola.MAX_POSX && actual.getPosY() <= Bola.MAX_POSY ) {
				actual.estaEsquinaDerInf();
			}
			
				
			/**if ((actual.getPosY() <= Bola.MIN_POSY) && (actual.getPosX() <= Bola.MAX_POSX))
				actual.setPosX(actual.getPosX() - Bola.ANCHO_BOLA);
			if ((actual.getPosX() <= Bola.ANCHO_BOLA) && (actual.getPosY() <= Bola.SEGUNDA_POSY))
				actual.setPosY(actual.getPosY() + Bola.ALTO_BOLA);*/
			

 			actual = actual.getSiguiente();
		}
	}
	
	
	
	public boolean eliminarBola(Bola nueva,int x, int y) throws NoExisteBolaException {
		boolean elimino =false;
		Bola actual =buscarBolaPosicion(x, y);
		
		if(actual.getColor()==nueva.getColor()) {
		Bola sigBuscada= actual.getSiguiente();
		Bola anteriorNueva=nueva.getAnterior();
		sigBuscada.setAnterior(anteriorNueva);
		anteriorNueva.setSiguiente(sigBuscada);
		elimino=true;
		}
		return elimino;
		
		
		
		
	}

	/**
	 * Cuenta el numero de bolas de la lista
	 * 
	 * @return
	 */
	@Override
	public int contar() {
		Bola actual = primerBola;
		int contador = 0;
		while (actual != null) {
			contador++;
			actual = actual.getSiguiente();
		}
		return contador;
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
			if (primerJugador.buscarJugador(nomJug) == null) {
				throw new NoExisteException(nomJug);
			} else {
				return primerJugador.buscarJugador(nomJug);
			}
		}

	}
	
	public void sumarMonedas(Bola nueva, int x, int y) throws NoExisteBolaException {
		Jugador actual =primerJugador;
		while(actual!=null) {
			if(eliminarBola(nueva, x, y)) {
				actual.addMoneda(new Moneda((int) (Math.random()*100)));
			}
			actual=actual.getSiguiente();
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
	 * Retorna la lista ordenada por edad de cada Jugador
	 * 
	 * @return lista ordenada lista!=nulll
	 */

	public ArrayList<Jugador> listaOrdenadaEdad() {
		ArrayList<Jugador> lista = darListaJugadores();
		int tamanio = lista.size();

		for (int i = tamanio; i > 0; i--) {
			for (int j = 0; j < i - 1; j++) {

				if (new ComparadorEdad().compare(lista.get(j), lista.get(j + 1)) > 0) {
					
					Jugador temp = lista.get(j);

					lista.set(j, lista.get(j + 1));
					lista.set(j + 1, temp);
				}

			}

		}

		return lista;

	}

	/**
	 * Crea una lista de Bolas
	 * 
	 * @return un ArrayList con las Bolas
	 */
	public ArrayList<Bola> darListaBolas() {
		ArrayList<Bola> lista = new ArrayList<Bola>();
		Bola bol = primerBola;
		while (bol != null) {

			lista.add(bol);
			bol = bol.getSiguiente();
		}
		return lista;
	}

	/**
	 * Ordena la lista de bolas segun el atributo X con el método de insercion
	 * 
	 * @return lista ordena de menor a mayor
	 */

	public ArrayList<Bola> bolasOrdenadaX() {
		ArrayList<Bola> lista = darListaBolas();

		int tam = lista.size();
		for (int i = 1; i < tam; i++) {
			for (int j = i; j > 0 && lista.get(j - 1).getPosX() > lista.get(j).getPosX(); j--) {

				Bola tem = lista.get(j);
				lista.set(j, lista.get(j - 1));
				lista.set(j - 1, tem);

			}

		}
		return lista;
	}

	/**
	 * Ordena la lista de bolas segun el atributo Y con el método de insercion
	 * 
	 * @return lista ordena de menor a mayor
	 */
	public ArrayList<Bola> bolasOrdenadaY() {
		ArrayList<Bola> lista = darListaBolas();

		int tam = lista.size();
		for (int i = 1; i < tam; i++) {
			for (int j = i; j > 0 && lista.get(j - 1).getPosY() > lista.get(j).getPosY(); j--) {

				Bola tem = lista.get(j);
				lista.set(j, lista.get(j - 1));
				lista.set(j - 1, tem);

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
		
//		jugador= new Jugador(jugador.getNombre(),jugador.getEdad(),jugador.getPuntos());

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

	/**
	 * Guarda la informacion de la rana en un archivo de texto plano en el siguiente
	 * formato: ColorRana, PosXRana,PosYRana
	 * 
	 * @param rana
	 *            !=null
	 */

	public void escribirArchivo(Rana rana) {

		String[] informacion = { rana.getColor(), rana.getPosX() + "", rana.getPosY()+"" };

		File archivo = new File("Archivos/InformacionRana.txt/");

		try {
			FileWriter fEscritor = new FileWriter(archivo);
			BufferedWriter bEscritor = new BufferedWriter(fEscritor);
			for (int i = 0; i < informacion.length; i++) {
				bEscritor.write(informacion[i]);
				bEscritor.write(" ");

			}

			bEscritor.close();

		} catch (IOException e) {

			e.printStackTrace();
		}

	}
	/**
	 * Lee el archivo donde fue almacenada la informacion de la rana
	 * @return nueva Rana nueva 
	 */

	public Rana leerArchivo() {
		Rana nueva = null;
		String linea="";

		File archivo = new File("Archivos/InformacionRana.txt/");

		try {
			FileReader lector = new FileReader(archivo);
			BufferedReader bR = new BufferedReader(lector);
			linea = bR.readLine();


			lector.close();
			bR.close();

		} catch (FileNotFoundException e) {

			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		}
		String[] datos=linea.split(" ");
		
		nueva=new Rana(datos[0],Integer.parseInt(datos[1]), Integer.parseInt(datos[2]));
		
		return nueva;

	}
	public Caja getCajita() {
		return cajita;
	}
	public void setCajita(Caja cajita) {
		this.cajita = cajita;
	}
	
	

}
