package unico;

import java.awt.*;
import java.awt.event.*;

public class Doble extends java.awt.Frame {

	public static void main(String[] args) {
		
		final Color CLR_RESULTADO_OK = Color.green;
		final Color CLR_RESULTADO_ERROR = Color.red;

		Doble CalcularNumero = new Doble();
		CalcularNumero.ConstruirVentana();

	}

	private void ConstruirVentana() {

		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent we) {
				System.exit(0);
			}
		});

		setTitle("Doble");
		setBackground(Color.gray);
		setBounds(100, 100, 300, 250);
		setLayout(null);
		CrearComponentes();
		setVisible(true);
	}

	private void CrearComponentes() {

		Label lbl_Numero = new Label();
		lbl_Numero.setText("Numero: ");
		lbl_Numero.setBackground(Color.gray);
		lbl_Numero.setBounds(90, 40, 60, 40);
	

		TextField txt_Numero = new TextField();
		txt_Numero.setBackground(Color.white);
		txt_Numero.setBounds(150, 50, 80, 20);
	

		Button btn_Calcular = new Button("Calcular Doble");
		btn_Calcular.setBounds(110, 170, 100, 40);
		btn_Calcular.setBackground(Color.gray);


		Label lbl_Indicaciones = new Label();
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
				String sTexto = txt_Numero.getText();
				
				String sResultado = "";
				Color clrResultado = CLR_RESULTADO_OK;
				
				if(sTexto.length() == 0) {
					clrResultado = CLR_RESULTADO_ERROR;
					sResultado = "Debes introducir un numero.";
				} else {
					try {
						int iResultado = Integer.parseInt(sTexto)*2;
						clrResultado = CLR_RESULTADO_OK;
						sResultado = " "+ iResultado;
						
					} catch(Exception ee) {
						clrResultado = CLR_RESULTADO_ERROR;
						sResultado = "No see ha podido convertir.";
					}
				}
				
				lbl_Indicaciones.setForeground(clrResultado);
				lbl_Indicaciones.setText(sResultado);

			}
		});
	}

}
