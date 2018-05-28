package interfaz;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class PanelCarga extends JPanel {

	private ImageIcon imagen;
	private VentanaPrincipal ven;

	public PanelCarga() {
		setSize(700, 515);
//		this.ven=v;
		imagen = new ImageIcon("./imagenes/fondo-negro.jpg");

	}

	public void paintComponent(Graphics g) {

		g.drawImage(imagen.getImage(), 0, 0, null);
		Font font = new Font("Audiowide", Font.BOLD, 50);
		g.setFont(font);
		g.setColor(new Color(78, 105, 150));
		g.drawString("Cargando...", 200, 70);

		// Polygon polygon = new Polygon();
		// polygon.addPoint(350,230);
		// polygon.addPoint(400,305);
		// polygon.addPoint(450,350);
		// polygon.addPoint(500,400);
		// g.fillPolygon(polygon);

		

		g.setColor(new Color(226, 31, 48));
		g.drawRect(220, 200, 30, 30);
		g.fillRect(250, 200, 30, 30);
		g.drawRect(280, 200, 30, 30);

		g.fillRect(320, 200, 30, 30);
		g.drawRect(350, 200, 30, 30);
		g.fillRect(380, 200, 30, 30);

		g.drawRect(420, 200, 30, 30);
		g.fillRect(450, 200, 30, 30);
		g.drawRect(480, 200, 30, 30);
		
		g.setColor(new Color(226, 213, 31));
		g.fillArc(ven.darPrimerBola().getPosX(), ven.darPrimerBola().getPosY(), 80, 80, 50, 275);

	}

}
