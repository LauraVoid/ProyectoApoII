package modelo;

public class RanaPoder extends Rana{

	private Poder raiz;
	
	public RanaPoder(String col, int posX, int posY) {
		super(col, posX, posY);
		raiz=null;
	}

	public Poder getRaiz() {
		return raiz;
	}

	public void setRaiz(Poder raiz) {
		this.raiz = raiz;
	}
	 
	
	

}
