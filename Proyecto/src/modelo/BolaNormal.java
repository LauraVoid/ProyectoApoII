package modelo;

public class BolaNormal extends Bola {

	public BolaNormal(int col, int posX, int posY, boolean desaparece) {
		super(col, posX, posY, desaparece);
	}
/**
	public void mover(int x, int y) {

		if (getPosX() >= getX() && getPosY() == getY()) {

			moverX(1);
		}
		if (getPosX() >= getX2() && getPosY() <= getY()) {

			moverY(1);

		}
		if (getPosY() <= getY2()) {

			moverX2(1);
		}
		if (getPosX() <= 30 && getPosY() <= Bola.SEGUNDA_POSY) {

			moverY2(1);

			if (getPosY() >= Bola.SEGUNDA_POSY) {
				setPosY(Bola.SEGUNDA_POSY);
				setY(Bola.SEGUNDA_POSY);
				setX2(300);
			}
		}
		if (getPosX() >= 300 && getPosX() <= 360 && getPosY() >= Bola.SEGUNDA_POSY - 40
				&& getPosY() <= Bola.SEGUNDA_POSY) {
			setDesaparece(true);
		}

	}*/
	public void mover(int x, int y) {

		if (getPosX() >= getX() && getPosY() >= getY()) {

			moverX(1);
		}
		if (getPosX() >= getX2() && getPosY() <= getY()) {

			moverY(1);

		}
		if (getPosY() <= getY2()) {

			moverX2(1);
		}
		if (getPosX() <= 30 && getPosY() <= Bola.SEGUNDA_POSY) {

			moverY2(1);

			if (getPosY() >= Bola.SEGUNDA_POSY) {
				setPosY(Bola.SEGUNDA_POSY);
				setY(Bola.SEGUNDA_POSY);
				setX2(300);
			
			}
		}
		if(getPosX()>=0&&getPosX()<=300&&getPosY()>=Bola.SEGUNDA_POSY) {
			moverX(5);
			if(getPosX()>=300&&getPosY()==Bola.SEGUNDA_POSY)
			setDesaparece(true);
		}
		if (getPosX() >= 300 && getPosX() <= 360 && getPosY() >= Bola.SEGUNDA_POSY - 40
				&& getPosY() <= Bola.SEGUNDA_POSY) {
			setDesaparece(true);
		}

	}

	

	/**
	 * public void mover(int x, int y) {
	 * 
	 * 
	 * if(getPosX()>=getX()&&getPosY()==getY()) {
	 * 
	 * moverX(5); } if(getPosX()>=getX2()&&getPosY()<=getY()) {
	 * 
	 * moverY(5);
	 * 
	 * } if(getPosY()<=getY2()) {
	 * 
	 * moverX2(5); } if(getPosX()<=30&&getPosY()<=PanelJuego.SEGUNDA_POSY) {
	 * 
	 * moverY2(5);
	 * 
	 * if(getPosY()>=PanelJuego.SEGUNDA_POSY) { setPosY(PanelJuego.SEGUNDA_POSY);
	 * setY(PanelJuego.SEGUNDA_POSY); setX2(300); } }
	 * if(getPosX()>=300&&getPosX()<=360&&getPosY()>=PanelJuego.SEGUNDA_POSY-40&&getPosY()<=PanelJuego.SEGUNDA_POSY)
	 * { setDesaparece(true); }
	 * 
	 * 
	 * 
	 * 
	 * 
	 * }
	 */

}
