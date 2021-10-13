package model;

import java.util.ArrayList;

public class Languages {

	public static ArrayList<String> aRespuesta = new ArrayList<String>();
	public static ArrayList<String> aPregunta = new ArrayList<String>();

	public static ArrayList<String> aENG = new ArrayList<String>();
	public static ArrayList<String> aESP = new ArrayList<String>();

	public static ArrayList<String> aENGpalabras = new ArrayList<String>();
	public static ArrayList<String> aESPpalabras = new ArrayList<String>();

	public static void cargarLenguajes() {
		
		int iCast = Integer.parseInt(view.FrmConfig.txtNumeroPalabra.getText());
		String sPalabraEsp, sPalabraIng;

		aENG.add("DOG");
		aENG.add("CAT");
		aENG.add("PARROT");
		aENG.add("SISTER");
		aENG.add("BROTHER");
		aENG.add("PURPLE");
		aENG.add("YELLOW");
		aENG.add("BALL");
		aENG.add("WINDOW");
		aENG.add("DOOR");

		aESP.add("PERRO");
		aESP.add("GATO");
		aESP.add("LORO");
		aESP.add("HERMANA");
		aESP.add("HERMANO");
		aESP.add("MORADO");
		aESP.add("AMARILLO");
		aESP.add("PELOTA");
		aESP.add("VENTANA");
		aESP.add("PUERTA");


		for (int iContador = 0; iContador < iCast; iContador++) {
			sPalabraEsp = aESP.get(iContador);
			aESPpalabras.add(sPalabraEsp);

			sPalabraIng = aENG.get(iContador);
			aENGpalabras.add(sPalabraIng);
		}

	}

	public static void ESP_ING() {
		aPregunta.addAll(aESPpalabras);
		aRespuesta.addAll(aENGpalabras);
	}

	public static void ING_ESP() {
		aPregunta.addAll(aENGpalabras);
		aRespuesta.addAll(aESPpalabras);
	}

	public static void Indiferente() {
		aPregunta.addAll(aESPpalabras);
		aPregunta.addAll(aENGpalabras);
		aRespuesta.addAll(aESPpalabras);
		aRespuesta.addAll(aENGpalabras);

	}

}
