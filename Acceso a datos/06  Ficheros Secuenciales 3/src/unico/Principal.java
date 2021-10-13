package unico;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;
import model.Conexion;


public class Principal {

	public static void main(String[] args) {

		File nombreFchSource = new File("Conexion.cfg");
	
		Conexion conn = leerConfiguracion(nombreFchSource);
		
		

	}

	
	private static Conexion leerConfiguracion (File Fichero) {
		// Formar un objeto conexion con el fichero.
		return null;
	}


}
