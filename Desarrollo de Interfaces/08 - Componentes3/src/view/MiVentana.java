package view;

import java.awt.*;
import java.awt.event.*;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

public class MiVentana extends java.awt.Frame {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		MiVentana MiApp = new MiVentana();
		MiApp.crearVentana();

	}

	private void crearVentana() {

		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent we) {
				int opcSeleccionada = JOptionPane.showConfirmDialog(null, "¿Desea salir?", "Control App",
						JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
				if (opcSeleccionada == 0) {
					ctrl.CtrtMiVentana.salir();
				}
			}
		});

		setIconImage(Toolkit.getDefaultToolkit().createImage("a.png"));
		setTitle("Barras de Menú");
		setBounds(100, 100, 600, 400);

		setLayout(null);
		setBackground(Color.gray);
		crearComponentes();
		setVisible(true);
	}

	private void crearComponentes() {

		// TEXTAREA

		/*
		 * TextArea txtComentarios = new TextArea(); txtComentarios.setBounds(20, 50,
		 * 100, 60);
		 */

		// CHECKBOX

		/*
		 * Checkbox opcReembolso = new Checkbox(); opcReembolso.setLabel("Reembolso");
		 * opcReembolso.setState(true); opcReembolso.setBounds(140,50,100,20);
		 */

		Label lblFormaPago = new Label("Forma de pago: ");
		lblFormaPago.setBounds(20, 40, 90, 20);

		CheckboxGroup grpFormaPago = new CheckboxGroup(); // Los metemos dentro de un grupo dando solo opcion a
															// saeleccionar una de ellas.

		Checkbox opcEfectivo = new Checkbox("Efectivo", true, grpFormaPago);
		opcEfectivo.setBounds(20, 60, 100, 20);

		Checkbox opcTarjeta = new Checkbox("Tarjeta", false, grpFormaPago);
		opcTarjeta.setBounds(20, 80, 100, 20);

		Checkbox opcBizzum = new Checkbox("Bizzum", false, grpFormaPago);
		opcBizzum.setBounds(20, 100, 100, 20);

		add(lblFormaPago);
		add(opcEfectivo);
		add(opcTarjeta);
		add(opcBizzum);

		// Lista

		List lstCiudades = new List();
		lstCiudades.add("Sevilla");
		lstCiudades.add("Córdoba");
		lstCiudades.add("Huelva");
		lstCiudades.add("Málaga");
		lstCiudades.add("Cádiz");
		lstCiudades.add("Granada");
		lstCiudades.add("Jaén");
		lstCiudades.add("Almería");

		lstCiudades.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				System.out.println(lstCiudades.getSelectedItem());
			}
		});

		lstCiudades.setBounds(160, 100, 80, 100);

		// Lista despegable

		Choice lstCiclos = new Choice();
		lstCiclos.add("DAM");
		lstCiclos.add("DAW");
		lstCiclos.add("ASIR");
		lstCiclos.add("Game3D");

		lstCiclos.setBounds(250, 100, 80, 100);

		// Mismo metodo peron con la funcion lambda

		lstCiclos.addItemListener(e -> {
			System.out.println(lstCiclos.getSelectedItem());
		});

		// JComboBox -> El choice de la libreria Swing

		String[] misColores = { "Rojo", "Verde", "Azul" };
		JComboBox lstColores = new JComboBox(misColores);
		lstColores.setEditable(true); // -> Permite escribir en el recuadro;
		lstColores.setBounds(350, 100, 80, 20);

		lstColores.addActionListener(e -> {
			System.out.println(lstColores.getSelectedItem());
			System.out.println(lstColores.getSelectedIndex());

		});

		JButton btnMensaje = new JButton("MENSAJE");
		btnMensaje.setBounds(20, 150, 130, 20);

		btnMensaje.addActionListener(e -> {
			System.out.println("Has pulsado");
			// JOptionPane.showMessageDialog(null, "No se ha podido añadir el producto",
			// "GESTIÓN DE PRODUCTOS", JOptionPane.ERROR_MESSAGE);
			// JOptionPane.showMessageDialog(null, "El precio del producto es muy bajo",
			// "GESTIÓN DE PRODUCTOS", JOptionPane.WARNING_MESSAGE);
			// JOptionPane.showMessageDialog(null, "El producto no está disponible aún",
			// "GESTIÓN DE PRODUCTOS", JOptionPane.QUESTION_MESSAGE);
			JOptionPane.showMessageDialog(null, "No aparece ningún icono", "GESTIÓN DE PRODUCTOS",
					JOptionPane.PLAIN_MESSAGE);
		});

		JButton btnEntrada = new JButton("ENTRADA");
		btnEntrada.setBounds(20, 180, 130, 20);

		btnEntrada.addActionListener(e -> {
			System.out.println("Has pulsado");
			// Para recoger un valor en una variable
			String valorIntroducido = JOptionPane.showInputDialog(null, "Introduzca el nuevo precio", "100");
			System.out.println("Ha introducido: " + valorIntroducido);
		});

		JButton btnConfirmacion = new JButton("CONFIRMACIÓN");
		btnConfirmacion.setBounds(20, 210, 130, 20);

		btnConfirmacion.addActionListener(e -> {
			System.out.println("Has pulsado");
			// Para recoger un valor en una variable
			int opcSeleccionada = JOptionPane.showConfirmDialog(null, "Desea formatear el disco", "Gestión de discos",
					JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE);
			System.out.println("Has seleccionado la opción: " + opcSeleccionada);
		});
		
		
		JButton btnVentana= new JButton("VENTANA");
		btnVentana.setBounds(20, 240, 130, 20);
		btnVentana.addActionListener(e -> {
			
			// Creamos nuestro propio dialogo
			
			Dialog frmProducto = new Dialog(this, "Gestión de Productos", true); // -> Si esta true no nos permite pinchar en la ventana padre
																			// -> Si es false si te deja acceder para seguir interactuan
			frmProducto.setBounds(100,100,400,200);
			frmProducto.addWindowListener(new WindowAdapter(){
				public void windowClosing(WindowEvent we) {
					frmProducto.dispose();
					//ctrl.CtrtMiVentana.salir();
				}
		});
			frmProducto.setVisible(true);
			
		});

		
		add(btnVentana);
		add(lstColores);
		add(lstCiclos);
		add(lstCiudades);
		add(btnConfirmacion);
		add(btnEntrada);
		add(btnMensaje);

		// add(txtComentarios);
		// add(opcReembolso);

	}

}