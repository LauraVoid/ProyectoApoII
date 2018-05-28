package hilos;

import interfaz.VentanaPrincipal;
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
			
			
			
		}
	}
	

}
