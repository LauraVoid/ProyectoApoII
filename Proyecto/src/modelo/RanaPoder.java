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
	/**
	 * Agrega un nuevo Poder al árbol
	 * @param nuevo Poder nueva a agregar
	 * nuevo!=null
	 */
	public void addPoder(Poder nuevo) {

		if (raiz == null) {
			raiz = nuevo;

		} else
			raiz.addPoder(nuevo);

	}
	 
	
	

}
