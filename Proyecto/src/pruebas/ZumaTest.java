package pruebas;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import excepciones.NoExisteBolaException;
import excepciones.NoExisteException;
import modelo.Bola;
import modelo.BolaNormal;
import modelo.Jugador;
import modelo.Rana;
import modelo.Zuma;

class ZumaTest {

	private Zuma zuma;

	private void setUpUno() {
		zuma = new Zuma("n");
	}

	@Test
	public void addJugadorTest() {
		setUpUno();
		Jugador j1 = new Jugador("Jugador1", 15);
		Jugador j2 = new Jugador("Jugador2", 20);

		zuma.addJugador(j1);
		zuma.addJugador(j2);

		assertTrue(zuma.getPrimerJugador() != null);
		assertEquals(zuma.getPrimerJugador().getSiguiente().getAnterior(), j1);

	}

	@Test
	public void removeJugadorTest() {
		setUpUno();
		Jugador j1 = new Jugador("Jugador1", 6);
		Jugador j2 = new Jugador("Jugador2", 14);
		zuma.addJugador(j1);
		zuma.addJugador(j2);

		zuma.removeJugador(j2);

		assertTrue(zuma.getPrimerJugador().getSiguiente() == null);

	}

	@Test
	public void buscarJugadorTest() {
		setUpUno();
		Jugador j1 = new Jugador("Jugador1", 14);
		Jugador j2 = new Jugador("Jugador2", 6);
		zuma.addJugador(j1);
		zuma.addJugador(j2);

		try {
			Jugador encontrado = zuma.buscarJugador("Jugador2");
			assertEquals(j2, encontrado);
		} catch (NoExisteException e) {
			e.printStackTrace();
		}

	}

	@Test
	public void JugadoresOrdenadaNombreTest() {
		setUpUno();

		Jugador j1 = new Jugador("BB", 10);
		Jugador j2 = new Jugador("AA", 11);
		Jugador j3 = new Jugador("CC", 12);

		zuma.addJugador(j1);
		zuma.addJugador(j2);
		zuma.addJugador(j3);

		ArrayList<Jugador> lista1 = zuma.listaOrdenadaNombre();

		assertEquals(lista1.get(0), j2);

	}

	@Test
	public void darColorAleatorioTest() {
		setUpUno();
		int color = zuma.darColorAleatorio();

		assertTrue(color >= 1 && color <= 4);

	}

	@Test
	public void addBolaAlFinalTest() {
		setUpUno();

		BolaNormal bola1 = new BolaNormal(4, 100, 200, false);
		BolaNormal bola2 = new BolaNormal(3, 209, 300, false);
		BolaNormal bola3 = new BolaNormal(2, 381, 150, false);
		BolaNormal bola4 = new BolaNormal(2, 5, 630, false);

		zuma.addBolaAlFinal(bola1);
		assertTrue(zuma.darUltima().equals(bola1));
		zuma.addBolaAlFinal(bola2);
		assertTrue(zuma.darUltima().equals(bola2));
		zuma.addBolaAlFinal(bola3);
		assertTrue(zuma.darUltima().equals(bola3));
		zuma.addBolaAlFinal(bola4);
		assertTrue(zuma.darUltima().equals(bola4));

	}

	@Test
	public void buscarBolaPosicion() {
		setUpUno();

		BolaNormal bola1 = new BolaNormal(4, 100, 200, false);
		BolaNormal bola2 = new BolaNormal(3, 209, 300, false);
		BolaNormal bola3 = new BolaNormal(2, 381, 150, false);
		zuma.addBolaAlFinal(bola1);
		zuma.addBolaAlFinal(bola2);
		zuma.addBolaAlFinal(bola3);

		try {
			Bola encontrada = zuma.buscarBolaPosicion(100, 200);
			Bola encontrada1 = zuma.buscarBolaPosicion(209, 300);
			assertTrue(encontrada.equals(bola1));
			assertFalse(encontrada1.equals(bola3));
		} catch (NoExisteBolaException e) {
			e.printStackTrace();
		}

	}

	@Test
	public void addBolaAntesDeTest() {
		setUpUno();

		BolaNormal bola1 = new BolaNormal(4, 100, 200, false);
		BolaNormal bola2 = new BolaNormal(3, 209, 300, false);
		BolaNormal bola3 = new BolaNormal(2, 381, 150, false);
		zuma.addBolaAlFinal(bola1);
		zuma.addBolaAlFinal(bola2);

		try {
			zuma.addBolaAntesDe(bola3, 209, 300);
			assertTrue(zuma.getPrimerBola().getSiguiente().equals(bola3));
			assertTrue(zuma.getPrimerBola().getSiguiente().getAnterior().equals(bola1));
		} catch (NoExisteBolaException e) {
			e.printStackTrace();
		}

	}

	@Test
	public void darPosXBolaAnteriorTest() {
		setUpUno();

		BolaNormal bola1 = new BolaNormal(4, 100, 200, false);
		BolaNormal bola2 = new BolaNormal(3, 209, 300, false);
		BolaNormal bola3 = new BolaNormal(2, 381, 150, false);
		zuma.addBolaAlFinal(bola1);
		zuma.addBolaAlFinal(bola2);
		zuma.addBolaAlFinal(bola3);

		try {
			int posXAnterior = zuma.darPosXBolaAnterior(381, 150);
			int posXAnterior1 = zuma.darPosYBolaAnterior(209, 300);
			assertEquals(posXAnterior, bola2.getPosX());
			assertFalse(posXAnterior1 == bola3.getPosX());
		} catch (NoExisteBolaException e) {
			e.printStackTrace();
		}

	}

	@Test
	public void darPosYBolaAnterior() {
		setUpUno();

		BolaNormal bola1 = new BolaNormal(4, 100, 200, false);
		BolaNormal bola2 = new BolaNormal(3, 209, 300, false);
		BolaNormal bola3 = new BolaNormal(2, 381, 150, false);
		zuma.addBolaAlFinal(bola1);
		zuma.addBolaAlFinal(bola2);
		zuma.addBolaAlFinal(bola3);

		try {
			int posYAnterior = zuma.darPosYBolaAnterior(209, 300);
			int posYAnterior1 = zuma.darPosYBolaAnterior(209, 300);
			assertEquals(posYAnterior, bola1.getPosY());
			assertFalse(posYAnterior1 == bola3.getPosY());
		} catch (NoExisteBolaException e) {
			e.printStackTrace();
		}

	}

	public void aumentarPosicionesTest() {

	}

	@Test
	public void JugadoresOrdenadaEdadTest() {
		setUpUno();

		Jugador j1 = new Jugador("BB", 10);
		Jugador j2 = new Jugador("AA", 11);
		Jugador j3 = new Jugador("CC", 12);

		zuma.addJugador(j1);
		zuma.addJugador(j2);
		zuma.addJugador(j3);

		ArrayList<Jugador> lista1 = zuma.listaOrdenadaEdad();

		assertEquals(lista1.get(0), j1);
		assertEquals(lista1.get(1), j2);
		assertEquals(lista1.get(2), j3);

	}

	@Test
	public void escribirAchivoTest() {
		setUpUno();
		Rana rana = new Rana("Verde", 100, 200);

		zuma.escribirArchivo(rana);

		Rana rana2 = zuma.leerArchivo();

		assertEquals(rana.getColor(), rana2.getColor());
		assertEquals(rana.getPosX(), rana2.getPosX());
		assertEquals(rana.getPosY(), rana2.getPosY());

	}

	@Test
	public void serializarTest() {
		setUpUno();
		Jugador j1 = new Jugador("BB", 10);
		zuma.addJugador(j1);

		zuma.serializar(j1);

		try {
			Jugador j2 = zuma.deserializar();
			assertEquals(j1.getNombre(), j2.getNombre());
			assertEquals(j1.getEdad(), j2.getEdad());
			assertEquals(j1.getPuntos(), j2.getPuntos());
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Test
	public void darListaBolaTest() {
		setUpUno();
		BolaNormal bola1 = new BolaNormal(4, 100, 200, false);
		BolaNormal bola2 = new BolaNormal(3, 209, 300, false);
		BolaNormal bola3 = new BolaNormal(2, 381, 150, false);
		BolaNormal bola4 = new BolaNormal(2, 5, 630, false);

		zuma.addBolaAlFinal(bola1);
		zuma.addBolaAlFinal(bola2);
		zuma.addBolaAlFinal(bola3);
		zuma.addBolaAlFinal(bola4);

		ArrayList<Bola> lista = zuma.darListaBolas();

		assertEquals(lista.get(0).getPosX(), bola1.getPosX());

	}

	@Test
	public void bolasOrdenadaXTest() {

		setUpUno();
		BolaNormal bola1 = new BolaNormal(4, 100, 200, false);
		BolaNormal bola2 = new BolaNormal(3, 209, 300, false);
		BolaNormal bola3 = new BolaNormal(2, 381, 150, false);
		BolaNormal bola4 = new BolaNormal(2, 5, 630, false);

		zuma.addBolaAlFinal(bola1);
		zuma.addBolaAlFinal(bola2);
		zuma.addBolaAlFinal(bola3);
		zuma.addBolaAlFinal(bola4);

		ArrayList<Bola> bolitas = zuma.bolasOrdenadaX();

		assertEquals(bolitas.get(0).getPosX(), bola4.getPosX());
		assertEquals(bolitas.get(1).getPosX(), bola1.getPosX());
		assertEquals(bolitas.get(2).getPosX(), bola2.getPosX());
		assertEquals(bolitas.get(3).getPosX(), bola3.getPosX());

	}

	@Test
	public void bolasOrdenadaYTest() {

		setUpUno();
		BolaNormal bola1 = new BolaNormal(4, 100, 200, false);
		BolaNormal bola2 = new BolaNormal(3, 209, 300, false);
		BolaNormal bola3 = new BolaNormal(2, 381, 150, false);
		BolaNormal bola4 = new BolaNormal(2, 5, 630, false);

		zuma.addBolaAlFinal(bola1);
		zuma.addBolaAlFinal(bola2);
		zuma.addBolaAlFinal(bola3);
		zuma.addBolaAlFinal(bola4);

		ArrayList<Bola> bolitas = zuma.bolasOrdenadaY();

		assertEquals(bolitas.get(0).getPosY(), bola3.getPosY());
		assertEquals(bolitas.get(1).getPosY(), bola1.getPosY());
		assertEquals(bolitas.get(2).getPosY(), bola2.getPosY());
		assertEquals(bolitas.get(3).getPosY(), bola4.getPosY());

	}

}
