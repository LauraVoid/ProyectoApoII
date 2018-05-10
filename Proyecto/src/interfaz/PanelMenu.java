package interfaz;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PanelMenu extends JPanel implements ActionListener {
	
	private JButton butJugar;
	private JButton butInstruc;
	private JButton butListaJugadores;
	private JButton butCargarPartida;
	private JLabel labMenu;
	public final String JUGAR="jugar";
	public final String INSTRUCCIONES="instrucciones";
	public final String JUGADORES="jugadores";
	public final String CARGAR="cargar";
	private VentanaPrincipal ven;
	
	public PanelMenu(VentanaPrincipal ven) {
		
		this.ven=ven;
		
		setLayout(new GridLayout(5,1));
		butJugar=new JButton("Jugar");
		butJugar.setActionCommand(JUGAR);
		butJugar.addActionListener(this);
		butInstruc= new JButton("Instrucciones");
		butInstruc.setActionCommand(INSTRUCCIONES);
		butInstruc.addActionListener(this);
		butListaJugadores= new JButton("Lista de Jugadores");
		butListaJugadores.setActionCommand(JUGADORES);
		butListaJugadores.addActionListener(this);
		butCargarPartida=new JButton("Cargar Partida");
		butCargarPartida.setActionCommand(CARGAR);
		butCargarPartida.addActionListener(this);
		
		labMenu=new JLabel("Menu");
		
		add(labMenu);
		add(butJugar);
		add(butInstruc);
		add(butListaJugadores);
		add(butCargarPartida);
		
		
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getActionCommand().equals(JUGAR)) {
			
		}
		else if(e.getActionCommand().equals(INSTRUCCIONES)) {
			
		}
		else if(e.getActionCommand().equals(JUGADORES)) {
			
		}
		else if(e.getActionCommand().equals(CARGAR)) {
			
		}
		
	}
	
	

}
