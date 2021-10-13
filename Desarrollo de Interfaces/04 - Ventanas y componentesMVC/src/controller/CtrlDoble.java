package controller;

import java.awt.Color;

public class CtrlDoble {
	
	public static void FinalizarApp() {
		System.exit(0);
	}
	
	public static void calcularDoble() {
		
		String sTexto = view.Doble.txt_Numero.getText();

		String sResultado = "";
		Color clrResultado = view.Theme.CLR_RESULTADO_OK;

		if (sTexto.length() == 0) {
			clrResultado = view.Theme.CLR_RESULTADO_ERROR;
			sResultado = "Debes introducir un numero.";
		} else {
			try {
				int iResultado = Integer.parseInt(sTexto) * 2;
				clrResultado = view.Theme.CLR_RESULTADO_OK;
				sResultado = " " + iResultado;

			} catch (Exception ee) {
				clrResultado = view.Theme.CLR_RESULTADO_ERROR;
				sResultado = "No see ha podido convertir.";
			}
		}

		view.Doble.lbl_Indicaciones.setForeground(clrResultado);
		view.Doble.lbl_Indicaciones.setText(sResultado);

		
	}

}
