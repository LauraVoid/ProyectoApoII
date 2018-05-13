package interfaz;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class PanelJuego extends JPanel implements MouseListener {
	
    private VentanaPrincipal ventanita;
	private ImageIcon rana;
	private ImageIcon escenario;

	public static final int MAX_POSY=365;
	public  static final int MAX_POSX=655;
	public  static final int MIN_POSY=65;
	public  static final int MIN_POSX=0;
	public static final int SEGUNDA_POSY=255;
	
	

	public PanelJuego(VentanaPrincipal ventanita) {
		this.ventanita=ventanita;

		rana = new ImageIcon("./imagenes/Rana.png");
		escenario = new ImageIcon("./imagenes/Escenario.png");
		addMouseListener(this);
	}

	public void paintComponent(Graphics g) {

		g.drawImage(escenario.getImage(), 0, 0, null);
		g.drawImage(rana.getImage(), 290, 200, null);
		for(int i=0; i<ventanita.darBolas().size();i++) {
		    if(!ventanita.darBolas().get(i).isDesaparece()) {
			g.setColor(Color.BLUE);
			g.fillOval(ventanita.darBolas().get(i).getPosX(), ventanita.darBolas().get(i).getPosY(), 30, 30);
		    }
		}

	}

	@Override
	public void mouseClicked(MouseEvent e) {

		System.out.println("X " + e.getX());
		System.out.println("Y " + e.getY());

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
