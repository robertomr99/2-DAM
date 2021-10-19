package principal;

import java.io.IOException;
import java.util.ArrayList;

public class main {

	public static void main(String[] args) {

		String sPrograma = "notepad ", sRuta = "C:\\Users\\Usuario\\Documents\\Documento";
		
/*		ProcessBuilder pb = new ProcessBuilder(sPrograma, sRuta);
		
		try {
			Process process = pb.start();
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}
	
	*/
		try {
			Process p = Runtime.getRuntime().exec(sPrograma + sRuta); // Tenemos que dejar un espacio al final o al principio de una de las cadenas
		} catch(IOException e) {
			e.printStackTrace();
		}
		
}
}
