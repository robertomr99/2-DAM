package view;

import java.awt.*;
import java.awt.event.*;

public class FrmCalculos extends java.awt.Frame {
	
	public static TextField txt_Numero;
	public static Label lbl_Indicaciones;
	public static Label lbl_Numero;
	

	public FrmCalculos() {

		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent we) {
				controller.CtrlCalculos.FinalizarApp();
			}
		});

		setTitle("Cálculos");
		setBackground(Theme.CLR_VENTANA);
		setBounds(100, 100, 300, 250);
		setLayout(null);

		crearComponentes();
		setVisible(true);
	}

	private void crearComponentes() {

		lbl_Numero = new Label();
		lbl_Numero.setText("Numero: ");
		lbl_Numero.setBackground(view.Theme.CLR_VENTANA);
		lbl_Numero.setBounds(90, 40, 60, 40);

		txt_Numero = new TextField();
		txt_Numero.setBackground(Color.white);
		txt_Numero.setBounds(150, 50, 80, 20);

		Button btn_CalcularDoble = new Button("Doble");
		btn_CalcularDoble.setBounds(40, 170, 70, 30);
		btn_CalcularDoble.setBackground(view.Theme.CLR_BUTTON);
		
		Button btn_CalcularTriple = new Button("Triple");
		btn_CalcularTriple.setBounds(120, 170, 70, 30);
		btn_CalcularTriple.setBackground(view.Theme.CLR_BUTTON);
		
		Button btn_CalcularMitad= new Button("Mitad");
		btn_CalcularMitad.setBounds(200, 170, 70, 30);
		btn_CalcularMitad.setBackground(view.Theme.CLR_BUTTON);

		lbl_Indicaciones = new Label();
		lbl_Indicaciones.setText("Escriba un numero y luego pulse un boton");
		lbl_Indicaciones.setBounds(10, 200, 300, 40);
		lbl_Indicaciones.setAlignment(Label.CENTER);

		// ADD

		add(lbl_Numero);
		add(txt_Numero);
		add(btn_CalcularDoble);
		add(btn_CalcularTriple);
		add(btn_CalcularMitad);
		add(lbl_Indicaciones);

		// ASIGNAMOS EVENTOS
		
		btn_CalcularDoble.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.CtrlCalculos.calcularDoble();
			}
		});
		
		btn_CalcularTriple.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.CtrlCalculos.calcularTriple();
			}
		});
		
		btn_CalcularMitad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.CtrlCalculos.calcularMitad();
			}
		});
	}

}
