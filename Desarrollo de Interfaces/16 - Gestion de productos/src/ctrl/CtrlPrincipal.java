package ctrl;

import java.util.ArrayList;

import javax.swing.DefaultListModel;

public class CtrlPrincipal {

	public static void inicio() {

		new view.FrmPrincipal();
		model.Categorias.cargarCategorias();
	}

	public static DefaultListModel<String> addModelo(ArrayList<String> aCategorias) {
		String sNombres = "";
		DefaultListModel<String> modeloFuente = new DefaultListModel<String>();
		for (int iContador = 0; iContador < aCategorias.size(); iContador++) {
			sNombres = aCategorias.get(iContador);
			modeloFuente.addElement(sNombres);
		}

		return modeloFuente;
	}
}
