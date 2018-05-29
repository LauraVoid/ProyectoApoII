package interfaz;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import modelo.Jugador;

public class PanelListaJugadores extends JDialog implements ActionListener {

	private TextArea txtAMostrar;
	private JButton ordenar;
	private JButton buscar;
	private JButton regresar;
	public static final String ORDENAR = "ordenar";
	public static final String BUSCAR = "buscar";
	public static final String REGRESAR = "regresar";
	private VentanaPrincipal ventanita;

	public PanelListaJugadores(VentanaPrincipal ven) {

		setLayout(new BorderLayout());
		setTitle("Lista de Jugadores");
		this.ventanita = ven;

		txtAMostrar = new TextArea();

		ordenar = new JButton("Ordenar");
		ordenar.setActionCommand(ORDENAR);
		ordenar.addActionListener(this);

		buscar = new JButton("Buscar");
		buscar.setActionCommand(BUSCAR);
		buscar.addActionListener(this);

		regresar = new JButton("Regresar");

		JPanel panelAuxiliar = new JPanel();
		panelAuxiliar.setLayout(new GridLayout(1, 3));
		panelAuxiliar.add(ordenar);
		panelAuxiliar.add(buscar);
		panelAuxiliar.add(regresar);

		add(panelAuxiliar, BorderLayout.NORTH);
		add(txtAMostrar, BorderLayout.CENTER);

		setSize(700, 515);

	}

	public TextArea getTxtAMostrar() {
		return txtAMostrar;
	}

	public void setTxtAMostrar(TextArea txtAMostrar) {
		this.txtAMostrar = txtAMostrar;
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getActionCommand().equals(ORDENAR)) {

			String[] opciones = { "Nombre", "Edad" };
			int respuesta = JOptionPane.showOptionDialog(null, "Por qué desea ordenar", "Ordenar",
					JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, opciones, opciones[0]);
			agregarTexto(opciones[respuesta]);
		}
		else if(e.getActionCommand().equals(BUSCAR)) {
			String res= JOptionPane.showInputDialog("Escribir nombre del jugador");
			mostarBuscado(res);
			
		}

	}
	public void agregarTexto(String opcion) {
		txtAMostrar.append("");
		if(opcion.equals("Nombre")) {
			ArrayList <Jugador> lista =ventanita.cargarListaNombre();
//			System.out.println(lista.get(0).getNombre());
			for (int i = 0; i < lista.size(); i++) {
				txtAMostrar.append("Nombre: " +lista.get(i).getNombre()+ "\n");
				
				
			}
		}else if(opcion.equals("Edad")) {
			txtAMostrar.append("");
			ArrayList <Jugador> lista =ventanita.cargarListaEdad();
//			System.out.println(lista.get(0).getNombre());
			for (int i = 0; i < lista.size(); i++) {
				txtAMostrar.append("Edad: " +lista.get(i).getEdad()+ "\n");
				
				
			}
			
		}
		
		
	}
	public void mostarBuscado(String r) {
		txtAMostrar.append(ventanita.bucarJugador(r).getNombre()+" "+ventanita.bucarJugador(r).getEdad());
	}
	

}
