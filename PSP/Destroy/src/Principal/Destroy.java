package Principal;

import java.io.IOException;
import java.util.Scanner;

public class Destroy {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String RUTA_PROCESO = "C:\\Program Files\\Google\\Chrome\\Application\\chrome.exe";

		ProcessBuilder pb = new ProcessBuilder(RUTA_PROCESO);
		Scanner teclado = new Scanner(System.in);

		try {

			Process process = pb.start();
			System.out.println("¿Terminar el proceso? (S/N)");
			if (teclado.nextLine().toUpperCase().charAt(0) == 'S') {
				process.destroy();
			}

		} catch (IOException ex) {
			System.err.println("Error: " + ex.toString());
			System.exit(-1);
		}

	}
}
