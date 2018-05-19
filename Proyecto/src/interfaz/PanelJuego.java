package interfaz;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.AffineTransform;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;


public class PanelJuego extends JPanel implements MouseListener,ActionListener{
	
    private VentanaPrincipal ventanita;
	private ImageIcon rana;
	private ImageIcon escenario;

	public static final int MAX_POSY=365;
	public  static final int MAX_POSX=655;
	public  static final int MIN_POSY=65;
	public  static final int MIN_POSX=-120;
	public static final int SEGUNDA_POSY=255;
	public static final String ROTAR="Rotar";
	private double rotacion;
	private JButton rotar;
	
	

	public PanelJuego(VentanaPrincipal ventanita) {
		this.ventanita=ventanita;
		rotar= new JButton("Rotar");
		add(rotar);

		rana = new ImageIcon("./imagenes/Rana.png");
		escenario = new ImageIcon("./imagenes/Escenario.png");
		addMouseListener(this);
		rotar.addActionListener(this);
		rotar.setActionCommand(ROTAR);
	}
	
	

	public double getRotacion() {
		return rotacion;
	}
	public void setRotacion(double rotacion) {
		this.rotacion = rotacion;
	}
	
	public void paintComponent(Graphics g) {
		boolean rotar=true;
		Graphics2D g2 = (Graphics2D)g;
		g2.drawImage(escenario.getImage(), 0, 0, null);
		AffineTransform tx = AffineTransform.getRotateInstance(rotacion, rana.getIconWidth()/2, rana.getIconHeight()/2);
		
		if(rotar) {
		g2.drawImage(rana.getImage(), tx, this);
		g2.rotate(rotacion);
		}
		for(int i=0; i<ventanita.darBolas().size();i++) {
			rotar=false;
		    if(!ventanita.darBolas().get(i).isDesaparece()) {
			g.setColor(Color.BLUE);
			
			g.fillOval(ventanita.darBolas().get(i).getPosX(), ventanita.darBolas().get(i).getPosY(), 30, 30);
		    }
		}
	

	}
	
	public void actionPerformed(ActionEvent e) {
//		if(e.getActionCommand().equals(ROTAR)) {
//			setRotacion(getRotacion() + 20);
//	        repaint();
//		}
		
	
	}
	
	

	@Override
	public void mouseClicked(MouseEvent e) {

		System.out.println("X " + e.getX());
		System.out.println("Y " + e.getY());
		double angulo=0;
		double dis= Math.sqrt(((Math.pow((e.getX()-ventanita.xRana()), 2))+(Math.pow((e.getY()-ventanita.yRana()), 2))));
		System.out.println(dis);
		angulo=((e.getY()-ventanita.yRana())/dis);
		System.out.println(angulo);
		
		setRotacion(angulo);
        repaint();
		

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		

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
