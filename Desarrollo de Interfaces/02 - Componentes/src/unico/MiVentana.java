package unico;

import java.awt.*;
import java.awt.event.*;

public class MiVentana extends java.awt.Frame {

	// COLORES

	final Color CLR_BG_VENTANA = new Color(0, 155, 0);
	final Color CLR_FG_USUARIO = Color.yellow;
	final Color CLR_FG_PASSWORD = Color.white;

	// FUENTES

	// Font BOLD > NEGRITA / PLAIN > NORMAL

	final Font FNT_BTN_TITULO = new Font("TimesRoman", Font.BOLD, 14);
	final Font FNT_LBL_TITULO = new Font("Arial", Font.PLAIN, 14);
	final Font FNT_LBL_NORMAL = new Font("Arial", Font.PLAIN, 12);
	final Font FNT_LBL_RESALTADO = new Font("Arial", Font.BOLD, 16);

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
		setLayout(null);
		setBackground(CLR_BG_VENTANA);
		crearComponentes();
		setVisible(true);
	}

	private void crearComponentes() {

		/*
		 * Button btnAceptar = new Button(); btnAceptar.setLabel("Aceptar");
		 */

		Button btnAceptar = new Button("Aceptar"); // Podemos darle valor cuando lo
		// creamos o setearlo con setLabel("")
		btnAceptar.setBounds(10, 40, 80, 40);
		btnAceptar.setFont(FNT_BTN_TITULO);

		Button btnCancelar = new Button("Cancelar");
		btnCancelar.setBounds(95, 40, 80, 40);
		btnCancelar.setFont(FNT_BTN_TITULO);

		/*
		 * Label lblUsuario = new Label(); lblUsuario.setText("Usuario");
		 */

		Label lblUsuario = new Label("Usuario:");
		Label lblPassword = new Label("Password:");

		lblUsuario.setBounds(10, 90, 80, 40);
		lblUsuario.setBackground(Color.red);
		lblUsuario.setForeground(CLR_FG_USUARIO);
		lblUsuario.setFont(FNT_LBL_RESALTADO);

		lblPassword.setBounds(10, 135, 80, 40);
		lblPassword.setBackground(Color.blue);
		lblPassword.setForeground(CLR_FG_PASSWORD);
		lblPassword.setFont(FNT_LBL_RESALTADO);
		
		
		// Cuadro de texto 
		
		TextField txtUserName = new TextField();
		// TextField txtUserName = new TextField(8); // Distintas formas constructor
		// TextField txtUserName = new TextField("Medac", 8);
		txtUserName.setBounds(10,185, 80, 40);
		txtUserName.setText("Prueba");
		txtUserName.setVisible(true);
		
		// Agregar componentes al Frame

		add(btnAceptar);
		add(btnCancelar);

		add(lblUsuario);
		add(lblPassword);
		
		add(txtUserName);

	}

	/*
	 * private void crearComponentes2() {
	 * 
	 * Button btnAceptar = new Button(); btnAceptar.setLabel("Aceptar");
	 * 
	 * 
	 * Button btnSevilla = new Button("Sevilla"); // Podemos darle valor cuando lo
	 * creamos o setearlo con setLabel("") btnSevilla.setBounds(20, 40, 80, 40);
	 * 
	 * Button btnNo = new Button("No"); btnNo.setBounds(105, 40, 40, 40);
	 * 
	 * Button btnSi = new Button("Si"); btnSi.setBounds(10, 85, 25, 45);
	 * 
	 * Button btnAndalucia = new Button("Andalucia"); btnAndalucia.setBounds(35, 85,
	 * 125, 45); // x y ancho altura
	 * 
	 * // Agregar componentes al Frame
	 * 
	 * add(btnNo); add(btnSevilla); add(btnSi); add(btnAndalucia); }
	 */
};
