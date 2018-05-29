package interfaz;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class PanelMenu extends JPanel implements MouseListener {

	private ImageIcon imagenMenu;

	private VentanaPrincipal ven;

	public PanelMenu(VentanaPrincipal ven) {

		this.ven = ven;
		addMouseListener(this);
		setLayout(new GridLayout(5, 1));

		imagenMenu = new ImageIcon("./imagenes/MenuJuego.png");

	}
	

	public void paintComponent(Graphics g) {

		Graphics2D g2 = (Graphics2D) g;

		g2.drawImage(imagenMenu.getImage(), 0, 0, null);
	}
	
	public void registrarUsuario() throws NumberFormatException{
		try {
		String nombre= JOptionPane.showInputDialog("Ingresa tu nombre", "Nombre");
		String edad= JOptionPane.showInputDialog("Ingresa tu edad", "Edad");
		ven.crearJugador(nombre, Integer.parseInt(edad));
		}catch(NumberFormatException e) {
			
			JOptionPane.showMessageDialog(null, "Digite su EDAD", "ENTRADA ERRONEA", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	

	@Override
	public void mouseClicked(MouseEvent e) {

		if (e.getX() >= 500 && e.getX() <= 600 && e.getY() >= 180 && e.getY() <= 200) {
			registrarUsuario();
		    ven.escenarioVisible();
			ven.iniciarMovimientoBola();
		}

		else if (e.getX() >= 500 && e.getX() <= 640 && e.getY() >= 300 && e.getY() <= 310) {
			ven.mostrarLista();
		} else if (e.getX() >= 500 && e.getX() <= 520 && e.getY() >= 390 && e.getY() <= 400) {
			ven.salirJuego();

		} else if (e.getX() >= 500 && e.getX() <= 600 && e.getY() >= 240 && e.getY() <= 260) {
			String respuesta = JOptionPane.showInputDialog("Ingrese su nombre");
			ven.cargar(respuesta);
		}else
		 ven.cargar();
		// System.out.println("X " +e.getX()+ " Y " +e.getY());

	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

}
