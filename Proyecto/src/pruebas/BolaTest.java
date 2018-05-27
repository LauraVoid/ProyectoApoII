package pruebas;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import modelo.Bola;
import modelo.Zuma;

class BolaTest {

	private Bola bola;

	private void setUpUno() {

		Zuma zuma = new Zuma("n");
		bola = new Bola(1, 100, 150, false);
		zuma.setPrimerBola(bola);
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
    	assertTrue(bola.getPosY() == 149);
    	
    }
    @Test
    public void moverY2Test() {
    	setUpUno();
    	
    	bola.moverY2(1);
    	assertTrue(bola.getPosY() ==151);
    	
    }
    @Test
    public void areaBolaTest() {
    	setUpUno();
    	Boolean resultado1= bola.areaBola(100, 150);
    	Boolean resultado2= bola.areaBola(10, 200);
    	
    	assertTrue(resultado1);
    	assertFalse(resultado2);
    	
    	
    }

}
