package modelo;

import java.util.Comparator;

public class ComparadorEdad implements Comparator<Jugador> {

	/**
	 * Compara la edad de dos jugadores
	 * 
	 * @return la diferencia entre la edad de los dos jugadores
	 */
	@Override
	public int compare(Jugador j1, Jugador j2) {
		return j1.getEdad() - j2.getEdad();
	}

}
