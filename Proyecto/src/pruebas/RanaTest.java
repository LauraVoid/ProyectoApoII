package pruebas;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import modelo.Rana;
import modelo.RanaNormal;
import modelo.Zuma;

class RanaTest {
	
	private Rana ranita;
	
	private void setUpUno() {
		Zuma zuma= new Zuma();
		ranita=new RanaNormal("Azul",0,0);
		zuma.setRanita(ranita);
	}

	@Test
	public void crearBalaTest() {
		setUpUno();
		ranita.crearBala();
		assertTrue(ranita.getBala()!=null);
		
		
	}

}
