package unico;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

import model.Persona;

public class Principal {

	public static void main(String[] args) {

		File nombreFchSource = new File("Personas.txt");
		File nombreFchSalida = new File("PersonasCopiado.txt");

		ArrayList<Persona> aPersonas = leerPersona(nombreFchSource);
		aPersonas.forEach(P -> System.out.println(P));
		escribirPersona(nombreFchSalida, aPersonas);

	}

	private static void escribirPersona(File nombreFchSalida, ArrayList<Persona> aPersonas) {

		try {
			FileWriter fchEscritura = new FileWriter(nombreFchSalida);
			BufferedWriter bufWriter = new BufferedWriter(fchEscritura);

			String sLinea = "";
			String sSeparador = "#";

			for (int i = 0; i < aPersonas.size(); i++) {

				sLinea = aPersonas.get(i).getsNombre() + sSeparador + aPersonas.get(i).getsApellido() + sSeparador
						+ aPersonas.get(i).getiEdad();
				bufWriter.write(sLinea);
				if (i < aPersonas.size() - 1) {
					bufWriter.newLine();
				}
			}

			bufWriter.flush();
			bufWriter.close();
			fchEscritura.close();

		} catch (FileNotFoundException e) {
			System.err.println("Fichero no encontrado.");
		}

		catch (IOException e) {
			System.err.println("Error accediendo al fichero.");
		}

	}

	private static ArrayList<Persona> leerPersona(File nombreFchSource) {

		ArrayList<Persona> aContenido = new ArrayList<Persona>();

		try {
			FileReader fchLectura = new FileReader(nombreFchSource);
			BufferedReader bufLectura = new BufferedReader(fchLectura);

			String sLineaLeida;
			sLineaLeida = bufLectura.readLine();

			while (sLineaLeida != null) {

				// Fragmentamos la linea

				StringTokenizer sCampo = new StringTokenizer(sLineaLeida, "#");
				String sNombre = sCampo.nextToken();
				String sApellidos = sCampo.nextToken();
				String sEdad = sCampo.nextToken();

				// Añadimos un nuevo objeto al array de personas

				aContenido.add(new Persona(sNombre, sApellidos, Integer.parseInt(sEdad)));

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

		return aContenido;

	}

}
