package pruebas;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import excepciones.NoExisteException;
import modelo.Jugador;
import modelo.Rana;
import modelo.Zuma;

class ZumaTest {
	
	private Zuma zuma;
	
	private void setUpUno() {
		zuma= new Zuma();
	}

	@Test
	public void addJugadorTest() {
		setUpUno();
		Jugador j1= new Jugador("Jugador1",15,0);
		Jugador j2= new Jugador("Jugador2",20,0);
		
		zuma.addJugador(j1);
		zuma.addJugador(j2);
		
		assertTrue(zuma.getPrimerJugador()!=null);
		assertEquals(zuma.getPrimerJugador().getSiguiente().getAnterior(), j1);
		
	}
	
	@Test
	public void removeJugadorTest() {
		setUpUno();
		Jugador j1=new Jugador("Jugador1",6,0);
		Jugador j2=new Jugador("Jugador2",14,0);
		zuma.addJugador(j1);
		zuma.addJugador(j2);
		
		zuma.removeJugador(j2);
		
		assertTrue(zuma.getPrimerJugador().getSiguiente()==null);
		
	}
	@Test
	public void buscarJugadorTest() {
		setUpUno();
		Jugador j1=new Jugador("Jugador1",14,0);
		Jugador j2=new Jugador("Jugador2",6,0);
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
		
		Jugador j1= new Jugador("BB",10,0);
		Jugador j2=new Jugador("AA",11,0);
		Jugador j3=new Jugador("CC",12,0);
		
		zuma.addJugador(j1);
		zuma.addJugador(j2);
		zuma.addJugador(j3);
		
		ArrayList<Jugador> lista1=zuma.listaOrdenadaNombre();
		
		assertEquals(lista1.get(0), j2);
				
	}
	@Test
	public void escribirAchivoTest() {
		setUpUno();
		Rana rana= new Rana("Verde",100,200);
		
		zuma.escribirArchivo(rana);
		
		Rana rana2=zuma.leerArchivo();
		
		assertEquals(rana.getColor(), rana2.getColor());
		assertEquals(rana.getPosX(), rana2.getPosX());
		assertEquals(rana.getPosY(), rana2.getPosY());		
		
		
	}
	@Test
	public void serializarTest() {
		setUpUno();
		Jugador j1= new Jugador("BB",10,0);
		zuma.addJugador(j1);
		
		zuma.serializar(j1);
		
		try {
			Jugador j2=zuma.deserializar();
			assertEquals(j1.getNombre(), j2.getNombre());
			assertEquals(j1.getEdad(), j2.getEdad());
			assertEquals(j1.getPuntos(), j2.getPuntos());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	

}
