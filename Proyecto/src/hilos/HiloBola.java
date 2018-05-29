package hilos;

import interfaz.VentanaPrincipal;
import modelo.Bola;
import modelo.BolaNormal;
import modelo.RanaNormal;
import modelo.RanaPoder;
import modelo.Zuma;

public class HiloBola extends Thread{
	
	private Zuma miZuma;
	private VentanaPrincipal ventanita;

	public HiloBola(Zuma miZuma,VentanaPrincipal ventanita) {
		this.miZuma=miZuma;
		this.ventanita=ventanita;
//		ventanita.crearPoderes();
	}
	
	public void run() {
		while(true) {
			Bola actual=miZuma.getPrimerBola();
			while(actual!=null) {
				
		
			BolaNormal bola = (BolaNormal) actual;
			bola.mover(0,0);
			try {
				if(miZuma.getRanita() instanceof RanaNormal) {
				Thread.sleep(1);
				}else if(miZuma.getRanita() instanceof RanaPoder) {
					RanaPoder rana= (RanaPoder)miZuma.getRanita();
					Thread.sleep(rana.darPoderAleatorio().getVelocidad());
				}
				
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			ventanita.repaint();
			actual=actual.getSiguiente();
		}
		}
	}

}
