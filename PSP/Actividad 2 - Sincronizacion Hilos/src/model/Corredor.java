package model;

public class Corredor implements Runnable{
	
	private String sNombre;
	
	public Corredor(String sNombre) {
		this.sNombre = sNombre;
	}

	public String getsNombre() {
		return sNombre;
	}

	public void setsNombre(String sNombre) {
		this.sNombre = sNombre;
	}

	@Override
	public void run() {
	int iContador = 0;
		
		for(iContador = 0 ; iContador < 11 ; iContador ++) {
			System.out.println("El corredor " + sNombre +" lleva " + iContador +" km.");
		}
		
		if(iContador == 11) {
			System.out.println("----- EL CORREDOR "+sNombre+" LLEGÓ A LA META -----");			
		}
			
	}
	
	

}
