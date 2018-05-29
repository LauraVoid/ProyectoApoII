package hilos;

import interfaz.VentanaPrincipal;
import modelo.BolaNormal;
import modelo.Caja;
import modelo.Zuma;

public class HiloCargar extends Thread {
	
	private VentanaPrincipal ventana;
	private Zuma zuma;
	
	public HiloCargar(VentanaPrincipal ven, Zuma z) {
		
		this.zuma=z;
		this.ventana=ven;
		
	}
	public void run() {
		
		while(true) {
			
		
			zuma.getCajita().moverHumilde(1);
			
			try {
				Thread.sleep(5);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			ventana.repaint();
			
		}
	}
	

}
