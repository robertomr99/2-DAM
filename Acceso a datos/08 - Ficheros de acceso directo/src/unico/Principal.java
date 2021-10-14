package unico;

import model.Persona;

public class Principal {

	public static void main(String[] args) {
		
		GestionFch gest = new GestionFch("datos.db");
		
		
//		gest.escribirRegistro(1, new Persona("Pepe",45,1.68));
//		gest.escribirRegistro(2, new Persona("Juan",27,1.75));
		
		
		
		Persona p2 = gest.leerRegistro(1);
		System.out.println(p2);
		
		gest.cerrarFichero();
		
		System.out.println("Fin del programa");

		
		
	}

}
