package ctrl;

import java.awt.Font;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.text.AttributeSet.FontAttribute;
import java.awt.Color;


public class CtrlFrmPrincipal {

	public static File fileSelected, fchAyuda = new File("Ayuda.txt"), fileFont = new File("Fuentes.dat"), fileColor = new File("Color.dat");;
	public static String sContenido;
	public static Color cBackgroundDefault, cForegroundDefault;


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

	public static void cambiarFuente() {

		if (view.FrmFuente.rdbtnCursiva.isSelected()) {
			view.FrmFuente.lblTextoPrueba
					.setFont(new Font(view.FrmFuente.sFuente, Font.ITALIC, Integer.parseInt(view.FrmFuente.sTamano)));
		} else if (view.FrmFuente.rdbtnNegrita.isSelected()) {
			view.FrmFuente.lblTextoPrueba
					.setFont(new Font(view.FrmFuente.sFuente, Font.BOLD, Integer.parseInt(view.FrmFuente.sTamano)));
		} else {
			view.FrmFuente.lblTextoPrueba
					.setFont(new Font(view.FrmFuente.sFuente, Font.PLAIN, Integer.parseInt(view.FrmFuente.sTamano)));
		}

	}
	
	
	public static void writeFont() {
        try {
            ObjectOutputStream buff = new ObjectOutputStream(new FileOutputStream(fileFont));
            buff.writeObject(fileFont);
            buff.close();
        } catch (FileNotFoundException e) {
            System.err.println("ERROR: " + fileFont + " NO EXISTE");
        } catch (IOException e) {
            System.err.println("ERROR: NO SE PUEDE ESCRIBIR EN EL FICHERO");
        }
    }
	
	
	public static Font readFont() {
		Font oFont = null;
        try {
            ObjectInputStream buff = new ObjectInputStream( new FileInputStream(fileFont));

            oFont = (Font) buff.readObject();
            buff.close();
      
        } catch (FileNotFoundException e) {
            System.err.println("ERROR: " + fileFont+ " NO EXISTE");
        } catch (IOException e) {
            System.err.println("ERROR: NO SE PUEDE LEER EN EL FICHERO");
        } catch (ClassNotFoundException e) {
            System.err.println("EL FICHERO NO CONTIENE UN OBJETO.");
        }

        return oFont;
    }
	
	
	public static void writeColor() {
        try {
            ObjectOutputStream buff = new ObjectOutputStream(new FileOutputStream(fileColor));
            buff.writeObject(view.FrmColores.cBackgroundDefault);
            buff.writeObject(view.FrmColores.cForegroundDefault);
            buff.close();
        } catch (FileNotFoundException e) {
            System.err.println("ERROR: " + fileColor + " NO EXISTE");
        } catch (IOException e) {
            System.err.println("ERROR: NO SE PUEDE ESCRIBIR EN EL FICHERO");
        }
    }
	
	
	public static void readColor() {
        try {
            ObjectInputStream buff = new ObjectInputStream( new FileInputStream(fileColor));
            cBackgroundDefault = (Color) buff.readObject();
            cForegroundDefault = (Color) buff.readObject();
            buff.close();
      
        } catch (FileNotFoundException e) {
            System.err.println("ERROR: " + fileColor+ " NO EXISTE");
        } catch (IOException e) {
            System.err.println("ERROR: NO SE PUEDE LEER EN EL FICHERO");
        } catch (ClassNotFoundException e) {
            System.err.println("EL FICHERO NO CONTIENE UN OBJETO.");
        }
    }
	
	public static void defaultConfig() {
		view.FrmPrincipal.txtArea.setFont(readFont());
		readColor();
		view.FrmPrincipal.txtArea.setBackground(cBackgroundDefault);
		view.FrmPrincipal.txtArea.setForeground(cForegroundDefault);	
	}
	
	
}
