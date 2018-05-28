package hilos;

import interfaz.VentanaPrincipal;
import modelo.BolaNormal;
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
			
			BolaNormal bb=(BolaNormal) zuma.getPrimerBola();
			bb.moverHumilde(1);
			
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			ventana.repaint();
			
		}
	}
	

}
