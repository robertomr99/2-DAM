package view;

import java.util.ArrayList;

import ctrl.GestionFchXML;
import model.Jugador;

public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String sFileName = "archivos/datos.xml";

		GestionFchXML fchXML = new GestionFchXML(sFileName);

		fchXML.addJugador(new Jugador(1122, 145, "Pedro", "Mongo Rico", "Perico"));
		
		fchXML.mostrarDocumento();
		
		fchXML.saveData();

		// fchXML.mostrarDocumento();

		/*
		 * ArrayList<Jugador> aJugadores = fchXML.getJugadores();
		 * 
		 * for(Jugador j : aJugadores) { System.out.println(j); }
		 * 
		 */

	}

}
