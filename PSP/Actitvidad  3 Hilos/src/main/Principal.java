package main;

import java.util.Scanner;

import model.Hilo;

public class Principal {

	public static void main(String[] args) {

		Scanner teclado = new Scanner(System.in);
		String sNombre;

		// Pedimos datos por teclado
		
		System.out.print("Nombre:");
		sNombre = teclado.nextLine();
		
		
		Hilo H1 = new Hilo(sNombre);
		
		H1.start();
		

	}

}
