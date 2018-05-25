package modelo;

public class Bala extends Bola implements BolaMovible {

	public Bala(String col, int posX, int posY, boolean desaparece) {
		super(col, posX, posY, desaparece);
	}

	public void moverArribaIzquierda(int x, int y) {
		
		if (x > 50 && x <= 130) {
			moverX2(2);
			moverY(1);
			if (getPosX()+20<=x &&getPosY()<= y) {
				System.out.println("desaparecer");
				setDesaparece(true);
			}
		} else if (x >131 && x <= 260) {
			moverX2(1);
			moverY(1);
			if (getPosX() <= x && getPosY()<= y) {
				System.out.println(" II desaparecer");
				setDesaparece(true);

			}

		} else if (x > 261 && x <= 430) {
			moverY(1);
			if (getPosY() <= y) {
				System.out.println(" II desaparecer");
				setDesaparece(true);

			}

		}


	}

	public void moverArribaDerecha(int x, int y) {
		
		
		if (x >= 431 && x <= 590) {
			moverX(1);
			moverY(1);
			if (getPosX()+45>=x && getPosY() <=y) {
				System.out.println("desaparecer");
				setDesaparece(true);
			}
		} else if (x >=591 && x <= 634) {
			moverX(2);
			moverY(1);
			if (getPosX()>= x && getPosY()<= y) {
				System.out.println(" II desaparecer");
				setDesaparece(true);

			}

		} else if (x >=635 && x <=660) {
			moverX(2);
			if (getPosX()>=x) {
				System.out.println(" II desaparecer");
				setDesaparece(true);

			}

		}

	}

	@Override
	public void mover(int x, int y) {
		// TODO Auto-generated method stub
		
	}
	

}
