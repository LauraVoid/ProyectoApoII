package interfaz;

import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class PanelJuego extends JPanel implements MouseListener {

	private ImageIcon rana;
	private ImageIcon escenario;
	public int PRIMER_HORIZONTAL_Y=365;
	public int PRIMER_VERTICAL_X=655;
	public int SEGUNDA_HORIZONTAL_Y=65;
	public int SEGUNDA_VERTICAL_X=65;
	public int TERCERA_HORIZONTAL_Y=255;
	
	

	public PanelJuego() {

		rana = new ImageIcon("./imagenes/Rana.png");
		escenario = new ImageIcon("./imagenes/Escenario.png");
		addMouseListener(this);
	}

	public void paintComponent(Graphics g) {

		g.drawImage(escenario.getImage(), 0, 0, null);
		g.drawImage(rana.getImage(), 290, 200, null);

	}

	@Override
	public void mouseClicked(MouseEvent e) {

//		System.out.println("X " + e.getX());
//		System.out.println("Y " + e.getY());

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
