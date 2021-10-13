package unico;

import java.io.*;
import java.util.ArrayList;

public class Principal {

	public static void main(String[] args) {

		String sTexto = "Miguel", sTexto2 = "Mongolo", sTexto3 = "Gitano";
		File fch = new File("ejemplo.txt");

		ArrayList<String> sArrayTexto = new ArrayList<String>();

		sArrayTexto.add(sTexto);
		sArrayTexto.add(sTexto2);
		sArrayTexto.add(sTexto3);

		// escribirTexto(fch, sTexto);

		// escribirArrayList

		ArrayList<String> frases = leerFichero(fch);
		frases.forEach(sObjeto -> System.out.println(sObjeto));

	}

	private static ArrayList<String> leerFichero(File fch) {
		ArrayList<String> aContenido = new ArrayList<String>();

		try {
			FileReader fchLectura = new FileReader(fch);
			BufferedReader bufLectura = new BufferedReader(fchLectura);

			String sLineaLeida;

			sLineaLeida = bufLectura.readLine();
			while (sLineaLeida != null) {
				
			// Procesamos la linea que acabamos de leer	
				
				aContenido.add(sLineaLeida);
				
				
			// Realizamos una nueva lectura	
	
				sLineaLeida = bufLectura.readLine();
			}

			bufLectura.close();
			fchLectura.close();

		} catch (FileNotFoundException e) {
			System.err.println("No existe");
		} catch (IOException e) {
			System.err.println("Se ha producido un error accediendo a nuestro fichero");
		}

		return aContenido;
	}

	private static void escribirTexto(File fch, String sTexto) {
		try {

			// Abrir el fichero
			FileWriter fichero = new FileWriter(fch);

			// Crear un buffer para escribir datos y que se envien al fichero
			BufferedWriter bufEscritura = new BufferedWriter(fichero);

			// Ahora escribimos sobre el buffery el buffer lo escribe en el fichero
			bufEscritura.write(sTexto);

			// Vaciamos el buffer con flush para que no se queden datos por escribir y
			// cerramos buffer
			bufEscritura.flush();
			bufEscritura.close();

			// Cerramos el fichero
			fichero.close();

		} catch (IOException ioe) {
			System.err.println("Error accediendo al fichero.");
		}
	}

	private static void escribirTextov2(File fch, String sTexto) {
		try {

			// Pasamos directamente al buffer como parametro el FileWriter

			BufferedWriter fichero = new BufferedWriter(new FileWriter(fch));

			// Ahora solo jugamos con el buffer fichero.

			fichero.write(sTexto);
			fichero.flush();
			fichero.close();

		} catch (IOException ioe) {
			System.err.println("Error accediendo al fichero.");
		}
	}

	private static void escribirArrayListString(File fch, ArrayList<String> sArrayTexto) {

		try {

			BufferedWriter fichero = new BufferedWriter(new FileWriter(fch));

			for (int x = 0; x < sArrayTexto.size(); x++) {
				if (x < sArrayTexto.size() - 1) {
					fichero.write(sArrayTexto.get(x) + "\n");
				}
				fichero.write(sArrayTexto.get(x));
			}
			fichero.flush();
			fichero.close();

		} catch (IOException ioe) {
			System.err.println("Error accediendo al fichero.");
		}

	}
}
