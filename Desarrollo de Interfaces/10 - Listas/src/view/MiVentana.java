package view;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class MiVentana extends java.awt.Frame {

	private static String[] colorNombre = { "ROJO", "AMARILLO", "AZUL", "BLANCO", "NEGRO" };

	private static Color[] colorValor = { Color.RED, Color.GREEN, Color.BLUE, Color.WHITE, Color.BLACK };

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		MiVentana MiApp = new MiVentana();
		MiApp.crearVentana();
	}

	private void crearVentana() {

		String sColorFondo = "", sColorLetra = "";

		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent we) {
				ctrl.CtrtMiVentana.salir();
			}
		});

		setIconImage(Toolkit.getDefaultToolkit().createImage("a.png"));
		setTitle("Combinando colores");
		setBounds(100, 100, 600, 400);

		setLayout(null);
		setBackground(Color.gray);
		crearComponentes();
		setVisible(true);
	}

	private void crearComponentes() {
		
		
		Label lblMensaje = new Label ("SELECCIONE UNA COMBINACIÓN DE COLORES");
		lblMensaje.setBounds(140,300,200,20);

		List lstColorFondo = new List();

		for (int i = 0; i < colorNombre.length; i++) {
			lstColorFondo.add(colorNombre[i]);
		}

		lstColorFondo.addItemListener(e -> {
			//System.out.println(lstColorFondo.getSelectedItem());
			//System.out.println(lstColorFondo.getSelectedIndex());
			setBackground(colorValor[lstColorFondo.getSelectedIndex()]);
		});

		lstColorFondo.setBounds(140, 100, 80, 100);

		List lstColorFuente = new List();

		for (int i = 0; i < colorNombre.length; i++) {
			lstColorFuente.add(colorNombre[i]);
		}

		lstColorFuente.addItemListener(e -> {
			
			if(lstColorFondo.getSelectedIndex() != -1) {
				lblMensaje.setBackground(colorValor[lstColorFondo.getSelectedIndex()]);				
				lblMensaje.setBackground(colorValor[lstColorFuente.getSelectedIndex()]);
			}
			
		});

		lstColorFuente.setBounds(240, 100, 80, 100);

		add(lblMensaje);
		add(lstColorFondo);
		add(lstColorFuente);

	}

}