package excepciones;

public class NoExisteException extends Exception{
	
	public NoExisteException(String nom) {
		super("No existe el jugador " +nom);
	}

}
