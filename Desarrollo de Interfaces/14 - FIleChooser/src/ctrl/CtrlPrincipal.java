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

import javax.swing.DefaultListModel;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

import model.Contacto;

public class CtrlPrincipal {

	public static ArrayList<Contacto> aContactos = new ArrayList<Contacto>();
	public static File fileSelected;

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
			fileSelected = selectorFch.getSelectedFile();

			if (fileSelected != null && !fileSelected.getName().equals("")) {
				aContactos = leerContactos(fileSelected);
				volcarContactos();
			}
		}
	}

	public static void volcarContactos() {

		DefaultListModel<String> model = new DefaultListModel<String>();

		String sNombre = "";
		for (int i = 0; i < aContactos.size(); i++) {
			sNombre = aContactos.get(i).getsNombre();
			model.addElement(sNombre);
			// sTelefono = aContactos.get(i).getsTelefono();
		}
		view.FrmPrincipal.lstContactos.setModel(model);

	}

	public static ArrayList<Contacto> leerContactos(File fileSelected) {

		try {
			FileReader fchLectura = new FileReader(fileSelected);
			BufferedReader bufLectura = new BufferedReader(fchLectura);

			String sLineaLeida, sNombre, sTelefono;
			sLineaLeida = bufLectura.readLine();

			while (sLineaLeida != null) {

				// Fragmentamos la linea

				StringTokenizer sCampo = new StringTokenizer(sLineaLeida, "#");
				sNombre = sCampo.nextToken();
				sTelefono = sCampo.nextToken();

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

	public static void escribirFichero() {

		try {

			FileWriter fchEscritura = new FileWriter(fileSelected);
			BufferedWriter bufEscritura = new BufferedWriter(fchEscritura);

			String sLineaLeida = "";
			String sSeparador = "#";

			for (int iContador = 0; iContador < aContactos.size(); iContador++) {
				sLineaLeida = aContactos.get(iContador).getsNombre() + sSeparador
						+ aContactos.get(iContador).getsTelefono();
				bufEscritura.write(sLineaLeida);
				if (iContador < aContactos.size() - 1) {
					bufEscritura.newLine();
				}
			}
			
			bufEscritura.close();
			fchEscritura.close();
			

		} catch (FileNotFoundException e) {
			System.err.println("Fichero no encontrado.");
		}

		catch (IOException e) {
			System.err.println("Error accediendo al fichero.");
		}

	}

}
