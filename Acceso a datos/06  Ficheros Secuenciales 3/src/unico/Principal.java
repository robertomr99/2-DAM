package unico;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;
import model.Conexion;

public class Principal {

	public static void main(String[] args) {

		File nombreFchSource = new File("Conexion.cfg");

		// Conexion conn = leerConfiguracion(nombreFchSource);

		Conexion conn = leerConfiguracion_v2(nombreFchSource);

		System.out.println(conn);

	}

	private static Conexion leerConfiguracion_v2(File Fichero) {

		Conexion conn2 = new Conexion();
		final String sSeparador = ":";
		HashMap<String, String> Mapa = new HashMap<String, String>();

		// Gracias a el mapa no importa el orden en el que esten los datos puesto que buscar por una clave "HOST"
		
		try {
			FileReader fchReader = new FileReader(Fichero);
			BufferedReader bufReader = new BufferedReader(fchReader);

			String sLinea = "";
			String[] sCampo;
			sLinea = bufReader.readLine();

			while (sLinea != null) {
				sCampo = sLinea.split(sSeparador);
				
				// Usamos el .trim() para eliminar los espacios y el toUpperCase() para hacer que todo sea mayuscula
				
				// .append(texto) para añadir algo al algo que ya esta creado
				
				Mapa.put(sCampo[0].trim().toUpperCase(),sCampo[1].trim().toUpperCase());
				sLinea = bufReader.readLine();
			}

			bufReader.close();
			fchReader.close();

		} catch (IOException e) {

			e.printStackTrace();
		}

		conn2.setsHost(Mapa.get("HOST"));
		conn2.setsPort(Mapa.get("PORT"));
		conn2.setsDbName(Mapa.get("DBNAME"));
		conn2.setsUserName(Mapa.get("USERNAME"));
		conn2.setsUserPass(Mapa.get("USERPASS"));
		
		return conn2;
	}

	private static Conexion leerConfiguracion(File Fichero) {

		Conexion conn2 = new Conexion();
		final String sSeparador = ":";

		try {
			FileReader fchReader = new FileReader(Fichero);
			BufferedReader bufReader = new BufferedReader(fchReader);

			conn2.setsHost(bufReader.readLine().split(sSeparador)[1]);
			conn2.setsPort(bufReader.readLine().split(sSeparador)[1]);
			conn2.setsDbName(bufReader.readLine().split(sSeparador)[1]);
			conn2.setsUserName(bufReader.readLine().split(sSeparador)[1]);
			conn2.setsUserName(bufReader.readLine().split(sSeparador)[1]);

			/*
			 * String sLinea; String[] aCampos;
			 * 
			 * sLinea = bufReader.readLine(); aCampos = sLinea.split(":");
			 * conn2.setsHost(aCampos[1]);
			 * 
			 * sLinea = bufReader.readLine(); aCampos = sLinea.split(":");
			 * conn2.setsHost(aCampos[1]);
			 * 
			 * sLinea = bufReader.readLine(); aCampos = sLinea.split(":");
			 * conn2.setsHost(aCampos[1]);
			 * 
			 * sLinea = bufReader.readLine(); aCampos = sLinea.split(":");
			 * conn2.setsHost(aCampos[1]);
			 */

			bufReader.close();
			fchReader.close();

		} catch (IOException e) {

			e.printStackTrace();
		}

		return conn2;
	}

}
