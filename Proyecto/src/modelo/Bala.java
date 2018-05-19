package modelo;

public class Bala extends Bola implements BolaMovible{

	public Bala(String col, int posX, int posY, boolean desaparece) {
		super(col, posX, posY, desaparece);
	}
	
	
	@Override
	public void mover(int x, int y) {
		moverX(5);
		moverY2(5);
		if(getPosX()>=x) {
			if(getPosY()>=y) {
			setDesaparece(true);
			}
		}
		
		
	}
	
	
	

}
