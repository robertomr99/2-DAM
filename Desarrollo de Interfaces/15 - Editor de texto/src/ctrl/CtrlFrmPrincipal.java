package ctrl;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

public class CtrlFrmPrincipal {

	public static File fileSelected;
	public static File fchAyuda = new File("Ayuda.txt");
	public static String sContenido;

	public static void abrirFichero() {
		JFileChooser selectorFch = new JFileChooser();
		selectorFch.setFileSelectionMode(JFileChooser.FILES_ONLY);

		FileNameExtensionFilter txtFilter = new FileNameExtensionFilter("Formato de Textos", "txt");

		selectorFch.setFileFilter(txtFilter);

		int iBtnFch = selectorFch.showOpenDialog(null);

		if (iBtnFch != JFileChooser.CANCEL_OPTION) {
			fileSelected = selectorFch.getSelectedFile();
			if (fileSelected != null && !fileSelected.getName().equals("")) {
				sContenido = leerArchivo(fileSelected);
				view.FrmPrincipal.txtArea.setText(sContenido);
			}
		}
	}

	public static void guardarComoFichero() {
		JFileChooser selectorFch = new JFileChooser();
		selectorFch.setFileSelectionMode(JFileChooser.FILES_ONLY);
		FileNameExtensionFilter txtFilter = new FileNameExtensionFilter("Formato de Textos", "txt");
		selectorFch.setFileFilter(txtFilter);
		int iBtnFch = selectorFch.showSaveDialog(null);
		if (iBtnFch != JFileChooser.CANCEL_OPTION) {
			fileSelected = selectorFch.getSelectedFile();
			if (fileSelected != null && !fileSelected.getName().equals("")) {
				escribirFichero(fileSelected);
			}
		}
	}

	public static String leerArchivo(File fileSelected) {
		String sTexto = "";
		try {
			RandomAccessFile fch = new RandomAccessFile(fileSelected, "r");
			byte[] bytesLeidos = new byte[(int) fch.length()];
			fch.readFully(bytesLeidos);
			sTexto = new String(bytesLeidos);
			fch.close();
		} catch (IOException e) {
			System.err.println("El fichero no es accesible");
		}
		return sTexto;
	}

	public static void escribirFichero(File fch) {
		try {

			FileWriter fchEscritura = new FileWriter(fch);
			BufferedWriter bufEscritura = new BufferedWriter(fchEscritura);

			String sLineaLeida = view.FrmPrincipal.txtArea.getText();

			if (sLineaLeida != null) {
				bufEscritura.write(sLineaLeida);
			}

			bufEscritura.close();
			fchEscritura.close();

		} catch (

		FileNotFoundException e) {
			System.err.println("Fichero no encontrado.");
		}

		catch (IOException e) {
			System.err.println("Error accediendo al fichero.");
		}
	}
}
