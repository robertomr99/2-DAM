package unico;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class Principal {

	public static void main(String[] args) {

		// Mi app apunta a un fichero...

		// String ruta = "Ficheros\\Ciudades.txt"; // La doble barra en la ruta es un
		// codigo de escape

		String ruta = "C:\\Prueba";
		File fch = new File(ruta);
		int iNCarpetasGlobal = 0, iNArchivosGlobal = 0;

		if (fch.exists()) {

			contadorTipoFicherosRecursividad(fch, 0);

			System.out.println("Subcarpetas: " + countSubCarpetas(fch));

			// contadorCantidadTiposDeFicheros(fch,0,iNCarpetasGlobal, iNArchivosGlobal);
			// System.out.println("Carpetas -> " + iNCarpetasGlobal + "\nArchivos ->" +
			// iNArchivosGlobal);
			// contadorTipoFicheros(fch);
			// verTipoArchivo(fch);

			// if (fch.isDirectory()) {
			// infoDir(fch);
			// verSubCarpetas(fch);
			// } else {
			// infoFile(fch); }

			// System.out.println("EXISTE");

		} else {
			System.out.println("NO EXISTE");

		}
	}

	private static void verTipoArchivo(File fch) {

		File[] dirContenido = fch.listFiles();
		ArrayList<String> sNombres = new ArrayList<String>();

		String sInfoPrevio;

		for (File f : dirContenido) {
			sInfoPrevio = f.isDirectory() ? "FCH" : "DIR";
			sNombres.add(sInfoPrevio + " " + f.getName());
		}

		Collections.sort(sNombres); // Para ordenar
		sNombres.forEach((sNombre) -> System.out.println(sNombre)); // Otra forma de imprimir (Arrow Function)

		for (String sNombre : sNombres) {
			System.out.println(sNombre);
		}
	}

	private static void contadorTipoFicheros(File fch) {
		File[] dirContenido = fch.listFiles();
		int iNCarpetas = 0, iNArchivos = 0;
		for (File f : dirContenido) {
			if (f.isDirectory()) {
				iNArchivos++;
			} else {
				iNCarpetas++;
			}
		}
		System.out.println("Hay: " + iNCarpetas + "  carpetas y " + iNArchivos + " directorios");
	}

	private static int countItems(File Carpeta) {
		File[] Contenido = Carpeta.listFiles();
		int iContador = Contenido.length;
		for (int i = 0; i < Contenido.length; i++) {
			if (Contenido[i].isDirectory()) {
				iContador += countItems(Contenido[i]);
			}
		}
		return iContador;
	}

	private static int countSubCarpetas(File Carpeta) {
		File[] Contenido = Carpeta.listFiles();
		int iContador = 0;
		for (int i = 0; i < Contenido.length; i++) {
			if (Contenido[i].isDirectory()) {
				iContador++;
				iContador += countItems(Contenido[i]);
			}
		}
		return iContador;
	}
	
	private static int countSubFiles(File Carpeta) {
		File[] Contenido = Carpeta.listFiles();
		int iContador = 0;
		for (int i = 0; i < Contenido.length; i++) {
			if (Contenido[i].isFile()) {
				iContador++;
				if()
				iContador += countItems(Contenido[i]);
			}
		}
		return iContador;
	}

	private static void contadorTipoFicherosRecursividad(File fch, int iNivel) {
		for (int i = 0; i < iNivel; i++) {
			System.out.print("-");
		}
		System.out.println(fch.getName());
		if (fch.isDirectory()) {
			File[] dirContenido = fch.listFiles();
			for (File FileItem : dirContenido) {
				contadorTipoFicherosRecursividad(FileItem, iNivel + 1);
			}
		}
	}

	/*
	 * private static void contadorCantidadTiposDeFicheros(File fch, int iNivel, int
	 * iNArchivosGlobal, int iNCarpetasGlobal) { int iNArchivos =0 ; int iNCarpetas
	 * = 0;
	 * 
	 * for (int i = 0; i < iNivel; i++) { System.out.print("-"); }
	 * 
	 * System.out.println(fch.getName());
	 * 
	 * if (fch.isDirectory()) { File[] dirContenido = fch.listFiles();
	 * 
	 * for (File f : dirContenido) { if (f.isDirectory()) { iNArchivos++;
	 * iNArchivosGlobal += iNArchivos; } else { iNCarpetas++; iNCarpetasGlobal +=
	 * iNArchivos; } }
	 * 
	 * for (File FileItem : dirContenido) {
	 * contadorCantidadTiposDeFicheros(FileItem, iNivel + 1); } } }
	 */

	private static void verSubCarpetas(File fch) {
		File[] dirContenido = fch.listFiles();

		for (File f : dirContenido) {
			if (f.isDirectory())
				System.out.println(f.getName());
		}
	}

	private static void infoDir(File fch) {
		System.out.println("Es un directorio");

		long dirEspacioLibreBytes = fch.getFreeSpace();
		long dirEspacioLibreMB = fch.getFreeSpace() / 1024 / 1024;
		long dirEspacioLibreGB = dirEspacioLibreMB / 1024;

		File[] dirContenido = fch.listFiles();

		String info;

		for (File f : dirContenido) {
			info = f.getName();
			System.out.println(info);
		}

		System.out.println("El espacio libre es: " + dirEspacioLibreBytes + " bytes.");
		System.out.println("El espacio libre es: " + dirEspacioLibreMB + " MB.");
		System.out.println("El espacio libre es: " + dirEspacioLibreGB + " GB.");

	}

	private static void infoFile(File fch) {

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
	}

	private static String SiNo(boolean boExp) {
		return boExp ? "Sí" : "No"; // Si el booleano es true devuelve un String con "Si" y si es False con "No" >
									// Evaluacion Ternaria
	}

}
