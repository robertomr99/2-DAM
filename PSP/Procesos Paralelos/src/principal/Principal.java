package principal;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// Declaración de variables

		Scanner teclado = new Scanner(System.in);
		int iNumero1, iNumero2, iNumero3, iNumero4;

		// Pedimos datos por teclado
		
		System.out.println("PROCESO 1:");		
		System.out.println("Dame el segundo número:");
		iNumero1 = teclado.nextInt();
		System.out.println("Dame el segundo número:");
		iNumero2 = teclado.nextInt();

		System.out.println("PROCESO 2:");
		System.out.println("Dame el primer número:");
		iNumero3 = teclado.nextInt();
		System.out.println("Dame el segundo número:");
		iNumero4 = teclado.nextInt();

		try {
			ejecutarClaseProceso(Sumador.class, iNumero1, iNumero2, iNumero3, iNumero4);
		} catch (IOException | InterruptedException ex) {
			System.err.println("Error: " + ex.toString());
			System.exit(-1);
		}
	}

	/**
	 * 
	 * @param clase
	 * @param n1
	 * @param n2
	 * @param n3
	 * @param n4
	 * @throws IOException
	 * @throws InterruptedException
	 */

	public static void ejecutarClaseProceso(Class clase, int n1, int n2, int n3, int n4)
			throws IOException, InterruptedException {
		
		// Defino donde está el home de java
		String javaHome = System.getProperty("java.home");
		// Defino donde está el bin de Java
		String javaBin = javaHome + File.separator + "bin" + File.separator + "java";
		// Defino el path de java
		String classpath = System.getProperty("java.class.path");
		// Obtengo el nombre canónico de la clase que se va a ejecutar
		String className = clase.getCanonicalName();
		// Creo el proceso a ejecutar

		ProcessBuilder builder1 = new ProcessBuilder(javaBin, "-cp", classpath, className, String.valueOf(n1),
				String.valueOf(n2));

		ProcessBuilder builder2 = new ProcessBuilder(javaBin, "-cp", classpath, className, String.valueOf(n3),
				String.valueOf(n4));

		// Ficheros de salida de los procesos

		File oFile1 = new File("Numero1.txt");
		File oFile2 = new File("Numero2.txt");
		
		
		// Redirigimos el resultado del proceso a ficheros

		builder1.redirectOutput(oFile1);
		builder2.redirectOutput(oFile2);

		Process process1 = builder1.start();
		Process process2 = builder2.start();
			
		// Espero a que se ejecute el proceso

		process1.waitFor();
		process2.waitFor();
		
		
		// Leemos ambos ficheros y devolvemos la suma de los valores de estos

		BufferedReader BufReader1 = new BufferedReader(new FileReader(oFile1));
		String sLinea1 = BufReader1.readLine();

		BufferedReader BufReader2 = new BufferedReader(new FileReader(oFile2));
		String sLinea2 = BufReader2.readLine();

		System.out.println(Integer.parseInt(sLinea1) + Integer.parseInt(sLinea2));
	}

}
