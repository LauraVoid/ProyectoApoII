package interfaz;

import java.awt.BorderLayout;


import javax.swing.JFrame;

public class VentanaPrincipal extends JFrame{
	
	private PanelMenu panelMenu;
	private PanelJuego panelJuego;
	
	public VentanaPrincipal() {
		
		setTitle("Zuma");
		setLayout(new BorderLayout());
		panelMenu=new PanelMenu(this);
		panelJuego= new PanelJuego();

		add(panelMenu, BorderLayout.CENTER);
		panelJuego.setVisible(false);
		
		setSize(700,515);
	}
	
	public void escenarioVisible() {
		panelMenu.setVisible(false);
		panelJuego.setVisible(true);
		add(panelJuego, BorderLayout.CENTER);
	}
	
	
	public static void main(String[] args) {
		
		VentanaPrincipal ventana= new VentanaPrincipal();
		
		ventana.setVisible(true);
		ventana.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	}




	}
	


