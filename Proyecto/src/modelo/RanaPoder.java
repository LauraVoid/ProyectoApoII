package modelo;

public class RanaPoder extends Rana {

	private Poder raiz;

	public RanaPoder(String col, int posX, int posY) {
		super(col, posX, posY);
		raiz = null;
	}
	

	public Poder getRaiz() {
		return raiz;
	}

	public void setRaiz(Poder raiz) {
		this.raiz = raiz;
	}

	/**
	 * Agrega un nuevo Poder al árbol
	 * 
	 * @param nuevo
	 *            Poder nueva a agregar nuevo!=null
	 */
	public void addPoder(Poder nuevo) {

		if (raiz == null) {
			raiz = nuevo;

		} else
			raiz.addPoder(nuevo);

	}

	public Poder buscarPoder(int num) {

		if (raiz.getVelocidad() == num) {
			return raiz;
		} else if (raiz.getVelocidad() >= num) {
			if (raiz.getIzq() != null) {
				return raiz.getIzq().buscarPoder(num);
			} else
				return null;
		} else if (raiz.getDer() != null) {
			return raiz.getDer().buscarPoder(num);
		} else
			return null;
	}
	public Poder darPoderAleatorio() {
		
		int valor=(int) (Math.random() * (7 - 1) + 1);
//		System.out.println(valor);
		return buscarPoder(valor);
	}

}
