package pruebas;

import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import modelo.Jugador;
import modelo.Moneda;
import modelo.Zuma;

class JugadorTest {

	private Jugador j1;

	private void setUpUno() {
		Zuma zuma = new Zuma();
		j1 = new Jugador("Jugador1", 12);
		zuma.addJugador(j1);

	}

	@Test
	public void addMonedaTest() {
		setUpUno();
		Moneda mon1 = new Moneda(5);
		Moneda mon2 = new Moneda(0);
		Moneda mon3 = new Moneda(-5);
		Moneda mon4 = new Moneda(8);

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

		Moneda mon1 = new Moneda(5);
		Moneda mon2 = new Moneda(0);
		Moneda mon3 = new Moneda(-5);
		Moneda mon4 = new Moneda(8);

		j1.addMoneda(mon1);
		j1.addMoneda(mon2);
		j1.addMoneda(mon3);
		j1.addMoneda(mon4);

		j1.removeMoneda(mon1);
		j1.removeMoneda(mon3);

		assertEquals(j1.getRaiz(), mon4);
		assertTrue(j1.getRaiz().getIzq().getIzq() == null);

	}

	@Test
	public void darListaMonedaTest() {
		setUpUno();
		Moneda mon1 = new Moneda(3);
		Moneda mon2 = new Moneda(0);
		Moneda mon3 = new Moneda(-5);
		Moneda mon4 = new Moneda(8);

		j1.addMoneda(mon1);
		j1.addMoneda(mon2);
		j1.addMoneda(mon3);
		j1.addMoneda(mon4);

		ArrayList<Moneda> l1 = j1.darListaMonedas();

		assertEquals(l1.get(0), mon1);
		assertEquals(l1.get(1), mon2);
		assertEquals(l1.get(2), mon4);
		assertEquals(l1.get(3), mon3);

	}

	@Test
	public void listaOrdenadaDenTest() {

		setUpUno();
		Moneda mon1 = new Moneda(3);
		Moneda mon2 = new Moneda(0);
		Moneda mon3 = new Moneda(-5);
		Moneda mon4 = new Moneda(8);

		j1.addMoneda(mon1);
		j1.addMoneda(mon2);
		j1.addMoneda(mon3);
		j1.addMoneda(mon4);

		ArrayList<Moneda> l1 = j1.darListaMonOrdenadaDen();

		assertEquals(l1.get(0), mon3);
		assertEquals(l1.get(1), mon2);
		assertEquals(l1.get(2), mon1);
		assertEquals(l1.get(3), mon4);

	}

	@Test
	public void cantidadMonedasTest() {

		setUpUno();
		Moneda mon1 = new Moneda(3);
		Moneda mon2 = new Moneda(0);
		Moneda mon3 = new Moneda(-5);
		Moneda mon4 = new Moneda(8);

		j1.addMoneda(mon1);
		j1.addMoneda(mon2);
		j1.addMoneda(mon3);
		j1.addMoneda(mon4);

		int cantidad = j1.cantidadMonedas();
		assertEquals(cantidad, 4);

	}
	
	@Test
	public void darListaMonedasTest() {
		setUpUno();
		Moneda mon1 = new Moneda(73);
		Moneda mon2 = new Moneda(50);
		Moneda mon3 = new Moneda(35);
		Moneda mon4 = new Moneda(84);
		Moneda mon5 = new Moneda(32);
		Moneda mon6 = new Moneda(40);
		Moneda mon7 = new Moneda(65);
		Moneda mon8 = new Moneda(48);
		Moneda mon9 = new Moneda(19);
		Moneda mon10 = new Moneda(93);
		Moneda mon11= new Moneda(75);
		Moneda mon12= new Moneda(8);

		
		j1.addMoneda(mon1);
		j1.addMoneda(mon2);
		j1.addMoneda(mon3);
		j1.addMoneda(mon4);
		j1.addMoneda(mon5);
		j1.addMoneda(mon6);
		j1.addMoneda(mon7);
		j1.addMoneda(mon8);
		j1.addMoneda(mon9);
		j1.addMoneda(mon10);
		j1.addMoneda(mon11);
		j1.addMoneda(mon12);

		ArrayList<Moneda> l1 = j1.darListaMonedas();
		System.out.println(l1.size());

		assertEquals(j1.cantidadMonedas(), l1.size());
		/**assertEquals(l1.get(0), mon1);
		assertEquals(l1.get(1), mon2);
		assertEquals(l1.get(2), mon3);
		assertEquals(l1.get(3), mon4);
		assertEquals(l1.get(4), mon5);
		assertEquals(l1.get(5), mon6);
		assertEquals(l1.get(6), mon7);
		assertEquals(l1.get(7), mon8);
		assertEquals(l1.get(8), mon9);
		assertEquals(l1.get(9), mon10);
		assertEquals(l1.get(10), mon11);
		assertEquals(l1.get(11), mon12);*/
		

	}

}
