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
		
		TextArea txtComentarios = new TextArea();
		
		add(txtComentarios, BorderLayout.CENTER);

		// Creacion barra de Menu
		MenuBar bar = new MenuBar();

		// Creacion de distintos menus y menu items

		// ARCHIVO

		Menu mnuArchivo = new Menu("Archivo");

		MenuItem mniAbrir = new MenuItem("Abrir");
		MenuItem mniGuardar = new MenuItem("Guardar");
		MenuItem mniGuardarComo = new MenuItem("Guardar como");
		Menu mnuExportar = new Menu("Exportar");
			MenuItem mniWord = new MenuItem("Word");
			MenuItem mniPDF = new MenuItem("PDF");
			MenuItem mniTexto = new MenuItem("Texto");
		MenuItem mniSalir = new MenuItem("Salir");

		// EDITAR

		Menu mnuEditar = new Menu("Editar");

		MenuItem mniCopiar = new MenuItem("Copiar");
		MenuItem mniCortar = new MenuItem("Cortar");
		MenuItem mniPegar = new MenuItem("Pegar");
		MenuItem mniSeleccionarTodo = new MenuItem("Seleccionar todo");

		// CONVERTIR

		Menu mnuConvertir = new Menu("Convertir");

		Menu mnuImagen = new Menu("Imagen");
		MenuItem mniJPG = new MenuItem("JPG");
		MenuItem mniPNG = new MenuItem("PNG");
		MenuItem mniBMP = new MenuItem("BMP");
		Menu mnuBD = new Menu("BD");
		MenuItem mniOracle = new MenuItem("Oracle");
		MenuItem mniMySQL = new MenuItem("MySQL");
		MenuItem mniAcess = new MenuItem("Acess");

		// AYUDA

		Menu mnuAyuda = new Menu("Ayuda");

		MenuItem mniManual = new MenuItem("Manual");
		MenuItem mniAcercaDe = new MenuItem("Acerca de");

		mnuArchivo.add(mniAbrir);
		mnuArchivo.add(mniGuardar);
		mnuArchivo.add(mniGuardarComo);
		mnuArchivo.add(mnuExportar);
		mnuArchivo.addSeparator();
		mnuArchivo.add(mniSalir);

		mnuExportar.add(mniWord);
		mnuExportar.add(mniPDF);
		mnuExportar.add(mniTexto);

		mnuEditar.add(mniCopiar);
		mnuEditar.add(mniCortar);
		mnuEditar.add(mniPegar);
		mnuEditar.addSeparator();
		mnuEditar.add(mniSeleccionarTodo);

		mnuConvertir.add(mnuImagen);
		mnuImagen.add(mniJPG);
		mnuImagen.add(mniPNG);
		mnuImagen.add(mniBMP);
		mnuConvertir.add(mnuBD);
		mnuBD.add(mniOracle);
		mnuBD.add(mniMySQL);
		mnuBD.add(mniAcess);

		mnuAyuda.add(mniManual);
		mnuAyuda.add(mniAcercaDe);

		bar.add(mnuArchivo);
		bar.add(mnuEditar);
		bar.add(mnuConvertir);
		bar.add(mnuAyuda);

		setMenuBar(bar);

		// ASIGNAMOS EVENTOS

		mniAbrir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ctrl.CtrtMiVentana.abrir();
			}
		});
		
		mniGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ctrl.CtrtMiVentana.guardar();
			}
		});
		
		mniGuardarComo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ctrl.CtrtMiVentana.guardarComo();
			}
		});
		
		mniSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ctrl.CtrtMiVentana.salir();

			}
		});
		

	}

};