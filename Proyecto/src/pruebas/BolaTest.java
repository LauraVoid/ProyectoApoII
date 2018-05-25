package pruebas;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import modelo.Bola;
import modelo.Zuma;

class BolaTest {

	private Bola bola;

	private void setUpUno() {

		Zuma zuma = new Zuma();
		bola = new Bola(1, 0, 0, false);
		zuma.setPrimerBola(bola);
	}

	@Test
	public void moverXTest() {
		setUpUno();

		bola.moverX(1);

		assertTrue(bola.getPosX() == 1);
	}
	
    @Test
	public void moverX2Test() {

		setUpUno();

		bola.moverX2(1);

		assertTrue(bola.getPosX() == -1);

	}
    @Test
    public void moverYTest() {
    	setUpUno();
    	
    	bola.moverY(1);
    	assertTrue(bola.getPosY() == -1);
    	
    }
    @Test
    public void moverY2Test() {
    	setUpUno();
    	
    	bola.moverY2(1);
    	assertTrue(bola.getPosY() ==1);
    	
    }

}
