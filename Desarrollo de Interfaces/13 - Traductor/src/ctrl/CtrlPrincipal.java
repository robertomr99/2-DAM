package ctrl;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import model.Languages;

public class CtrlPrincipal {
	public static String sPregunta;
	public static String sRespuesta;
	public static int iNumeroPregunta;

	public static void inicio() {
		Languages.cargarLenguajes();
		generarNumeroPregunta();
		elegirIdioma();
		
		new view.FrmPrincipal();

		
		view.FrmPrincipal.lblPalabraIngles.setText(sPregunta);
	}
	
	public static void elegirIdioma() {
		
		if (view.FrmConfig.rdbtnEspIng.isSelected()) {
			model.Languages.ESP_ING();
			sPregunta = model.Languages.aESPpalabras.get(iNumeroPregunta);
			sRespuesta =  model.Languages.aENGpalabras.get(iNumeroPregunta).toUpperCase();
		
		} else //(view.FrmConfig.rdbtnIngEsp.isSelected()) 
			{
			model.Languages.ING_ESP();
			sPregunta = model.Languages.aENGpalabras.get(iNumeroPregunta);
			sRespuesta =  model.Languages.aESPpalabras.get(iNumeroPregunta).toUpperCase();
			
			/*
		} else {
			model.Languages.Indiferente();
			if(iNumeroAleatorio == 1) {
				sPregunta = model.Languages.aESPpalabras.get(iNumeroPregunta);
				
			} */
			
		}
	}

	public static void generarNumeroPregunta() {
		iNumeroPregunta = (int) (Math.random() * Languages.aENG.size());
	}

	public static void salir() {

		int iResp = JOptionPane.showConfirmDialog(view.FrmPrincipal.JFVentana, "¿Seguro que desea salir?", "SALIR",
				JOptionPane.YES_NO_OPTION);

		if (iResp == JOptionPane.YES_OPTION) {
			view.FrmPrincipal.JFVentana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			System.exit(0);
		} else {
			view.FrmPrincipal.JFVentana.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		}
	}

	public static void comprobarTraduccion() {

		String sRespuestaUsuario = view.FrmPrincipal.txtRespuesta.getText();
		String sTexto;
		Color cColor;
		int iOpcSeleccionada1, iOpcSeleccionada2;

		if (model.Languages.aESPpalabras.size() != 0 && model.Languages.aENGpalabras.size() != 0) {

			if (sRespuestaUsuario.toUpperCase().equals(sRespuesta.toUpperCase())) {
				model.Languages.aENGpalabras.remove(iNumeroPregunta);
				model.Languages.aESPpalabras.remove(iNumeroPregunta);

				cColor = new Color(102, 204, 0);
				sTexto = "CORRECTO!";
			} else {
				cColor = new Color(255, 0, 0);
				sTexto = sRespuesta;
			}
			view.FrmPrincipal.lblMensaje.setText(sTexto);
			view.FrmPrincipal.lblMensaje.setForeground(cColor);

			if (model.Languages.aESPpalabras.size() != 0 && model.Languages.aENGpalabras.size() != 0) {

				iOpcSeleccionada1 = JOptionPane.showConfirmDialog(null, "¿Quiere otra palabra?", "Salir",
						JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);

				if (iOpcSeleccionada1 == JOptionPane.YES_OPTION) {
					generarNumeroPregunta();
					
					if(view.FrmConfig.rdbtnEspIng.isSelected()) {
						sPregunta = model.Languages.aESPpalabras.get(iNumeroPregunta);
					}else {
						sPregunta = model.Languages.aENGpalabras.get(iNumeroPregunta);
					}
					
					sPregunta = model.Languages.aENGpalabras.get(iNumeroPregunta);
					view.FrmPrincipal.lblPalabraIngles.setText(sPregunta);
					view.FrmPrincipal.lblMensaje.setText(null);
					view.FrmPrincipal.txtRespuesta.setText(null);
				} else {
					salir();
				}

			}

			if (model.Languages.aESPpalabras.size() == 0 && model.Languages.aENGpalabras.size() == 0) {

				iOpcSeleccionada2 = JOptionPane.showConfirmDialog(null, "¿Quiere empezar de nuevo?", "Salir",
						JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);

				if (iOpcSeleccionada2 == JOptionPane.YES_OPTION) {
					Languages.cargarLenguajes();
					generarNumeroPregunta();
					if(view.FrmConfig.rdbtnEspIng.isSelected()) {
						sPregunta = model.Languages.aESPpalabras.get(iNumeroPregunta);
					}else {
						sPregunta = model.Languages.aENGpalabras.get(iNumeroPregunta);
					}
					view.FrmPrincipal.lblPalabraIngles.setText(sPregunta);
					view.FrmPrincipal.lblMensaje.setText(null);
					view.FrmPrincipal.txtRespuesta.setText(null);
				} else {
					salir();
				}

			}
		}
	}
}
