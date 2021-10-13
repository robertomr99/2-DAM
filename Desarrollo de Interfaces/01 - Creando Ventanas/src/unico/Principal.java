package unico;

import java.awt.Frame;

public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//test1();
		test2();

	}

	private static void test1() {
		crearVentana("Primera", 400, 100);
		/*crearVentana("Segunda", 200, 100);
		crearVentana("Tercera", 400, 200);*/
	}

	private static void test2() {
		MiVentana V = new MiVentana();
	}

	private static void crearVentana(String sTitulo, int iAncho, int iAlto) {

		Frame ventana = new Frame();

		// Frame ventana = new Frame("Esto es el titulo de mi ventana");

		ventana.setSize(iAncho, iAlto); // Tamaño
		ventana.setLocation(0, 0); // Posicion (x, y)

		// ventana.setBounds( 0, 0, iAncho, iAlto); // Posicion (x, y) y Tamaño
		ventana.setTitle("Esto es el titulo de mi ventana");
		// podemos asignar desde aqui el titulo o desde el constructor de la ventana */

		ventana.setVisible(true);

	}

}
