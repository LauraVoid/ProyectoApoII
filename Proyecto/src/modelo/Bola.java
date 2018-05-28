package modelo;

import java.util.ArrayList;

import interfaz.PanelJuego;

public class Bola {
	

	public static final int AMARILLO = 1;
	public static final int ROJO = 2;
	public static final int AZUL = 3;
	public static final int VERDE = 4;
	
	public static final int MAX_POSY = 365;
	public static final int MAX_POSX = 655;
	public static final int MIN_POSY = 65;
	public static final int MIN_POSX = -450;
	public static final int SEGUNDA_POSY = 255;
	public static final int ANCHO_BOLA = 30;
	public static final int ALTO_BOLA = 30;
	private int color;

	private int posX;
	private int posY;
	private boolean desaparece;
	private Bola siguiente;
	private Bola anterior;
	private int x = MIN_POSX;
	private int y = MAX_POSY;
	private int x2 = MAX_POSX;
	private int y2 = MIN_POSY;

	public Bola(int col, int posX, int posY, boolean desaparece) {
		siguiente = null;
		anterior = null;
		this.color = col;
		this.posX = posX;
		this.posY = posY;
		this.desaparece = desaparece;

	}

	public int getColor() {
		return color;
	}

	public void setColor(int color) {
		this.color = color;
	}

	public Bola getSiguiente() {
		return siguiente;
	}

	public void setSiguiente(Bola siguiente) {
		this.siguiente = siguiente;
	}

	public Bola getAnterior() {
		return anterior;
	}

	public void setAnterior(Bola anterior) {
		this.anterior = anterior;
	}

	public int getPosX() {
		return posX;
	}

	public void setPosX(int posX) {
		this.posX = posX;
	}

	public int getPosY() {
		return posY;
	}

	public void setPosY(int posY) {
		this.posY = posY;
	}

	public boolean isDesaparece() {
		return desaparece;
	}

	public void setDesaparece(boolean desaparece) {
		this.desaparece = desaparece;
	}

	public void moverX(double num) {
		posX += num;
	}

	public void moverY(double num) {
		posY -= num;
	}

	public void moverX2(int num) {
		posX -= num;
	}

	public void moverY2(double num) {
		posY += num;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	/**
	 * Verifica si la bola se encuentra en el rango especificado l
	 * 
	 * @param posX
	 * @param posY
	 * @return true, si la bola esta en ese rango y false en caso contrario
	 */
	public boolean areaBola(int posX, int posY) {
		return ((posX >= this.getPosX()) && (posX <= this.getPosX() + ANCHO_BOLA))
				&& ((posY >= this.getPosY()) && (posY <= this.getPosY() + ALTO_BOLA));
	}

	// public void mover() {
	//
	//
	// if(posX>=x&&posY==y) {
	//
	// moverX(5);
	// }
	// if(posX>=x2&&posY<=y) {
	//
	// moverY(5);
	//
	// }
	// if(posY<=y2) {
	//
	// moverX2(5);
	// }
	// if(posX<=30&&posY<=PanelJuego.SEGUNDA_POSY) {
	//
	// moverY2(5);
	//
	// if(posY>=PanelJuego.SEGUNDA_POSY) {
	// setPosY(PanelJuego.SEGUNDA_POSY);
	// setY(PanelJuego.SEGUNDA_POSY);
	// setX2(300);
	// }
	// }
	// if(posX>=300&&posX<=360&&posY>=PanelJuego.SEGUNDA_POSY-40&&posY<=PanelJuego.SEGUNDA_POSY)
	// {
	// setDesaparece(true);
	// }
	//
	//
	//
	//
	//
	// }
	//
	// public void moverBala(int num, int x) {
	//
	// posX+=10;
	// if(posX>=num) {
	// setDesaparece(true);
	// }
	//
	//
	// }
	// Paila nos jodimos
	// c mamut

	public int getX2() {
		return x2;
	}

	public void setX2(int x2) {
		this.x2 = x2;
	}

	public int getY2() {
		return y2;
	}

	public void setY2(int y2) {
		this.y2 = y2;
	}

	//
	// public void mover() {
	//
	//
	// if(posX>=x&&posY==y) {
	//
	// moverX(5);
	// }
	// if(posX>=x2&&posY<=y) {
	//
	// moverY(5);
	//
	// }
	// if(posY<=y2) {
	//
	// moverX2(5);
	// }
	// if(posX<=x&&posY>=y2) {
	//
	// moverY2(5);
	//
	// if(posY>=PanelJuego.SEGUNDA_POSY) {
	// setPosY(PanelJuego.SEGUNDA_POSY);
	// setY(PanelJuego.SEGUNDA_POSY);
	// setX2(300);
	// }
	// }
	// if(posX>=300&&posX<=360&&posY>=PanelJuego.SEGUNDA_POSY-40&&posY<=PanelJuego.SEGUNDA_POSY)
	// {
	// setDesaparece(true);
	// }
	//
	//
	//
	//
	//
	// }

	// public void mover() {
	//
	//
	// if(posX>=x&&posY==y) {
	//
	// moverX(5);
	// }
	// if(posX>=x2&&posY<=y) {
	//
	// moverY(5);
	//
	// }
	// if(posY<=y2) {
	//
	// moverX2(5);
	// }
	// if(posX<=30&&posY<=PanelJuego.SEGUNDA_POSY) {
	//
	// moverY2(5);
	//
	// if(posY>=PanelJuego.SEGUNDA_POSY) {
	// setPosY(PanelJuego.SEGUNDA_POSY);
	// setY(PanelJuego.SEGUNDA_POSY);
	// setX2(300);
	// }
	// }
	// if(posX>=300&&posX<=360&&posY>=PanelJuego.SEGUNDA_POSY-40&&posY<=PanelJuego.SEGUNDA_POSY)
	// {
	// setDesaparece(true);
	// }
	//
	//
	//
	//
	//
	// }
	//
	// public void moverBala(int num) {
	//
	// posX+=10;
	// if(posX>=num) {
	// setDesaparece(true);
	// }
	//
	//
	// }
	// Paila nos jodimos

}
