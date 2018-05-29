package interfaz;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.AffineTransform;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import excepciones.NoExisteBolaException;
import modelo.Bola;
import modelo.Zuma;

public class PanelJuego extends JPanel implements MouseListener, ActionListener {
	public static final String GUARDAR = "guardar";
	private VentanaPrincipal ventanita;
	private ImageIcon rana;
	private ImageIcon escenario;
	private double rotacion;
	private JButton menu;
	private int color;
	private int contador=0;

	public PanelJuego(VentanaPrincipal ventanita, int a) {
		this.ventanita = ventanita;
		menu = new JButton("Guardar");
		add(menu);
		this.color = a;
		

		rana = new ImageIcon("./imagenes/Rana.png");
		escenario = new ImageIcon("./imagenes/Escenario.png");
		addMouseListener(this);
		menu.addActionListener(this);
		menu.setActionCommand(GUARDAR);
	}

	public double getRotacion() {
		return rotacion;
	}

	public void setRotacion(double rotacion) {
		this.rotacion = rotacion;
	}
	

	public int getContador() {
		return contador;
	}

	public void setContador(int contador) {
		this.contador = contador;
	}

	public void paintComponent(Graphics g) {

		Graphics2D g2 = (Graphics2D) g;

		removeAll();
		super.paintComponent(g2);
		g2.drawImage(escenario.getImage(), 0, 0, null);
		Font font = new Font("Audiowide", Font.BOLD, 20);
		g.setFont(font);
		g2.drawString(ventanita.darNom()+" ", 50, 20);
		
		
		// AffineTransform tx = AffineTransform.getRotateInstance(rotacion,
		// rana.getIconWidth()/2, rana.getIconHeight()/2);
		AffineTransform tx = AffineTransform.getTranslateInstance(ventanita.xRana(), ventanita.yRana());
		tx.rotate(Math.toRadians(rotacion), rana.getIconWidth() / 2, rana.getIconHeight() / 2);

		g2.drawImage(rana.getImage(), tx, null);
		Bola actual = ventanita.darPrimerBola();

		while (actual != null) {

			if (!actual.isDesaparece()) {
				if (actual.getColor() == Bola.AMARILLO)
					g2.setColor(new Color(206, 200, 30));
				else if (actual.getColor() == Bola.VERDE)
					g2.setColor(new Color(55, 163, 40));
				else if (actual.getColor() == Bola.AZUL)
					g2.setColor(new Color(100, 150, 229));
				else if (actual.getColor() == Bola.ROJO)
					g2.setColor(new Color(186, 18, 38));
				else if (actual.getColor() == 5)
					g2.setColor(Color.BLACK);
				g2.fillOval(actual.getPosX(), actual.getPosY(), 30, 30);
			}
			actual = actual.getSiguiente();
		}
		

	

		if (ventanita.darBala().getColor() == Bola.AMARILLO)
			g2.setColor(new Color(206, 200, 30));
		else if (ventanita.darBala().getColor() == Bola.VERDE)
			g2.setColor(new Color(55, 163, 40));
		else if (ventanita.darBala().getColor() == Bola.AZUL)
			g2.setColor(new Color(100, 150, 229));
		else if (ventanita.darBala().getColor() == Bola.ROJO)
			g2.setColor(new Color(186, 18, 38));

		if (!ventanita.darBala().isDesaparece()) {

			g2.fillOval(ventanita.darBala().getPosX(), ventanita.darBala().getPosY(), 30, 30);
		}
		
		int[] colores = ventanita.darColores();
		if (colores[color + 1] == Bola.AMARILLO)
			g2.setColor(new Color(206, 200, 30));
		else if (colores[color + 1] == Bola.VERDE)
			g2.setColor(new Color(55, 163, 40));
		else if (colores[color + 1] == Bola.AZUL)
			g2.setColor(new Color(100, 150, 229));
		else if (colores[color + 1] == Bola.ROJO)
			g2.setColor(new Color(186, 18, 38));
		g2.fillOval(350, 224, 30, 30);

	}

	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals(GUARDAR)) {

		}

	}

	@Override
	public void mouseClicked(MouseEvent e) {

		double x = (e.getX() - ventanita.xRana());
		double y = (e.getY() - ventanita.yRana());
		double r = Math.hypot(x, y);
		double yy = ventanita.yRana() - e.getY();
		double angulo = yy / r;
		double b = Math.toDegrees(angulo);
		setRotacion(b);

		setColor(color + 1);

		ventanita.crearBala(color);

		repaint();
		ventanita.iniciarMovimientoBala(e.getX(), e.getY());
		ventanita.agregarBolaLanzada(e.getX(), e.getY());
	
	
		ventanita.sumarMonedas();
		
		if(contador==1) {
			ImageIcon icon = new ImageIcon("./imagenes/ranaRene.jpg");
			JOptionPane.showMessageDialog(null, "La Rana con poder se ha activado, ahora la velocida es mas lenta", "CRACK", JOptionPane.WARNING_MESSAGE, icon);
			}


	}

	@Override
	public void mouseEntered(MouseEvent e) {

		repaint();
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

	public int getColor() {
		return color;
	}

	public void setColor(int color) {
		this.color = color;
	}

}
