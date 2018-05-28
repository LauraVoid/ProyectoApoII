package modelo;

public class Caja {
	
	private int x;
	private int y;
	
	public Caja(int px, int py) {
		this.x=px;
		this.y=py;
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
	
	public void moverHumilde(int num) {
		setX(getX()+num);

	}

}
