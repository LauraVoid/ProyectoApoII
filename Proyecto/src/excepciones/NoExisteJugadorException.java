package excepciones;

public class NoExisteJugadorException extends Exception{
	
	public NoExisteJugadorException(String nom) {
		super("No existe el jugador " +nom);
	}

}
