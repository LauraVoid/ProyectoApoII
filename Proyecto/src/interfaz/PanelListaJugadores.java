package interfaz;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.TextArea;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;

public class PanelListaJugadores extends JDialog {
	
	private TextArea txtAMostrar;
	private JButton ordenar;
	private JButton buscar;
	private JButton regresar;
	public final static String ORDENAR="ordenar";
	public final static String BUSCAR= "buscar";
	public final static String 	REGRESAR="regresar";
	private VentanaPrincipal ventanita;
	
	public PanelListaJugadores(VentanaPrincipal ven) {
		
		setLayout(new BorderLayout());
		setTitle("Lista de Jugadores");
		this.ventanita=ven;
		
		txtAMostrar= new TextArea();
		ordenar= new JButton("Ordenar");
		buscar= new JButton("Buscar");
		regresar= new JButton("Regresar");
		
		JPanel panelAuxiliar= new JPanel();
		panelAuxiliar.setLayout(new GridLayout(1,3));
		panelAuxiliar.add(ordenar);
		panelAuxiliar.add(buscar);
		panelAuxiliar.add(regresar);	
		
		add(panelAuxiliar, BorderLayout.NORTH);
		add(txtAMostrar, BorderLayout.CENTER);
		
		setSize(700,515);
		
	}
	

}
