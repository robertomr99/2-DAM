package view;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MiVentana extends java.awt.Frame {
	
	// COLORES
	
	final Color CLR_VENTANA = new Color (84,84,79);
	final Color CLR_JPanel = new Color (169,169,154);

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		MiVentana MiApp = new MiVentana();
		MiApp.crearVentana();

	}

	private void crearVentana() {

		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent we) {
				ctrl.CtrtMiVentana.salir();
			}
		});

		setIconImage(Toolkit.getDefaultToolkit().createImage("a.png"));
		setTitle("Ficha alumno");
		setBounds(100, 100, 350, 400);

		setLayout(null);
		setBackground(CLR_VENTANA);
		crearComponentes();
		setVisible(true);
	}

	private void crearComponentes() {

		JPanel panCredenciales = new JPanel();
		panCredenciales.setLayout(null);
		panCredenciales.setBounds(30,50,200,80);
		panCredenciales.setBackground(CLR_JPanel);
		
		
			JLabel lblNombre = new JLabel("Nombre: ");
			lblNombre.setBounds(20,10,70,20);
			JLabel lblApellidos = new JLabel("Apellidos: ");
			lblApellidos.setBounds(20,50,70,20);
			JTextField txtNombre = new JTextField ("");
			txtNombre.setBounds(100,10,80,20);
			JTextField txtApellidos = new JTextField ("");
			txtApellidos.setBounds(100,50,80,20);
			
			panCredenciales.add(lblNombre);
			panCredenciales.add(txtNombre);
			panCredenciales.add(lblApellidos);
			panCredenciales.add(txtApellidos);
			
			add(panCredenciales);
		

		JPanel panCurso = new JPanel();
		panCurso.setLayout(null);
		panCurso.setBounds(30,160,120,135);
		panCurso.setBackground(CLR_JPanel);

			JLabel lblCurso = new JLabel("Curso: ");
			lblCurso.setBounds(10,10,50,10);
	
			CheckboxGroup grpCurso = new CheckboxGroup();
	
			Checkbox opcDAM = new Checkbox("DAM", true, grpCurso);
			opcDAM.setBounds(30, 35, 50, 20);
	
			Checkbox opcDAW = new Checkbox("DAW", false, grpCurso);
			opcDAW.setBounds(30, 60, 50, 20);
	
			Checkbox opcASIR = new Checkbox("ASIR", false, grpCurso);
			opcASIR.setBounds(30, 85, 50, 20);
	
			panCurso.add(lblCurso);
			panCurso.add(opcDAM);
			panCurso.add(opcDAW);
			panCurso.add(opcASIR);
	
			add(panCurso);
		
		

		JPanel panTurno = new JPanel();
		panTurno.setLayout(null);
		panTurno.setBounds(200,160,120,135);
		panTurno.setBackground(CLR_JPanel);
	
			JLabel lblTurno = new JLabel("Turno: ");
			lblTurno.setBounds(10,10,50,10);
	
			CheckboxGroup grpTurno = new CheckboxGroup(); 
	
			Checkbox opcManana = new Checkbox("Mañana", true, grpTurno);
			opcManana.setBounds(30, 50, 70, 20);
			
	
			Checkbox opcTarde = new Checkbox("Tarde", false, grpTurno);
			opcTarde.setBounds(30, 75, 50, 20);
	
			panTurno.add(lblTurno);
			panTurno.add(opcManana);
			panTurno.add(opcTarde);
	
			add(panTurno);
			

	 Checkbox opcRE = new Checkbox("Es responsable económico", true);
	 opcRE.setBounds(30, 360, 200,10);
	 		
	 add(opcRE);


	}

}