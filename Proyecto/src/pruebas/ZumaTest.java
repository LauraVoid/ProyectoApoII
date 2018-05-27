package pruebas;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

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
		Jugador j1 = new Jugador("Jugador1", 15, 0);
		Jugador j2 = new Jugador("Jugador2", 20, 0);

		zuma.addJugador(j1);
		zuma.addJugador(j2);

		assertTrue(zuma.getPrimerJugador() != null);
		assertEquals(zuma.getPrimerJugador().getSiguiente().getAnterior(), j1);

	}

	@Test
	public void removeJugadorTest() {
		setUpUno();
		Jugador j1 = new Jugador("Jugador1", 6, 0);
		Jugador j2 = new Jugador("Jugador2", 14, 0);
		zuma.addJugador(j1);
		zuma.addJugador(j2);

		zuma.removeJugador(j2);

		assertTrue(zuma.getPrimerJugador().getSiguiente() == null);

	}

	@Test
	public void buscarJugadorTest() {
		setUpUno();
		Jugador j1 = new Jugador("Jugador1", 14, 0);
		Jugador j2 = new Jugador("Jugador2", 6, 0);
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

		Jugador j1 = new Jugador("BB", 10, 0);
		Jugador j2 = new Jugador("AA", 11, 0);
		Jugador j3 = new Jugador("CC", 12, 0);

		zuma.addJugador(j1);
		zuma.addJugador(j2);
		zuma.addJugador(j3);

		ArrayList<Jugador> lista1 = zuma.listaOrdenadaNombre();

		assertEquals(lista1.get(0), j2);

	}

	@Test
	public void JugadoresOrdenadaEdadTest() {
		setUpUno();

		Jugador j1 = new Jugador("BB", 10, 0);
		Jugador j2 = new Jugador("AA", 11, 0);
		Jugador j3 = new Jugador("CC", 12, 0);

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
		Jugador j1 = new Jugador("BB", 10, 0);
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
