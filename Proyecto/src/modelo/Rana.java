package modelo;

public class Rana {
	
	private String color;
	private int posX;
	private int posY;
	private Bala bala;
	private int[] colores;
	
	public Rana(String col, int posX, int posY) {
		
		this.color=col;
		this.posX=posX;
		this.posY=posY;
		colores= new int[200];
		addColores();
		crearBala(0);
	}
	
	/**
	 * Retorna un numero aleatorio entre 4 y 1 en el cada uno representa un color
	 * 
	 * @return int color
	 */
	public int darColorAleatorio() {
		return (int) (Math.random() * (5 - 1) + 1);
	}
	
	public void addColores() {
		for (int i = 0; i < colores.length; i++) {
			colores[i]=darColorAleatorio();
			
		}
		
	}
	
	
	public int[] getColores() {
		return colores;
	}


	public void setColores(int[] colores) {
		this.colores = colores;
	}


	/**
	 * Crea una instancia Bala para la Rana
	 * y agrega la Bala a la Rana
	 */
	public void crearBala(int color) {
		
		Bala bala= new Bala(color,posX+63,posY+27,false);
		setBala(bala);
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
