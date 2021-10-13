package controller;

import java.awt.Color;

public class CtrlCalculos {

	public static void FinalizarApp() {
		System.exit(0);
	}

	public static void calcularDoble() {

		String sTexto = view.FrmCalculos.txt_Numero.getText();

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
				sResultado = "No se ha podido convertir.";
			}
		}

		view.FrmCalculos.lbl_Indicaciones.setForeground(clrResultado);
		view.FrmCalculos.lbl_Indicaciones.setText(sResultado);

	}

	public static void calcularTriple() {

		String sTexto = view.FrmCalculos.txt_Numero.getText();

		String sResultado = "";
		Color clrResultado = view.Theme.CLR_RESULTADO_OK;

		if (sTexto.length() == 0) {
			clrResultado = view.Theme.CLR_RESULTADO_ERROR;
			sResultado = "Debes introducir un numero.";
		} else {
			try {
				int iResultado = Integer.parseInt(sTexto) * 3;
				clrResultado = view.Theme.CLR_RESULTADO_OK;
				sResultado = " " + iResultado;

			} catch (Exception ee) {
				clrResultado = view.Theme.CLR_RESULTADO_ERROR;
				sResultado = "No see ha podido convertir.";
			}
		}

		view.FrmCalculos.lbl_Indicaciones.setForeground(clrResultado);
		view.FrmCalculos.lbl_Indicaciones.setText(sResultado);

	}

	public static void calcularMitad() {

		String sTexto = view.FrmCalculos.txt_Numero.getText();

		String sResultado = "";
		Color clrResultado = view.Theme.CLR_RESULTADO_OK;

		if (sTexto.length() == 0) {
			clrResultado = view.Theme.CLR_RESULTADO_ERROR;
			sResultado = "Debes introducir un numero.";
		} else {
			try {
				double iResultado = Double.parseDouble(sTexto) / 2;
				clrResultado = view.Theme.CLR_RESULTADO_OK;
				sResultado = " " + iResultado;

			} catch (Exception ee) {
				clrResultado = view.Theme.CLR_RESULTADO_ERROR;
				sResultado = "No see ha podido convertir.";
			}
		}

		view.FrmCalculos.lbl_Indicaciones.setForeground(clrResultado);
		view.FrmCalculos.lbl_Indicaciones.setText(sResultado);

	}

}
