package hilos;

import interfaz.VentanaPrincipal;
import modelo.Bala;
import modelo.Zuma;

public class HiloBala extends Thread {

	private Zuma miZuma;
	private VentanaPrincipal ventanita;
	private int posX;
	private int posY;

	public HiloBala(Zuma miZuma, VentanaPrincipal ventanita, int posX, int posY) {
		this.miZuma = miZuma;
		this.ventanita = ventanita;
		this.posX = posX;
		this.posY = posY;
	}

	public void run() {

		while (!miZuma.getRanita().getBala().isDesaparece()) {

			if (posX > 50 && posY <= 220 && posX <= 430) {
				miZuma.getRanita().getBala().moverArribaIzquierda(posX, posY);
			} else if (posX > 421 && posX <= 700 && posY <= 180) {
				miZuma.getRanita().getBala().moverArribaDerecha(posX, posY);
			} else if (posX > 431 && posX <= 670 && posY <= 390) {
				miZuma.getRanita().getBala().mover(posX, posY);
			} else if (posX > 50 && posX <= 550 && posY >= 220 && posY <= 390) {
				miZuma.getRanita().getBala().moverAbajo(posX, posY);

			}

			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			ventanita.repaint();
		}
	}
}
