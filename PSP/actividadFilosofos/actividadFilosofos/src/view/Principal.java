package view;

import model.Filosofo;
import model.Tenedor;

public class Principal {

	public static void main(String[] args) {
		
		Tenedor[] oTenedores = new Tenedor[5];
		
		for(int iContador = 0; iContador < oTenedores.length; iContador++) {
			oTenedores[iContador] = new Tenedor(iContador);
		}
		
		Filosofo[] oFilosofos = new Filosofo[5];

		for(int iContador = 0; iContador < oFilosofos.length; iContador++) {
			oFilosofos[iContador] = new Filosofo (iContador,oTenedores[iContador], oTenedores[(iContador + 1 )%5]);
		}
		
		for(int iContador = 0; iContador < oFilosofos.length; iContador++) {
			oFilosofos[iContador].start();
		}
	}

}
