package view;

import java.util.ArrayList;

import model.Estanquero;
import model.Fumador;

public class Principal extends Thread{

	public static void main(String[] args) {
		
		Fumador[] aFumador = new Fumador[3];
		Estanquero oEstanquero = new Estanquero ();
		for(int iContador = 0; iContador < aFumador.length; iContador++) {
			aFumador[iContador] = new Fumador(iContador, oEstanquero);
		}
		
		oEstanquero.start();
		
		for(int iContador = 0; iContador < aFumador.length; iContador++) {
			aFumador[iContador].start();
		}
	
	}

}
