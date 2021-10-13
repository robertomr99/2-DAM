package unico;

import java.io.*;

public class Principal {

	public static void main(String[] args) {

		// Mi app apunta a un fichero...

		String fichero = "Ficheros\\Ciudades.txt"; // La doble barra en la ruta es un codigo de escape
		File fch = new File(fichero);

		if (fch.exists()) {

			String fchNombreArchivo = fch.getName();
			String fchCarpetaPadre = fch.getParent();
			String fchRutaAbsoluta = fch.getAbsolutePath();
			long fchBytes = fch.length();

			boolean fchPuedeLeer = fch.canRead();
			boolean fchPuedeEscribir = fch.canWrite();
			boolean fchPuedeEjecutar = fch.canExecute();

			System.out.println("Nombre del archivo: " + fchNombreArchivo);
			System.out.println("Carpeta padre: " + fchCarpetaPadre);
			System.out.println("Ruta absoluta: " + fchRutaAbsoluta);
			System.out.println("Tamaño (Bytes) : " + fchBytes);

			System.out.println("Se puede leer : " + SiNo(fchPuedeLeer));
			System.out.println("Se puede escribir: " + SiNo(fchPuedeEscribir));
			System.out.println("Se puede ejecutar : " + SiNo(fchPuedeEjecutar));

			// System.out.println("EXISTE");

		} else {
			System.out.println("NO EXISTE");

		}
	}

	private static String SiNo(boolean boExp) {
		return boExp ? "Sí" : "No"; // Si el booleano es true devuelve un String con "Si" y si es False con "No" >
									// Evaluacion Ternaria
	}

}
