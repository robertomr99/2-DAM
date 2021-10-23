package unico;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// File nombreFichero = new File("notas.txt");

		// leerFichero(nombreFichero);

		File nombreFchSource = new File("notas.txt");
		File nombreFchTarget = new File("notas2.txt");
		File nombreFchEncripted = new File("Encriptado.txt");

		int iClave = 5;
		
		//encriptarFichero(nombreFchSource, nombreFchEncripted, iClave);

		desencriptarFichero(nombreFchEncripted, nombreFchSource, iClave);
		
		// escribirFichero(nombreFchSource);
		// encriptarFichero(nombreFchSource, nombreFchEncripted, iClave);
		// desencriptarFichero(nombreFchEncripted, nombreFchSource, iClave);

		/*ArrayList<Persona> aPersonas = leerPersona(nombreFchSource);
		aPersonas.forEach(P -> System.out.println(P));*/

		// escribirFicheroEncriptado(nombreFchSource);
		// copiarFich(nombreFchSource, nombreFchTarget);
		// contarConsonantesyVocales(nombreFchSource, nombreFchTarget);
	}

	/*private static ArrayList<Persona> leerPersona(File nombreFchSource) {

		ArrayList<Persona> aContenido = new ArrayList<Persona>();

		try {
			FileReader fchLectura = new FileReader(nombreFchSource);
			BufferedReader bufLectura = new BufferedReader(fchLectura);

	
			while (oPers != null) {

				// Procesamos la linea que acabamos de leer

				aContenido.add(oPers);

				// Realizamos una nueva lectura

				oPers = bufLectura.readLine();
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
	
	*/

	private static void encriptarFichero(File nombreFchSource, File nombreFchEncripted, int iClave) {

		try {
			FileReader fchSource = new FileReader(nombreFchSource);
			FileWriter fchEncripted = new FileWriter(nombreFchEncripted);

			// Proceso de copia

			int iAscii;

			iAscii = fchSource.read();

			while (iAscii != -1) {
				fchEncripted.write(iAscii - (iClave * 2));
				iAscii = fchSource.read();
				
						
			}

			// Cierre de los dos ficheros

			fchSource.close();
			fchEncripted.close();

		} catch (FileNotFoundException e) {
			System.err.println("Fichero no encontrado.");
		}

		catch (IOException e) {
			System.err.println("Error accediendo al fichero.");
		}

	}

	private static void desencriptarFichero(File nombreFchEncripted, File nombreFchSource, int iClave) {

		try {
			FileReader fchEncripted = new FileReader(nombreFchEncripted);
			FileWriter fchSource = new FileWriter(nombreFchSource);

			// Proceso de copia

			int iAscii;

			iAscii = fchEncripted.read();

			while (iAscii != -1) {
				fchSource.write(iAscii + (iClave * 2));
				iAscii = fchEncripted.read();
			}

			// Cierre de los dos ficheros

			fchEncripted.close();
			fchSource.close();

		} catch (FileNotFoundException e) {
			System.err.println("Fichero no encontrado.");
		}

		catch (IOException e) {
			System.err.println("Error accediendo al fichero.");
		}

	}

	private static void escribirFicheroEncriptado(File nombreFichero) {

		String sTexto = "Hola";

		try {
			FileWriter fch = new FileWriter(nombreFichero);

			for (int x = 0; x < sTexto.length(); x++) {
				char chLetra = sTexto.charAt(x);

				int iAscii = chLetra;

				// System.out.println(chLetra + " " + iAscii + " " + (chLetra + 1) + " " +
				// (char) (chLetra + 1));
				fch.write(chLetra + 1);
			}

			fch.close();

		} catch (FileNotFoundException e) {
			System.err.println("Fichero no encontrado.");
		}

		catch (IOException e) {
			System.err.println("Error accediendo al fichero.");
		}
	}

	private static void contarConsonantesyVocales(File nombreFchSource, File nombreFchTarget) {
		try {

			// Apertura de los 2 ficheros

			FileReader fchSource = new FileReader(nombreFchSource);
			FileWriter fchTarget = new FileWriter(nombreFchTarget);

			// Proceso de copia

			int iAscii;
			int iContadorVocales = 0, iContadorConsonantes = 0;

			iAscii = fchSource.read();
			while (iAscii != -1) {
				if (Character.isLetter(iAscii)) {
					if (iAscii == 97 || iAscii == 101 || iAscii == 105 || iAscii == 111 || iAscii == 117) {
						iContadorVocales++;
					} else {
						iContadorConsonantes++;
					}

				}
			}
			fchTarget.write(iAscii);
			iAscii = fchSource.read();

			// Cierre de los dos ficheros

			fchSource.close();
			fchTarget.close();

			// Informacion resultado del proceso

			System.out.println("Vocales: " + iContadorVocales + "\nConsonantes: " + iContadorConsonantes);

		} catch (FileNotFoundException e) {
			System.err.println("Fichero no encontrado.");
		}

		catch (IOException e) {
			System.err.println("Error accediendo al fichero.");
		}

	};

	private static void copiarFich2(File nombreFchSource, File nombreFchTarget) {
		try {

			// Apertura de los 2 ficheros

			FileReader fchSource = new FileReader(nombreFchSource);
			FileWriter fchTarget = new FileWriter(nombreFchTarget);

			// Proceso de copia

			int iAscii;
			int iContador = 0;

			iAscii = fchSource.read();

			while (iAscii != -1) {
				iContador++;
				fchTarget.write(iAscii);
				iAscii = fchSource.read();
			}

			// Cierre de los dos ficheros

			fchSource.close();
			fchTarget.close();

			// Informacion resultado del proceso

			System.out.println("Se han copiado " + iContador + " caracteres");

		} catch (FileNotFoundException e) {
			System.err.println("Fichero no encontrado.");
		}

		catch (IOException e) {
			System.err.println("Error accediendo al fichero.");
		}

	}

	private static void copiarFich(File nombreFchSource, File nombreFchTarget) {
		try {

			// Apertura de los 2 ficheros

			FileReader fchSource = new FileReader(nombreFchSource);
			FileWriter fchTarget = new FileWriter(nombreFchTarget);

			// Proceso de copia

			int iAscii;
			int iContador = 0;

			iAscii = fchSource.read();

			while (iAscii != -1) {
				iContador++;
				fchTarget.write(iAscii);
				iAscii = fchSource.read();
			}

			// Cierre de los dos ficheros

			fchSource.close();
			fchTarget.close();

			// Informacion resultado del proceso

			System.out.println("Se han copiado " + iContador + " caracteres");

		} catch (FileNotFoundException e) {
			System.err.println("Fichero no encontrado.");
		}

		catch (IOException e) {
			System.err.println("Error accediendo al fichero.");
		}

	}

	private static void leerFichero(File nombreFichero) {

		try {
			FileReader fch = new FileReader(nombreFichero);

			int iAscii;
			iAscii = fch.read();

			while (iAscii != -1) {
				System.out.print((char) iAscii);
				iAscii = fch.read();
			}

			fch.close();

		} catch (FileNotFoundException e) {
			System.err.println("Fichero no encontrado.");
		}

		catch (IOException e) {
			System.err.println("Error accediendo al fichero.");
		}

	}

	private static void escribirFichero(File nombreFichero) {
		try {
			FileWriter fch = new FileWriter(nombreFichero);

			String sTexto = "";

			fch.write(sTexto);

			do {
				sTexto = leerCadena("Escriba una frase (Enter=Salir): ");
				if (sTexto.length() != 0) {
					fch.write(sTexto + "\n");
				}
			} while (sTexto.length() != 0);
			fch.close();

		} catch (FileNotFoundException e) {
			System.err.println("Fichero no encontrado.");
		}

		catch (IOException e) {
			System.err.println("Error accediendo al fichero.");
		}
	}

	private static String leerCadena(String sPregunta) {
		System.out.println(sPregunta);

		String sRespuesta = "";
		BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));
		try {
			sRespuesta = teclado.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return sRespuesta.toLowerCase();

	}
}
