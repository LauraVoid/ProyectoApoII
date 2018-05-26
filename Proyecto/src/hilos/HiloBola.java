package hilos;

import interfaz.VentanaPrincipal;
import modelo.Bola;
import modelo.BolaNormal;
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
			Bola actual=miZuma.getPrimerBola();
			while(actual!=null) {
				
		
			BolaNormal bola = (BolaNormal) actual;
			bola.mover(0,0);
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			ventanita.repaint();
			actual=actual.getSiguiente();
		}
		}
	}

}
