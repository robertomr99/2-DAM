package view;

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
				ctrl.CtrtMiVentana.salir();
			}
		});

		setIconImage(Toolkit.getDefaultToolkit().createImage("a.png"));
		setTitle("Barras de Menú");
		setBounds(100, 100, 600, 400);

		setLayout(new BorderLayout());
		setBackground(Color.gray);
		crearComponentes();
		setVisible(true);
	}

	private void crearComponentes() {

		// Creacion barra de Menu
		MenuBar bar = new MenuBar();

		Menu mnuEditar = new Menu("Editar");

		MenuItem mniColores = new MenuItem("Colores");
		MenuItem mniSalir = new MenuItem("Salir");
		
		mnuEditar.add(mniColores);
		mnuEditar.add(mniSalir);

		bar.add(mnuEditar);
		setMenuBar(bar);

		// ASIGNAMOS EVENTOS

		mniColores.addActionListener(e -> new FrmColores());
		mniSalir.addActionListener(e -> new FrmSalir());

	}

};