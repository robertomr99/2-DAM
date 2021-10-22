package model;

import java.util.ArrayList;

import javax.swing.DefaultListModel;

public class Fuentes {

	public static ArrayList<String> aFont = new ArrayList<String>();
	public static ArrayList<String> aSize = new ArrayList<String>();

	public static void cargarLenguajes() {

		aFont.add("Arial");
		aFont.add("Helvetica");
		aFont.add("Tahoma");
		aFont.add("Colibri");
		aFont.add("Trebuchet MS");
		aFont.add("Verdana");
		aFont.add("Times New Roman");
		aFont.add("Comic Sans MS");

		aSize.add("8");
		aSize.add("10");
		aSize.add("12");
		aSize.add("14");
		aSize.add("18");
		aSize.add("20");
		aSize.add("22");
		aSize.add("24");
	}

	public static DefaultListModel<String> volcarDatos(ArrayList<String> aDatos) {

		DefaultListModel<String> model = new DefaultListModel<String>();

		String sDato = "";
		for (int i = 0; i < aDatos.size(); i++) {
			sDato = aDatos.get(i);
			model.addElement(sDato);
		}
		return model;
	}
}
