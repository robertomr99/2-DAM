package model;

import java.util.ArrayList;

import javax.swing.DefaultListModel;

public class Categorias {

	public static ArrayList<String> aCategorias = new ArrayList<String>();

	public static void cargarCategorias() {

		aCategorias.add("Coches");
		aCategorias.add("Moviles");
		aCategorias.add("Ordenadores");

		view.FrmPrincipal.listCategorias.setModel(cargarModelo(aCategorias));
	}

	public static DefaultListModel<String> cargarModelo(ArrayList<String> aCategorias) {
		String sNombres = "";
		DefaultListModel<String> modeloFuente = new DefaultListModel<String>();
		for (int iContador = 0; iContador < aCategorias.size(); iContador++) {
			sNombres = aCategorias.get(iContador);
			modeloFuente.addElement(sNombres);
		}
		return modeloFuente;
	}
}
