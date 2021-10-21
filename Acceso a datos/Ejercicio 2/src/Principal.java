import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Principal {

	static String sRuta = "C:\\";
	static String sCadenaBuscada = "enero";
	static File fch = new File(sRuta);
	static ArrayList<String> aRutas;

	public static void main(String[] args) {

		leerArray(aRutas = encontrarFichero(sRuta, sCadenaBuscada));
	}

	private static ArrayList<String> encontrarFichero(String sRuta, String sCadenaBuscada) {
		File[] dirContenido = fch.listFiles();
		ArrayList<String> sNombres = new ArrayList<String>();
		String sCadena = "";

		try {
			BufferedReader bufReader = new BufferedReader(new FileReader(fch));

			for (File f : dirContenido) {
				if (f.isFile()) {
					sCadena = bufReader.readLine();
					while (sCadena != null) {
						if (sCadena == sCadenaBuscada) {
							sNombres.add(sRuta + f.getName());
						}
						sCadena = bufReader.readLine();
					}
					bufReader.close();
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return sNombres;
	}

	private static void leerArray(ArrayList<String> aContenido) {
		for (int iContador = 0; iContador < aContenido.size(); iContador++) {
			System.out.println(aContenido.get(iContador));
		}
	}
}
