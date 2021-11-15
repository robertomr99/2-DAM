package model;

public class Tenedor{

	public int iId;
	private boolean boCubierto = true;
	
	public Tenedor(int iId) {
		this.iId = iId;
	}
	
	public synchronized void tenedores(int iFilosofo) throws InterruptedException {
	
		while(boCubierto == true) {
			wait();
			System.out.println("Filosofo " + iFilosofo + " coge el tenedor " + iId);
			boCubierto = false;
		}
		
			
	}
	
	public synchronized void sueltaTenedores(int iFilosofo) {
		
			boCubierto = true;
			System.out.println("Filosofo " + iFilosofo + " suelta el tenedor " + iId);
			notify();
			
		}
	
}
