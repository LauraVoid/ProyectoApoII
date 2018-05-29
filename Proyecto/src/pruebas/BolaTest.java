package pruebas;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import excepciones.NoExisteBolaException;
import modelo.Bola;
import modelo.Zuma;

class BolaTest {

	private Bola bola;
	
	private Zuma zuma;

	private void setUpUno() {

		 zuma = new Zuma("n");
		 bola = new Bola(1, 100, Bola.MAX_POSY, false);
		zuma.addBolaAlFinal(bola);
	}
	@Test
	public void moverXTest() {
		setUpUno();

		bola.moverX(1);

		assertTrue(bola.getPosX() == 101);
	}
	
    @Test
	public void moverX2Test() {

		setUpUno();

		bola.moverX2(1);

		assertTrue(bola.getPosX() == 99);

	}
    @Test
    public void moverYTest() {
    	setUpUno();
    	
    	bola.moverY(1);
    	assertTrue(bola.getPosY() == Bola.MAX_POSY-1);
    	
    }
    @Test
    public void moverY2Test() {
    	setUpUno();
    	
    	bola.moverY2(1);
    	assertTrue(bola.getPosY() ==Bola.MAX_POSY+1);
    	
    }
    @Test
    public void areaBolaTest() {
    	setUpUno();
    	Boolean resultado1= bola.areaBola(100, Bola.MAX_POSY);
    	Boolean resultado2= bola.areaBola(10, 200);
    	
    	assertTrue(resultado1);
    	assertFalse(resultado2);
    	
    	
    }
    
    @Test
    public void aumentarPosicionBolaTest() {
    	setUpUno();
    	bola.estaEsquinaDerInf();
    	assertTrue(bola.getPosX()==130);
    }
    	
    
    
}
