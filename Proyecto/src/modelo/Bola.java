package modelo;

public class Bola {
	
	private String color;
	private int posX;
	private int posY;
	
	public Bola(String col, int posX,int posY) {
		this.color=col;
		this.posX=posX;
		this.posY=posY;
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
	
	

}
