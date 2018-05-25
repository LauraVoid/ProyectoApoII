package pruebas;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import excepciones.NoExisteException;
import modelo.Jugador;
import modelo.Zuma;

class ZumaTest {
	
	private Zuma zuma;
	
	private void setUpUno() {
		zuma= new Zuma();
	}

	@Test
	public void addJugadorTest() {
		setUpUno();
		Jugador j1= new Jugador("Jugador1","j1",0);
		Jugador j2= new Jugador("Jugador2","j2",0);
		
		zuma.addJugador(j1);
		zuma.addJugador(j2);
		
		assertTrue(zuma.getPrimerJugador()!=null);
		assertEquals(zuma.getPrimerJugador().getSiguiente().getAnterior(), j1);
		
	}
	
	@Test
	public void removeJugadorTest() {
		setUpUno();
		Jugador j1=new Jugador("Jugador1","j1",0);
		Jugador j2=new Jugador("Jugador2","j2",0);
		zuma.addJugador(j1);
		zuma.addJugador(j2);
		
		zuma.removeJugador(j2);
		
		assertTrue(zuma.getPrimerJugador().getSiguiente()==null);
		
	}
	@Test
	public void buscarJugadorTest() {
		setUpUno();
		Jugador j1=new Jugador("Jugador1","j1",0);
		Jugador j2=new Jugador("Jugador2","j2",0);
		zuma.addJugador(j1);
		zuma.addJugador(j2);
		
		try {
			Jugador encontrado=zuma.buscarJugador("Jugador2");
			assertEquals(j2, encontrado);
		} catch (NoExisteException e) {
			e.printStackTrace();
		}
		
	}
	
	@Test
	public void JugadoresOrdenadaNombreTest() {
		setUpUno();
		
		Jugador j1= new Jugador("BB","bb",0);
		Jugador j2=new Jugador("AA","aa",0);
		Jugador j3=new Jugador("CC","cc",0);
		
		zuma.addJugador(j1);
		zuma.addJugador(j2);
		zuma.addJugador(j3);
		
		ArrayList<Jugador> lista1=zuma.listaOrdenadaNombre();
		
		assertEquals(lista1.get(0), j2);
				
	}
	
	

}
