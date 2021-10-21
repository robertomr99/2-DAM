package principal;

import java.io.File;
import java.util.ArrayList;

public class Principal {

	static String sRuta = "C:\\Users\\Usuario\\";
	static String sCadena = "col";
	static File fch = new File(sRuta);
	static ArrayList<String> aRutas;

	public static void main(String[] args) {
		leerArray(aRutas = nombresFichero(sRuta, sCadena));
	}

	private static ArrayList<String> nombresFichero(String sRuta, String sCadena) {
		File[] dirContenido = fch.listFiles();
		ArrayList<String> sNombres = new ArrayList<String>();
		for (File f : dirContenido) {
			if (f.isFile() && f.getName().contains(sCadena)) {
				sNombres.add(sRuta + f.getName());
			}
		}
		return sNombres;
	}

	private static void leerArray(ArrayList<String> aContenido) {
		for (int iContador = 0; iContador < aContenido.size(); iContador++) {
			System.out.println(aContenido.get(iContador));
		}
	}
}
