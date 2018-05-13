package hilos;

import interfaz.VentanaPrincipal;
import modelo.Zuma;

public class HiloBola extends Thread{
	
	private Zuma miZuma;
	private VentanaPrincipal ventanita;

	public HiloBola(Zuma miZuma,VentanaPrincipal ventanita) {
		this.miZuma=miZuma;
		this.ventanita=ventanita;
	}
	
	public void run() {
		while(true) {
		for(int i=0;i<miZuma.getBolitas().size();i++) {
			miZuma.getBolitas().get(i).mover();
			try {
				Thread.sleep(5);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			ventanita.repaint();
		}
		}
	}

}
