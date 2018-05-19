package modelo;

import interfaz.PanelJuego;

public class BolaNormal extends Bola implements BolaMovible{

	public BolaNormal(String col, int posX, int posY, boolean desaparece) {
		super(col, posX, posY, desaparece);
	}
	
	@Override
	public void mover(int x, int y) {
		
		
		if(getPosX()>=getX()&&getPosY()==getY()) {
			
			moverX(5);
		}
		if(getPosX()>=getX2()&&getPosY()<=getY()) {
			
		moverY(5);
		
		}
		if(getPosY()<=getY2()) {
			
			moverX2(5);
		}
		if(getPosX()<=30&&getPosY()<=PanelJuego.SEGUNDA_POSY) {
			
			moverY2(5);
			
			if(getPosY()>=PanelJuego.SEGUNDA_POSY) {
				setPosY(PanelJuego.SEGUNDA_POSY);
				setY(PanelJuego.SEGUNDA_POSY);
				setX2(300);
			}
		}
		if(getPosX()>=300&&getPosX()<=360&&getPosY()>=PanelJuego.SEGUNDA_POSY-40&&getPosY()<=PanelJuego.SEGUNDA_POSY) {
			setDesaparece(true);
		}
		
		
		
		
		
	}
	
	
	
	

}
