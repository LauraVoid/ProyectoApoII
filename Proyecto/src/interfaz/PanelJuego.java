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
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import modelo.Bola;
import modelo.Zuma;


public class PanelJuego extends JPanel implements MouseListener,ActionListener{
	
    private VentanaPrincipal ventanita;
	private ImageIcon rana;
	private ImageIcon escenario;

	public static final int MAX_POSY=365;
	public  static final int MAX_POSX=655;
	public  static final int MIN_POSY=65;
	public  static final int MIN_POSX=-330;
	public static final int SEGUNDA_POSY=255;
	public static final String GUARDAR="guardar";
	private double rotacion;
	private JButton menu;
	
	

	public PanelJuego(VentanaPrincipal ventanita) {
		this.ventanita=ventanita;
		menu= new JButton("Guardar");
		add(menu);
		ventanita.iniciarMovimientoBola();

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
	
	public void paintComponent(Graphics g) {
		
		Graphics2D g2 = (Graphics2D)g;
		g2.drawImage(escenario.getImage(), 0, 0, null);
		//AffineTransform tx = AffineTransform.getRotateInstance(rotacion, rana.getIconWidth()/2, rana.getIconHeight()/2);
		AffineTransform tx = AffineTransform.getTranslateInstance(ventanita.xRana(), ventanita.yRana());
		tx.rotate(Math.toRadians(rotacion),rana.getIconWidth()/2, rana.getIconHeight()/2);
		
		g2.drawImage(rana.getImage(), tx, null);
		
		
		Bola actual=ventanita.darPrimerBola();
		
			while(actual!=null) {
		  
			 if(!actual.isDesaparece()) {
		    	if(actual.getColor()==Bola.AMARILLO)g2.setColor(new Color(206, 200, 30));
		    	else if(actual.getColor()==Bola.VERDE)g2.setColor(new Color(55, 163, 40));
		    	else if(actual.getColor()==Bola.AZUL)g2.setColor(new Color(100, 150, 229));
		    	else if(actual.getColor()==Bola.ROJO)g2.setColor(new Color(186, 18, 38));
		    	else if(actual.getColor()==5)g2.setColor(Color.BLACK);//este es pa ensayar la enchoclada, pero esta jodida
			g2.fillOval(actual.getPosX(),actual.getPosY(), 30, 30);
		    }
		    actual=actual.getSiguiente();
		}
		g2.setColor(Color.BLACK);
		g2.fillOval(ventanita.darBala().getPosX(), ventanita.darBala().getPosY(), 30, 30);
		
	

	}
	
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals(GUARDAR)) {
			
		}
		
	
	}
	
	

	@Override
	public void mouseClicked(MouseEvent e) {
		
//		System.out.println("X " + e.getX());
//		System.out.println("Y " + e.getY());
////		double angulo=0;
////		double dis= Math.sqrt(((Math.pow((e.getX()-ventanita.xRana()), 2))+(Math.pow((e.getY()-ventanita.yRana()), 2))));
////		System.out.println(dis);
////		angulo=((ventanita.yRana()-e.getY())/dis);
//		
		double x=(e.getX()-ventanita.xRana());
		double y=(e.getY()-ventanita.yRana());
		double r = Math.hypot(x, y);
		double yy= ventanita.yRana()-e.getY();
		double angulo = yy/r;
		double b = Math.toDegrees(angulo);
//		System.out.println("Para x = " + x + "   y = " + y);
//		System.out.println("hipotenusa = " + r);
//		System.out.println("angulo2 = " + b + "º");
		setRotacion(b);
		ventanita.crearBala();
		ventanita.iniciarMovimientoBala(e.getX(), e.getY());
		
		if(ventanita.darBolaBuscada(e.getX(), e.getY()).getColor()==Bola.AMARILLO)System.out.println("Amarillo");
		else if(ventanita.darBolaBuscada(e.getX(), e.getY()).getColor()==Bola.AZUL)System.out.println("Azul");
		else if(ventanita.darBolaBuscada(e.getX(), e.getY()).getColor()==Bola.ROJO)System.out.println("Rojo");
		else if(ventanita.darBolaBuscada(e.getX(), e.getY()).getColor()==Bola.VERDE)System.out.println("Verde");
        ventanita.agregarBolaLanzada(e.getX(), e.getY());
        System.out.println(ventanita.numeroBolas());
        


		

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
