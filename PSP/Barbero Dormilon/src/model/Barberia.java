package model;

public class Barberia {

	private int iNumSillasEnEspera, iNumSillasEnEsperaOcupadas = 0;
	private boolean boSillaBarberoOcupada = false, boCorteFinalizado = false, boBarberoDuerme = false;

	public Barberia(int iNumSillasEnEspera) {
		this.iNumSillasEnEspera = iNumSillasEnEspera;
	}
	

	public synchronized boolean entrarBarberia(int iIdCliente) throws InterruptedException {
		
		if (iNumSillasEnEsperaOcupadas == iNumSillasEnEspera) {
				System.out.println("El cliente : " + iIdCliente + " se va sin tener cortado el pelo");
				return false;
		} else {
				iNumSillasEnEsperaOcupadas++;
				System.out.println("El cliente : " + iIdCliente + " pasa a sentarse en la silla de espera");
				while (boSillaBarberoOcupada) {
					wait();
				}
				iNumSillasEnEsperaOcupadas--;
				boSillaBarberoOcupada = true;
				boCorteFinalizado = false;

			if (boBarberoDuerme) {
				System.out.println("El cliente : " + iIdCliente + " despierta al Barbero de la silla");
				notifyAll();
			}

			System.out.println("El cliente : " + iIdCliente + "  pasa a sentarse a la silla del barbero para pelarse");
			while (!boCorteFinalizado) {
				wait();
			}

				boSillaBarberoOcupada = false;
	
				notifyAll();

		}
		return boBarberoDuerme;
	}

	public synchronized void esperarCliente() throws InterruptedException {

		boBarberoDuerme = true;
		while (!boBarberoDuerme) {
			System.out.println("\n*** El Barbero está esperando a algún cliente ***");
			wait();
		}
		boBarberoDuerme = false;
		System.out.println("\n*** El Barbero está cortandole el pelo a algún cliente ***\n");
	}

	public synchronized void corteFinalizado() {
		boCorteFinalizado = true;
		System.out.println("\n*** El Barbero ha finalizado de cortarle el pelo al cliente ***");
		notifyAll();
	}

	public int getiNumSillasEnEspera() {
		return iNumSillasEnEspera;
	}

	public void setiNumSillasEnEspera(int iNumSillasEnEspera) {
		this.iNumSillasEnEspera = iNumSillasEnEspera;
	}

}
