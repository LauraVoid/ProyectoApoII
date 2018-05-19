package modelo;

public class Rana {
	
	private String color;
	private int posX;
	private int posY;
	private Bala bala;
	
	public Rana(String col, int posX, int posY) {
		
		this.color=col;
		this.posX=posX;
		this.posY=posY;
		bala= new Bala("C",posX, posY,false);
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

	public Bala getBala() {
		return bala;
	}

	public void setBala(Bala bala) {
		this.bala = bala;
	}
	
	
	
	

}
