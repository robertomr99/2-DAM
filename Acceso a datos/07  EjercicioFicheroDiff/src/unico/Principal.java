package unico;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.StringTokenizer;
import model.Conexion;

public class Principal {

	public static void main(String[] args) {

		File nombreFch1 = new File("F1.txt");
		File nombreFch2 = new File("F2.txt");
		File nombreFchDif = new File("FD.txt");
		File nombreFchInvertido = new File("FInv.txt");

		// crearFchComun(nombreFch1, nombreFch2, nombreFchDif);

		invertirFch(nombreFch1, nombreFchInvertido);

	}

	private static void invertirFch(File nombreFch1, File nombreFchInvertido) {
		
		try {
			
			BufferedWriter bufFInvWriter = new BufferedWriter (new FileWriter(nombreFchInvertido));
			BufferedReader bufF1Reader = new BufferedReader (new FileReader(nombreFch1));
			int iContador=-1;
			String sLinea = "";
			
			while (sLinea != null) {
				sLinea = bufF1Reader.readLine();
				iContador++;
			}
			
			for(int i = 0 ; i < iContador; iContador ++) {
				
			}
			
			System.out.println(iContador);
			
		} catch (FileNotFoundException e) {
			System.err.println("Fichero no encontrado.");
		}

		catch (IOException e) {
			System.err.println("Error accediendo al fichero.");
		}
	}

	private static void crearFchComun(File nombreFch1, File nombreFch2, File nombreFchDif) {

		try {

			BufferedWriter bufFDWriter = new BufferedWriter(new FileWriter(nombreFchDif));
			BufferedReader bufF1Reader = new BufferedReader(new FileReader(nombreFch1));

			String sLinea1 = "", sLinea2 = "";

			sLinea1 = bufF1Reader.readLine();

			while (sLinea1 != null) {
				BufferedReader bufF2Reader = new BufferedReader(new FileReader(nombreFch2));
				sLinea2 = bufF2Reader.readLine();
				while (sLinea2 != null) {
					if (sLinea1.equals(sLinea2)) {
						bufFDWriter.write(sLinea1);
						bufFDWriter.newLine();
					}
					sLinea2 = bufF2Reader.readLine();

				}
				sLinea1 = bufF1Reader.readLine();
				bufF2Reader.close();
			}

			bufFDWriter.close();
			bufF1Reader.close();

		} catch (FileNotFoundException e) {
			System.err.println("Fichero no encontrado.");
		}

		catch (IOException e) {
			System.err.println("Error accediendo al fichero.");
		}
	}

}
