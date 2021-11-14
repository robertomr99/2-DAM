package model;

import java.util.ArrayList;
import java.util.Random;

public class Estanquero extends Thread{

	private Random r = new Random();
	private boolean boFumando = false;
	private boolean boIngrePuesto = false;
	
	private int iIngrediente;
	
	public Estanquero() {
	}
	
	public void run() {
		
		while(true) {
			int iIngrediente = r.nextInt(3);
			try {
				sleep(r.nextInt(300));
				nuevoIngrediente(iIngrediente);
			}catch (InterruptedException e){
				e.printStackTrace();
			}
		}
		
		
	}
	
	public synchronized void nuevoIngrediente(int iIngrediente) throws InterruptedException {
		
		while(boIngrePuesto || boFumando)
			
			wait();
			
			this.iIngrediente = iIngrediente;
			boIngrePuesto = true;
			System.out.println("el estanquero no pone el ingrediente " + iIngrediente);
			
			notifyAll();
	
		
	}
	
	public synchronized void quieroFumar(int iIngredienteFumador) throws InterruptedException {
		
		while(!boIngrePuesto || boFumando || iIngrediente != iIngredienteFumador)
			wait();
			System.out.println("el fumador" + iIngredienteFumador + " empieza a fumar");
			boIngrePuesto = false;
			boFumando = true;
		
	}
	
	public synchronized void finFumar(int iIngredienteFumador) throws InterruptedException {
		boFumando = false;
		System.out.println("el fumador " + iIngredienteFumador + " termina de fumar");
		notifyAll();
		
	}
}









