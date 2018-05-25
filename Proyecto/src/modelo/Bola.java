package modelo;

import interfaz.PanelJuego;

public class Bola {

	private String color;
	private int posX;
	private int posY;
	
	private boolean desaparece;
	private int x = PanelJuego.MIN_POSX;
	private int y = PanelJuego.MAX_POSY;
	private int x2 = PanelJuego.MAX_POSX;
	private int y2 = PanelJuego.MIN_POSY;

	public Bola(String col, int posX, int posY, boolean desaparece) {
		this.color = col;
		this.posX = posX;
		this.posY = posY;
		this.desaparece = desaparece;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
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

	public void moverY2(int num) {
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
