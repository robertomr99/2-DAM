package main;

import java.util.Scanner;

import model.Hilo;

public class Principal {

	public static void main(String[] args) {

		Scanner teclado = new Scanner(System.in);
		String sNombre, sDia;
		double dHora;

		// Pedimos datos por teclado
		
		System.out.print("Nombre:");
		sNombre = teclado.nextLine();
		System.out.print("Día:");
		sDia = teclado.nextLine();
		System.out.print("Hora:");
		dHora = teclado.nextDouble();
		
		
		Hilo H1 = new Hilo(sNombre, sDia, dHora);
		
		H1.start();
		

	}

}
