package interfaz;

import java.awt.BorderLayout;
import java.util.ArrayList;

import javax.swing.JFrame;

import hilos.HiloBola;
import modelo.Bola;
import modelo.Zuma;

public class VentanaPrincipal extends JFrame{
	
	private PanelMenu panelMenu;
	private PanelJuego panelJuego;
	private Zuma miZuma;
	
	public VentanaPrincipal() {
		
		setTitle("Zuma");
		
		setLayout(new BorderLayout());
		miZuma= new Zuma();
		panelMenu=new PanelMenu(this);
		panelJuego= new PanelJuego(this);

		add(panelMenu, BorderLayout.CENTER);
		panelJuego.setVisible(false);
		
		setSize(700,515);
		iniciarMovimiento();
	}
	
	
	public void escenarioVisible() {
		panelMenu.setVisible(false);
		panelJuego.setVisible(true);
		add(panelJuego, BorderLayout.CENTER);
	}
	
	public ArrayList<Bola> darBolas(){
		return miZuma.getBolitas();
	}
	
	public void iniciarMovimiento() {
		HiloBola h = new HiloBola(miZuma,this);
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
	


