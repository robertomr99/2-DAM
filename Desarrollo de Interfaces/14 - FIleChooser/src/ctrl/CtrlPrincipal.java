package ctrl;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

import model.Contacto;

public class CtrlPrincipal {

	public static void inicio() {

		new view.FrmPrincipal();

	}

	public static void abrirFichero() {
		JFileChooser selectorFch = new JFileChooser();
		selectorFch.setFileSelectionMode(JFileChooser.FILES_ONLY);

		// FileNameExtensionFilter imgFilter = new FileNameExtensionFilter("Formato de
		// Imágenes", "jpg", "bmp", "gif");

		FileNameExtensionFilter txtFilter = new FileNameExtensionFilter("Formato de Textos", "txt");

		selectorFch.setFileFilter(txtFilter);

		int iBtnFch = selectorFch.showOpenDialog(null);

		if (iBtnFch != JFileChooser.CANCEL_OPTION) {
			File fileSelected = selectorFch.getSelectedFile();

			if (fileSelected != null && !fileSelected.getName().equals("")) {
				ArrayList<Contacto> aContactos = leerContactos(fileSelected);
				volcarContactos(aContactos);
			}
		}
	}

	public static void volcarContactos(ArrayList<Contacto> aContactos) {

		String sNombre = "";
		for (int i = 0; i < aContactos.size(); i++) {
			sNombre = aContactos.get(i).getsNombre();
			view.FrmPrincipal.lstContactos.add(sNombre);
			// sTelefono = aContactos.get(i).getsTelefono();
		}
	}

	public static ArrayList<Contacto> leerContactos(File fileSelected) {

		ArrayList<Contacto> aContactos = new ArrayList<Contacto>();

		try {
			FileReader fchLectura = new FileReader(fileSelected);
			BufferedReader bufLectura = new BufferedReader(fchLectura);

			String sLineaLeida;
			sLineaLeida = bufLectura.readLine();

			while (sLineaLeida != null) {

				// Fragmentamos la linea

				StringTokenizer sCampo = new StringTokenizer(sLineaLeida, "#");
				String sNombre = sCampo.nextToken();
				String sTelefono = sCampo.nextToken();

				// Añadimos un nuevo objeto al array de personas

				aContactos.add(new Contacto(sNombre, sTelefono));

				// Realizamos una nueva lectura

				sLineaLeida = bufLectura.readLine();
			}

			bufLectura.close();
			fchLectura.close();

		} catch (FileNotFoundException e) {
			System.err.println("Fichero no encontrado.");
		}

		catch (IOException e) {
			System.err.println("Error accediendo al fichero.");
		}

		return aContactos;
	}

}
