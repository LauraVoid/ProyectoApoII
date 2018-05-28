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
		crearBala();
	}
	/**
	 * Crea una instancia Bala para la Rana
	 * y agrega la Bala a la Rana
	 */
	public void crearBala() {
		
		Bala bala= new Bala(0,posX+63,posY+27,false);
		setBala(bala);
	}

	/**
	 * Retorna un numero aleatorio entre 4 y 1 en el cada uno representa un color
	 * 
	 * @return int color
	 */
	public int darColorAleatorio() {
		return (int) (Math.random() * (5 - 1) + 1);
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
