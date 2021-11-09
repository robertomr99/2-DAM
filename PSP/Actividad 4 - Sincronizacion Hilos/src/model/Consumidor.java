package model;

public class Consumidor extends Thread{
	
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
		int iValor = 0;
		
		for(int i = 0 ; i < 10 ; i ++) {
			iValor = oAlmacen.getiContenido();
			System.out.println("El consumidor saca el elemento: "+iValor + " del almacén");
		}
		
		try {
			Thread.sleep(iDormir);
		}catch(Exception e) {
		e.printStackTrace();	
		}
		
	}
	
	
	

}
