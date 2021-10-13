package view;

import java.awt.*;
import java.awt.event.*;

public class Doble extends java.awt.Frame {
	
	public static TextField txt_Numero;
	public static Label lbl_Indicaciones;
	public static Label lbl_Numero;
	public static Button btn_Calcular;

	public Doble() {

		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent we) {
				controller.CtrlDoble.FinalizarApp();
			}
		});

		setTitle("Doble");
		setBackground(Theme.CLR_VENTANA);
		setBounds(100, 100, 300, 250);
		setLayout(null);

		crearComponentes();
		setVisible(true);
	}

	private void crearComponentes() {

		lbl_Numero = new Label();
		lbl_Numero.setText("Numero: ");
		lbl_Numero.setBackground(Color.gray);
		lbl_Numero.setBounds(90, 40, 60, 40);

		txt_Numero = new TextField();
		txt_Numero.setBackground(Color.white);
		txt_Numero.setBounds(150, 50, 80, 20);

		btn_Calcular = new Button("Calcular Doble");
		btn_Calcular.setBounds(110, 170, 100, 40);
		btn_Calcular.setBackground(Color.gray);

		lbl_Indicaciones = new Label();
		lbl_Indicaciones.setText("Escriba un numero y luego pulse un boton");
		lbl_Indicaciones.setBounds(10, 200, 300, 40);
		lbl_Indicaciones.setAlignment(Label.CENTER);

		// ADD

		add(lbl_Numero);
		add(txt_Numero);
		add(btn_Calcular);
		add(lbl_Indicaciones);

		// ASIGNAMOS EVENTOS

		btn_Calcular.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.CtrlDoble.calcularDoble();
			}
		});
	}

}
