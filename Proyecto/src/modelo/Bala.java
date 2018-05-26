package modelo;

public class Bala extends Bola implements BolaMovible {

	public Bala(int col, int posX, int posY, boolean desaparece) {
		super(col, posX, posY, desaparece);
	}

	/**
	 * Mueve la bala teniendo en cuenta los valores que ingresan por parametro Mueve
	 * la bala entre la parte superior izquierda
	 * 
	 * @param x
	 *            Posicion en el eje X a donde se desea enviar la bala
	 * @param y
	 *            Posicion en el eje Y a donde se desea enviar la bala
	 */

	public void moverArribaIzquierda(int x, int y) {
		

		if (x >= 50 && x <= 130) {
			moverX2(2);
			moverY(1);
			if (getPosX() + 20 <= x && getPosY() <= y) {
				setDesaparece(true);
			}
		} else if (x >= 131 && x <= 260) {
			moverX2(1);
			moverY(1);
			if (getPosX() <= x && getPosY() <= y) {
				setDesaparece(true);

			}

		} else if (x >= 261 && x <= 430) {
			moverY(1);
			if (getPosY() <= y) {
				setDesaparece(true);

			}

		}

	}

	/**
	 * Mueve la bala teniendo en cuenta los valores que ingresan por parametro Mueve
	 * la bala en el rango superior derecho
	 * 
	 * @param x
	 *            Posicion en el eje X a donde se desea enviar la bala
	 * @param y
	 *            Posicion en el eje Y a donde se desea enviar la bala
	 */

	public void moverArribaDerecha(int x, int y) {

		if (x >= 431 && x <= 590) {
			moverX(1);
			moverY(1);
			if (getPosX() + 45 >= x && getPosY() <= y) {
				setDesaparece(true);
			}
		} else if (x >= 591 && x <= 620) {
			moverX(2);
			moverY(1);
			if (getPosX() + 20 >= x && getPosY() <= y) {
				setDesaparece(true);

			}

		} else if (x >= 621 && y >= 60 && y <= 180 && x <= 670) {
			moverX(2);
			moverY(0.1);
			if (getPosX() >= x) {
				setDesaparece(true);

			}

		}

	}

	@Override
	public void mover(int x, int y) {

		if (x >= 589 && y >= 181 && y <= 310 && x <= 671) {
			moverX(1);
			if (getPosX() >= x) {
				setDesaparece(true);

			}

		} else if (x >= 550 && y >= 311 && y <= 400 && x <= 700) {
			moverX(2);
			moverY2(1);
			if (getPosX() >= x) {
				setDesaparece(true);
			}
		} else if (x >= 421 && y >= 350 && y <= 390 && x <= 550) {
			moverX(1);
			moverY2(1);
			if (getPosY() >= y) {
				setDesaparece(true);
			}
		}

	}

	public void moverAbajo(int x, int y) {
		

		if (x >= 280 && y >= 350 && y <= 390 && x <= 550) {
			moverY2(1);
			if (getPosY() >= y) {
				setDesaparece(true);

			}
		} else if (x >= 50 && y >= 350 && y <= 380 && x <= 280) {
			moverY2(1);
			moverX2(1);
			if (getPosX() - 100 <= x && getPosY() >= y) {
				setDesaparece(true);

			}
		}
		else if (x >= 60 && y >= 220 && y <= 280 && x <= 300) {
			
			moverX2(1);
			if (getPosX() <= x) {
				setDesaparece(true);

			}
		}

	}

}
