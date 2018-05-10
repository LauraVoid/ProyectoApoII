package interfaz;

import java.awt.BorderLayout;

import javax.swing.JFrame;

public class VentanaPrincipal extends JFrame {
	
	private PanelMenu panelMenu;
	
	public VentanaPrincipal() {
		
		setTitle("Zuma");
		setLayout(new BorderLayout());
		panelMenu=new PanelMenu(this);

		add(panelMenu, BorderLayout.CENTER);
		pack();
	}
	
	
	
	
	public static void main(String[] args) {
		
		VentanaPrincipal ventana= new VentanaPrincipal();
		
		ventana.setVisible(true);
		ventana.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	}

}
