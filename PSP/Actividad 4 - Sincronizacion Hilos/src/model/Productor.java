package model;

public class Productor extends Thread{

	private int iDormir;
	private Almacen oAlmacen;

	public Productor(int iDormir, Almacen oAlmacen) {
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

		for (int i = 0; i < 10; i++) {
			oAlmacen.setiContenido(i);
			System.out.println("Productor pone el elemento: " + i + " en el almacén");
		}

		try {
			Thread.sleep(iDormir);
		} catch (Exception e) {

		}

	}

}
