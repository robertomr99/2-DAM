package Principal;

public class PrincipalRunnable implements Runnable {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		PrincipalRunnable R1 = new PrincipalRunnable();
		Thread T1 = new Thread(R1);
		T1.start();
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("Se acabó");
		
	}



}
