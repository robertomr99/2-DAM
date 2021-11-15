package main;

import model.Barberia;
import model.Barbero;
import model.Cliente;

public class Principal {

	public static void main(String[] args) {

		// Declaraci�n de variables

		final Integer iNumSillas = 4, iNumClientes = 5; // Constantes 

		Barberia oBarberia = new Barberia(iNumSillas);
		Barbero oBarbero = new Barbero(oBarberia);
		Cliente[] aClientes = new Cliente[iNumClientes];

		// Ejecuci�n

		oBarbero.start();
		
		System.out.println("            ------ EL BARBERO DORMIL�N -------");
		
		for (int iContador = 0; iContador < aClientes.length; iContador++) {
			aClientes[iContador] = new Cliente(oBarberia, iContador);
			aClientes[iContador].start();
		}

	}

}
