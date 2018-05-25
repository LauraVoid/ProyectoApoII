package modelo;

public class Bala extends Bola implements BolaMovible {

	public Bala(int col, int posX, int posY, boolean desaparece) {
		super(col, posX, posY, desaparece);
	}

	/**
	 * Mueve la bala teniendo en cuenta los valores que ingresan por parametro
	 * 
	 * @param x
	 *            Posicion en el eje X a donde se desea enviar la bala
	 * @param y
	 *            Posicion en el eje Y a donde se desea enviar la bala
	 */

	public void moverArribaIzquierda(int x, int y) {

		if (x > 50 && x <= 130) {
			moverX2(2);
			moverY(1);
			if (getPosX() + 20 <= x && getPosY() <= y) {
				System.out.println("AI: I desaparecer");
				setDesaparece(true);
			}
		} else if (x > 131 && x <= 260) {
			moverX2(1);
			moverY(1);
			if (getPosX() <= x && getPosY() <= y) {
				System.out.println("AI: II desaparecer");
				setDesaparece(true);

			}

		} else if (x > 261 && x <= 430) {
			moverY(1);
			if (getPosY() <= y) {
				System.out.println("AI: III desaparecer");
				setDesaparece(true);

			}

		}

	}

	/**
	 * Mueve la bala teniendo en cuenta los valores que ingresan por parametro
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
				System.out.println("AD: Idesaparecer");
				setDesaparece(true);
			}
		} else if (x >= 591 && x <= 620) {
			moverX(2);
			moverY(1);
			if (getPosX() + 20 >= x && getPosY() <= y) {
				System.out.println("AD: II desaparecer");
				setDesaparece(true);

			}

		} else if (x >= 621 && y >= 100 && y <= 180 && x <= 670) {
			moverX(2);
			moverY(0.1);
			if (getPosX() >= x) {
				System.out.println("AD: III desaparecer");
				setDesaparece(true);

			}

		}

	}

	@Override
	public void mover(int x, int y) {

		if (x >= 621 && y >= 181 && y <= 300 && x <= 670) {
			moverX(2);
			if (getPosX() >= x) {
				System.out.println("Mover: I desaparecer");
				setDesaparece(true);

			}

		} else if (x >= 621 && y >= 181 && y <= 300 && x <= 670) {

		}

	}

}
