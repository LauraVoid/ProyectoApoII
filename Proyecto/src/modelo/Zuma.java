package modelo;

import java.util.ArrayList;

import interfaz.PanelJuego;

public class Zuma {
	
	public ArrayList<Bola> bolitas;
	private Jugador primerJugador;
	private Rana ranita;
	
	
	public Zuma() {
		bolitas = new ArrayList<Bola>();
		bolitas.add(new BolaNormal("VERDE",0,PanelJuego.MAX_POSY, false));
		bolitas.add(new BolaNormal("AZUL",-30,PanelJuego.MAX_POSY, false));
		bolitas.add(new BolaNormal("NEGRO",-60,PanelJuego.MAX_POSY, false ));
		bolitas.add(new BolaNormal("AMARILLO",-90,PanelJuego.MAX_POSY, false));
		bolitas.add(new BolaNormal("ROJO",-120,PanelJuego.MAX_POSY,false));
		ranita= new RanaNormal("c",290,200);
	}
	

	public ArrayList<Bola> getBolitas() {
		return bolitas;
	}

	public void setBolitas(ArrayList<Bola> bolitas) {
		this.bolitas = bolitas;
	}


	public Jugador getPrimerJugador() {
		return primerJugador;
	}


	public void setPrimerJugador(Jugador primerJugador) {
		this.primerJugador = primerJugador;
	}
	public void addJugador(Jugador nuevo) {
		
		if(primerJugador==null) {
			primerJugador=nuevo;
		}
		else
			primerJugador.addJugador(nuevo);
			
	}


	public Rana getRanita() {
		return ranita;
	}


	public void setRanita(Rana ranita) {
		this.ranita = ranita;
	}
	
	

}
