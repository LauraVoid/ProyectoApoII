package interfaz;

import java.awt.BorderLayout;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import excepciones.NoExisteBolaException;
import excepciones.NoExisteException;
import hilos.HiloBala;
import hilos.HiloBola;
import modelo.Bala;
import modelo.Bola;
import modelo.BolaNormal;
import modelo.Jugador;
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
		panelMenu = new PanelMenu(this);
		panelLista = new PanelListaJugadores(this);
		panelCarga= new PanelCarga();
		add(panelMenu, BorderLayout.CENTER);

		setSize(700, 515);

	}

	public void escenarioVisible() {

		panelJuego = new PanelJuego(this);
		panelMenu.setVisible(false);
		panelJuego.setVisible(true);
		add(panelJuego, BorderLayout.CENTER);

	}
	public void cargar() {
		
		panelMenu.setVisible(false);
	 panelCarga.setVisible(true);
	 add(panelCarga, BorderLayout.CENTER);
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

	public void crearBala() {
		miZuma.getRanita().crearBala();
	}
	
	public void agregarBolaLanzada(int posX, int posY) {
		
		try {
			miZuma.addBolaAntesDe(new BolaNormal(5, miZuma.darPosXBolaAnterior(posX, posY), miZuma.darPosYBolaAnterior(posX, posY), false), posX, posY);
			System.out.println(miZuma.getPrimerBola().getSiguiente().getColor());
		} catch (NoExisteBolaException e) {
			e.getMessage();
		}
		//panelJuego.repaint();
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

	public void cargar(String nombre) throws NullPointerException {
		try {
			System.out.println(nombre.lastIndexOf(0));
		} catch (NullPointerException e) {
			JOptionPane.showMessageDialog(null, "Por favor ingrese un nombre");

		}

	}
	public ArrayList<Jugador> cargarListaNombre() {
		return miZuma.listaOrdenadaNombre();
	}

	public void guardarJugador(String nombre) {
	}

	public static void main(String[] args) {

		VentanaPrincipal ventana = new VentanaPrincipal();

		ventana.setVisible(true);
		ventana.setDefaultCloseOperation(EXIT_ON_CLOSE);

	}

}
