package model;

public class Consumidor implements Runnable {
	
	private int iDormir;
	private Almacen oAlmacen;
	
	public Consumidor(int iDormir, Almacen oAlmacen) {
		this.iDormir = iDormir;
		this.oAlmacen = oAlmacen;
	}
	
	public int getiDormir() {
		return iDormir;
	}
	public void setiDormir(int iDormir) {
		this.iDormir = iDormir;
	}
	public Almacen getoAlmacen() {
		return oAlmacen;
	}
	public void setoAlmacen(Almacen oAlmacen) {
		this.oAlmacen = oAlmacen;
	}
	
	
	@Override
	public void run() {
		
		for(int i = 0 ; i < 10 ; i ++) {
			System.out.println("El consumidor saca el elemento: "+oAlmacen.getiContenido()+ " del almacén");
		}
		
		try {
			Thread.sleep(iDormir);
		}catch(Exception e) {
		e.printStackTrace();	
		}
		
	}
	
	
	

}
