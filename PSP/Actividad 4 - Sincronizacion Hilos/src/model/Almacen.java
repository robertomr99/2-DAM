package model;

public class Almacen {

	
	private int iContenido;
	private boolean boDisponible = false;

	public Almacen() {
	}
	

	public synchronized int getiContenido() {
		
		while(boDisponible == false) {
		try {
			 wait();
		}catch(InterruptedException e) {}	
		}
		
		boDisponible = false;
		notify();
		return iContenido;
	}

	public synchronized void setiContenido(int iContenido) {
		
		
		while(boDisponible == true) {
		try {
			wait();
		}catch (InterruptedException e) {}
			
		}
		this.iContenido = iContenido;
		boDisponible = true;
		notify();
	}
	
	
	
}
