package modelo;

public class RanaNormal extends Rana{
	
	private Poder raiz;

	public RanaNormal(String col, int posX, int posY) {
		super(col, posX, posY);
	}

	public Poder getRaiz() {
		return raiz;
	}

	public void setRaiz(Poder raiz) {
		this.raiz = raiz;
	}
	
	
	
	

}
