package ctrl;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import model.Languages;

public class CtrlPrincipal {
	public static String sPregunta;
	public static int iNumeroPregunta;

	public static void inicio() {
		Languages.cargarLenguajes();
		generarNumeroPregunta();
		new view.FrmPrincipal();

		sPregunta = model.Languages.aENG.get(iNumeroPregunta);
		view.FrmPrincipal.lblPalabraIngles.setText(sPregunta);
	}

	public static void generarNumeroPregunta() {
		iNumeroPregunta = (int) (Math.random() * Languages.aENG.size());
	}
	
	public static void salir() {
		
		int iResp = JOptionPane.showConfirmDialog(view.FrmPrincipal.JFVentana, "¿Quiere salir de la app?","SALIR", JOptionPane.YES_NO_OPTION);
		
		if(iResp == JOptionPane.YES_OPTION) {
			view.FrmPrincipal.JFVentana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			System.exit(0);
		}else {
			view.FrmPrincipal.JFVentana.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		}
	}
	

	public static void comprobarTraduccion() {

		String sRespuesta = view.FrmPrincipal.txtRespuesta.getText();

		String sTexto;
		Color cColor;

		if (model.Languages.aESP.size() == 0 && model.Languages.aENG.size() == 0) {
			int opcSeleccionada = JOptionPane.showConfirmDialog(null, "¿Quiere jugar de nuevo?", "Salir",
					JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
			
			if(opcSeleccionada == JOptionPane.YES_OPTION) {
				
			}
		} else {

			if (sRespuesta.toUpperCase().equals(model.Languages.aESP.get(iNumeroPregunta).toUpperCase())) {
				model.Languages.aENG.remove(iNumeroPregunta);
				model.Languages.aESP.remove(iNumeroPregunta);

				cColor = new Color(102, 204, 0);
				sTexto = "CORRECTO!";
			} else {
				cColor = new Color(255, 0, 0);
				sTexto = model.Languages.aESP.get(iNumeroPregunta).toUpperCase();
			}
			view.FrmPrincipal.lblMensaje.setText(sTexto);
			view.FrmPrincipal.lblMensaje.setForeground(cColor);
			
			int opcSeleccionada = JOptionPane.showConfirmDialog(null, "¿Quiere otra palabra?", "Salir",
					JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
			if(opcSeleccionada == JOptionPane.YES_OPTION) {
				generarNumeroPregunta();
				sPregunta = model.Languages.aENG.get(iNumeroPregunta);
				view.FrmPrincipal.lblPalabraIngles.setText(sPregunta);
				view.FrmPrincipal.lblMensaje.setText(null);
				view.FrmPrincipal.txtRespuesta.setText(null);
			}else {
				salir();
			}

		}

	}

}
