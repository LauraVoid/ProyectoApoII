package interfaz;

import java.awt.BorderLayout;
import java.util.ArrayList;

import javax.swing.JFrame;

import hilos.HiloBala;
import hilos.HiloBola;
import modelo.Bala;
import modelo.Bola;
import modelo.Zuma;

public class VentanaPrincipal extends JFrame{
	
	private PanelMenu panelMenu;
	private PanelJuego panelJuego;
	private PanelListaJugadores panelLista;
	private Zuma miZuma;
	
	public VentanaPrincipal() {
		
		setTitle("Zuma");
		
		setLayout(new BorderLayout());
		miZuma= new Zuma();
		panelMenu=new PanelMenu(this);
		panelLista= new PanelListaJugadores(this);
		
		
		panelJuego= new PanelJuego(this);
		panelJuego.setVisible(false);
		add(panelMenu, BorderLayout.CENTER);
		
		
		setSize(700,515);
		
		
	}
	
	
	public void escenarioVisible() {
		
		panelMenu.setVisible(false);			
	
		panelJuego.setVisible(true);
		add(panelJuego, BorderLayout.CENTER);
		
	}
	public void mostrarLista() {
//		panelMenu.setVisible(false);
		panelLista.setVisible(true);
		

	}
	public void regresarMenu() {
		panelMenu.setVisible(true);
	}
	
	public ArrayList<Bola> darBolas(){
		return miZuma.getBolitas();
	}
	
	public Bala darBala() {
		return miZuma.getRanita().getBala();
	}
	public void crearBala() {
		
//		Bala bala= new Bala("v",xRana(),yRana(),false);		
		miZuma.getRanita().crearBala();
	}
	
	public void iniciarMovimientoBola() {
		HiloBola h = new HiloBola(miZuma,this);
		h.start();
	}
	public void iniciarMovimientoBala(int x, int y) {
		System.out.println("X " +x);
		System.out.println("Y " +y);
		HiloBala h = new HiloBala(miZuma,this, x, y);
		h.start();
		
	}
	
	public int xRana() {
		return miZuma.getRanita().getPosX();
	}
	
	public int yRana() {
		return miZuma.getRanita().getPosY();
	}
	
	
	public static void main(String[] args) {
		
		VentanaPrincipal ventana= new VentanaPrincipal();
		
		ventana.setVisible(true);
		ventana.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	}




	}
	


