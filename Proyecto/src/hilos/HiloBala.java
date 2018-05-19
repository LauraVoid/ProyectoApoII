package hilos;

import interfaz.VentanaPrincipal;
import modelo.Bala;
import modelo.BolaNormal;
import modelo.Zuma;

public class HiloBala extends Thread{

	

	private Zuma miZuma;
	private VentanaPrincipal ventanita;
	private int posX;
	private int posY;

	public HiloBala(Zuma miZuma,VentanaPrincipal ventanita, int posX, int posY) {
		this.miZuma=miZuma;
		this.ventanita=ventanita;
		this.posX=posX;
		this.posY=posY;
	}
	
	public void run() {
		while(!miZuma.getRanita().getBala().isDesaparece()) {
		
			
			miZuma.getRanita().getBala().mover(posX, posY);
			
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			ventanita.repaint();
		}
		}
	}


