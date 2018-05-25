package pruebas;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import modelo.Jugador;
import modelo.Moneda;
import modelo.Zuma;

class JugadorTest {
	
	private Jugador j1;
	
	private void setUpUno() {
		Zuma zuma= new Zuma();
		j1= new Jugador("Jugador1","j1",0);
		zuma.addJugador(j1);	
		
		
	}

	@Test
	public void addMonedaTest() {
		setUpUno();
		Moneda mon1=new Moneda(5);
		Moneda mon2= new Moneda(0);
		Moneda mon3= new Moneda(-5);
		Moneda mon4= new Moneda(8);
		
		j1.addMoneda(mon1);
		j1.addMoneda(mon2);
		j1.addMoneda(mon3);
		j1.addMoneda(mon4);
		
		assertEquals(j1.getRaiz(), mon1);
		assertEquals(j1.getRaiz().getIzq(), mon2);
		assertEquals(j1.getRaiz().getDer(), mon4);
		assertEquals(j1.getRaiz().getIzq().getIzq(), mon3);
		
		
	}
	@Test
	public void removeMoneda() {
		setUpUno();
		
		Moneda mon1=new Moneda(5);
		Moneda mon2= new Moneda(0);
		Moneda mon3= new Moneda(-5);
		Moneda mon4= new Moneda(8);
		
		j1.addMoneda(mon1);
		j1.addMoneda(mon2);
		j1.addMoneda(mon3);
		j1.addMoneda(mon4);
		
		j1.removeMoneda(mon1);
		j1.removeMoneda(mon3);
		
		assertEquals(j1.getRaiz(), mon4);
		assertTrue(j1.getRaiz().getIzq().getIzq()==null);
		
	}
	

}
