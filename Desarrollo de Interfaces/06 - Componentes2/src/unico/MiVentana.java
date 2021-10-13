package unico;

import java.awt.*;
import java.awt.event.*;

public class MiVentana extends java.awt.Frame {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		MiVentana MiApp = new MiVentana();
		MiApp.crearVentana();

	}

	private void crearVentana() {

		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent we) {
				System.exit(0);
			}
		});

		setTitle("Prueba");
		setBounds(100, 100, 600, 400);
		// setLayout(new FlowLayout()); // -> FlowLayout , los botones van seguidos
		// según se añadan.
		// setLayout(new BorderLayout()); // -> BorderLayout , solo puede tener 5
		// componentes NORTH/SOUTH/EAST/WEST/CENTER .
		// -> BorderLayout , si quitamos un boton , la zona central tambien tendra esa
		// zona

		setLayout(new GridLayout(2, 1)); // -> GridLayaout (Filas, Columnas) , los botones van seguidos según se añadan.
		setResizable(false);
		setBackground(Color.red);
		crearComponentes();
		setVisible(true);
	}

	private void crearComponentes() {

		Label lblUsuario = new Label();
		lblUsuario.setText("Usuario");
		Label lblPassword = new Label();
		lblUsuario.setText("Password");

		TextField txtUsuario = new TextField();
		TextField txtPassword = new TextField();

		Button btnAceptar = new Button("Aceptar");

		// Creacion de Panel

		Panel panOperaciones = new Panel();
		panOperaciones.setLayout(new GridLayout(2, 2));

		panOperaciones.add(lblUsuario);
		panOperaciones.add(txtUsuario);
		panOperaciones.add(lblPassword);
		panOperaciones.add(txtPassword);

		// Agregamos el panel al Frame
		add(panOperaciones);

		// Creacion de Panel

		Panel panOperaciones2 = new Panel();
		panOperaciones2.setLayout(new FlowLayout());

		panOperaciones2.add(btnAceptar);

		// Agregamos el panel al Frame

		add(panOperaciones2);

		// Agregar componentes

		/*
		 * Flow Layout
		 * 
		 * add(btn3); // Dependiendo del orden en el que se añaden tendran un order u
		 * otro add(btn4); add(btn1); add(btn2); add(btn5); add(btn6);
		 */

		// BorderLayout

		// add(btn1, BorderLayout.NORTH);
		// add(btn2, BorderLayout.SOUTH);
		// add(btn7, BorderLayout.CENTER);

		/*
		 * GridLayout
		 * 
		 * add(btn1); // Tambien depende del orden en el que se añaden tendran un order
		 * u otro add(btn5); add(btn6); add(btn2); add(btn3); add(btn4);
		 */

		// add(lbl1);

	}

};
