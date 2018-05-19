package interfaz;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class PanelMenu extends JPanel implements MouseListener{
	
	
	private ImageIcon imagenMenu;
	
	private VentanaPrincipal ven;
	
	public PanelMenu(VentanaPrincipal ven) {
		
		this.ven=ven;
		addMouseListener(this);
		setLayout(new GridLayout(5,1));
		
		
		imagenMenu=new ImageIcon("./imagenes/MenuJuego.png");
		
		
		
		
	}
	
	public void paintComponent(Graphics g) {
		
		Graphics2D g2= (Graphics2D)g;
		
		g2.drawImage(imagenMenu.getImage(), 0, 0, null);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		
		if(e.getX()>=500 && e.getX()<=600 && e.getY()>=180 && e.getY()<=200) {
		ven.escenarioVisible();
		}
		
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
