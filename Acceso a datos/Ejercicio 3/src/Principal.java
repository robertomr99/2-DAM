import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.StringTokenizer;

public class Principal {

	static File fch1 = new File("Fichero1.txt");
	static File fch2 = new File("Fichero2.txt");

	static String sFichero1 = fch1.getName();
	static String sFichero2 = fch2.getName();

	public static void main(String[] args) {

		contarSiExiste(sFichero1, sFichero2);

	}

	private static void contarSiExiste(String sFichero1, String sFichero2) {
		try {

			BufferedReader bufFReader = new BufferedReader(new FileReader(sFichero1));
		  

			int iContador = 0;
			String sLinea1 = "", sLinea2 = "";
			String sLetra1 = "", sLetra2 = "";

			sLinea1 = bufFReader.readLine();

			StringTokenizer sCampo = new StringTokenizer(sLinea1.trim(), ",");
			StringTokenizer sCampo2 = new StringTokenizer(sLinea2.trim(), ",");

			while (sLinea1 != null) {
				sLetra1 = sCampo.nextToken();
				 BufferedReader bufF2Reader = new BufferedReader(new FileReader(sFichero2));
				 sLinea2 = bufF2Reader.readLine();
				while (sLinea2 != null) {
					if (sCampo2.hasMoreElements()) {
				sLinea2 = null;
					}else {
						sLetra2 = sCampo2.nextToken();
						if (sLetra1.trim().equals(sLetra2.trim())) {
							iContador++;
					}
				}
				System.out.print(sLetra1 + iContador);
				iContador = 0;
				bufF2Reader.close();
			}

			bufFReader.close();

		} catch (FileNotFoundException e) {
			System.err.println("Fichero no encontrado.");
		}

		catch (IOException e) {
			System.err.println("Error accediendo al fichero.");
		}
	}

	/*
	 * private static void contarSiExiste(String sFichero1, String sFichero2) { try
	 * {
	 * 
	 * BufferedReader bufFReader = new BufferedReader(new FileReader(sFichero1));
	 * 
	 * 
	 * int iContador = 0; String sLinea1 = "", sLinea2 = ""; String sLetra1 ="",
	 * sLetra2="";
	 * 
	 * sLinea1 = bufFReader.readLine();
	 * 
	 * 
	 * while (sLinea1 != null) { BufferedReader bufF2Reader = new BufferedReader(new
	 * FileReader(sFichero2)); sLinea2 = bufF2Reader.readLine(); while (sLinea2!=
	 * null) {
	 * 
	 * if (sLinea1.equals(sLinea2)) { iContador++; } } System.out.print(sLetra1 +
	 * iContador); iContador = 0; bufF2Reader.close(); }
	 * 
	 * bufFReader.close();
	 * 
	 * } catch (FileNotFoundException e) {
	 * System.err.println("Fichero no encontrado."); }
	 * 
	 * catch (IOException e) { System.err.println("Error accediendo al fichero."); }
	 * }
	 * 
	 */
}
