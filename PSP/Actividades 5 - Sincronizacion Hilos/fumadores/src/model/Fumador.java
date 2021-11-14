package model;

public class Fumador extends Thread{


	private int iIngrediente;
	private Estanquero oEstanquero;


	public Fumador(int iIngrediente, Estanquero oEstanquero) {
		this.iIngrediente = iIngrediente;
		this.oEstanquero = oEstanquero;
	}

	public int getiIngrediente() {
		return iIngrediente;
	}

	public void setiIngrediente(int iIngrediente) {
		this.iIngrediente = iIngrediente;
	}

	public Estanquero getoEstanquero() {
		return oEstanquero;
	}

	public void setoEstanquero(Estanquero oEstanquero) {
		this.oEstanquero = oEstanquero;
	}

	public void run() {
		
		while(true) {
		
			try {
				oEstanquero.quieroFumar(iIngrediente);
				
				sleep(300);
				
				oEstanquero.finFumar(iIngrediente);
				
				sleep(500);
				
			}catch(InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
