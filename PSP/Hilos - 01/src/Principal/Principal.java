package Principal;

public class Principal extends Thread{

	public static void main (String[] args) {
		// TODO Auto-generated method stub
		
		Principal P1 = new Principal();	
		P1.start();
	}
	
	public void run() {		
		System.out.println("Un saludo");
	}
}
