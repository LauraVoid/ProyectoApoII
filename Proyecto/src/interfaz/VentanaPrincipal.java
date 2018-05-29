package interfaz;

import java.awt.BorderLayout;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import excepciones.NoExisteBolaException;
import excepciones.NoExisteJugadorException;
import hilos.HiloBala;
import hilos.HiloBola;
import hilos.HiloCargar;
import modelo.Bala;
import modelo.Bola;
import modelo.BolaNormal;
import modelo.Caja;
import modelo.Jugador;
import modelo.Poder;
import modelo.RanaPoder;
import modelo.Zuma;

public class VentanaPrincipal extends JFrame {

	private PanelMenu panelMenu;
	private PanelJuego panelJuego;
	private PanelCarga panelCarga;
	private PanelListaJugadores panelLista;
	private Zuma miZuma;

	public VentanaPrincipal() {

		setTitle("Zuma");

		setLayout(new BorderLayout());

		miZuma = new Zuma();
		agregarXXX();
		// crearPoderes();
		panelMenu = new PanelMenu(this);
		panelLista = new PanelListaJugadores(this);
		panelCarga = new PanelCarga(this);
		panelJuego = new PanelJuego(this, 0);
		add(panelMenu, BorderLayout.CENTER);

		setSize(700, 515);

	}

	public void escenarioVisible() {

		panelMenu.setVisible(false);
		panelJuego.setVisible(true);
		add(panelJuego, BorderLayout.CENTER);

	}
	public String darNom() {
		return miZuma.getPrimerJugador().getNombre();
	}

	public void crearPoderes() {

		RanaPoder rana = new RanaPoder("c", 290, 200);

		rana.addPoder(new Poder(4));
		rana.addPoder(new Poder(1));
		rana.addPoder(new Poder(2));
		rana.addPoder(new Poder(3));
		rana.addPoder(new Poder(5));
		rana.addPoder(new Poder(6));
		miZuma.setRanita(rana);

	}

	public void cargar() {
		Caja caja = new Caja(100, 170);
		miZuma.setCajita(caja);
		HiloCargar hilo = new HiloCargar(this, miZuma);
		hilo.start();
		panelMenu.setVisible(false);
		panelCarga.setVisible(true);
		add(panelCarga, BorderLayout.CENTER);
	}

	public Caja darCaja() {
		return miZuma.getCajita();
	}

	public void mostrarLista() {
		panelLista.setVisible(true);

	}

	public void regresarMenu() {
		panelMenu.setVisible(true);
	}

	public Bala darBala() {
		return miZuma.getRanita().getBala();
	}

	public void crearBala(int color) {

		System.out.println("crear Bola " + color);
		miZuma.getRanita().crearBala(miZuma.getRanita().getColores()[color]);
		Bala balita = miZuma.getRanita().getBala();

	}

	public int[] darColores() {
		return miZuma.getRanita().getColores();
	}

	public void agregarBolaLanzada(int posX, int posY) {

		try {
			miZuma.addBolaAntesDe(new BolaNormal(miZuma.getRanita().getBala().getColor(),
					miZuma.darPosXBolaAnterior(posX, posY), miZuma.darPosYBolaAnterior(posX, posY), false), posX, posY);

		} catch (NoExisteBolaException e) {
			ImageIcon icon = new ImageIcon("./imagenes/ranita.png");
			JOptionPane.showMessageDialog(null, e.getMessage(), "LANZA MEJOR", JOptionPane.WARNING_MESSAGE, icon);
		} catch (NullPointerException e) {
			ImageIcon icon = new ImageIcon("./imagenes/ranita.png");
			JOptionPane.showMessageDialog(null, "Intenta otro tiro", "LANZA MEJOR", JOptionPane.WARNING_MESSAGE, icon);
		}

	}

	public void iniciarMovimientoBola() {

		HiloBola h = new HiloBola(miZuma, this);
		h.start();
	}

	public void iniciarMovimientoBala(int x, int y) {
		System.out.println("X " + x + " Y " + y);

		HiloBala h = new HiloBala(miZuma, this, x, y);
		h.start();

	}

	public Bola darPrimerBola() {
		return miZuma.getPrimerBola();
	}

	public int xRana() {
		return miZuma.getRanita().getPosX();
	}

	public int yRana() {
		return miZuma.getRanita().getPosY();
	}

	public void salirJuego() {
		System.exit(0);
	}

	public Bola darBolaBuscada(int posX, int posY) throws NoExisteBolaException {
		return miZuma.buscarBolaPosicion(posX, posY);
	}

	public int numeroBolas() {
		return miZuma.contar();
	}

	public void crearJugador(String nombre, int edad) {
		Jugador j1 = new Jugador(nombre, edad);
		miZuma.setPrimerJugador(j1);

	}

	public void sumarMonedas() {

		int n = miZuma.getPrimerJugador().darMonedas();

		if (n >= 150) {
			panelJuego.setContador(panelJuego.getContador() + 1);
			crearPoderes();

		}
	}

	// BORRAR
	public void agregarXXX() {
		Jugador j1 = new Jugador("David Ospina", 79);
		Jugador j2 = new Jugador("Camilo Vargas", 82);
		Jugador j3 = new Jugador("Jose Cuadrado", 90);
		Jugador j4 = new Jugador("Santiago Arias", 72);
		Jugador j5 = new Jugador("Yerry Mina", 81);
		Jugador j6 = new Jugador("Davinson Sanchez ", 200);
		Jugador j7 = new Jugador("Cristian Zapata", 50);
		Jugador j8 = new Jugador("Oscar Murillo", 150);

		miZuma.addJugador(j1);
		miZuma.addJugador(j2);
		miZuma.addJugador(j3);
		miZuma.addJugador(j4);
		miZuma.addJugador(j5);
		miZuma.addJugador(j6);
		miZuma.addJugador(j7);
		miZuma.addJugador(j8);

		miZuma.serializar(miZuma.getPrimerJugador());
	}

	public void cargar(String nombre) throws NullPointerException {
		try {
			miZuma.setPrimerJugador(miZuma.deserializar());
		} catch (NullPointerException e) {
			JOptionPane.showMessageDialog(null, "Por favor ingrese un nombre");

		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			Jugador carga = miZuma.buscarJugador(nombre);
			miZuma.setPrimerJugador(carga);
			if (carga != null) {
				escenarioVisible();
			}
		} catch (NoExisteJugadorException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public ArrayList<Jugador> cargarListaNombre() {
		ArrayList<Jugador> list = new ArrayList<Jugador>();
		try {
			miZuma.setPrimerJugador(miZuma.deserializar());
		} catch (Exception e) {
			e.printStackTrace();
		}
		list = miZuma.listaOrdenadaNombre();
		return list;
	}

	public ArrayList<Jugador> cargarListaEdad() {
		ArrayList<Jugador> list = new ArrayList<Jugador>();
		try {
			miZuma.setPrimerJugador(miZuma.deserializar());
		} catch (Exception e) {
			e.printStackTrace();
		}
		list = miZuma.listaOrdenadaEdad();
		return list;
	}

	public Jugador bucarJugador(String nomJug) {
		Jugador jj = null;
		try {
			miZuma.setPrimerJugador(miZuma.deserializar());

		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			jj = miZuma.buscarJugador(nomJug);
		} catch (NoExisteJugadorException e) {
			JOptionPane.showMessageDialog(null, "No existe el jugador buscado");
		}
		return jj;

	}

	public void guardarJugador(String nombre) {

		Jugador j;
		try {
			j = miZuma.buscarJugador(nombre);
			miZuma.serializar(j);
		} catch (NoExisteJugadorException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void main(String[] args) {

		VentanaPrincipal ventana = new VentanaPrincipal();

		ventana.setVisible(true);
		ventana.setDefaultCloseOperation(EXIT_ON_CLOSE);

	}

}
