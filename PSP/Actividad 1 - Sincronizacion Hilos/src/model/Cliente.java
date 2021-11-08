package model;

public class Cliente implements Runnable {
	
	private String sNombreCliente;
	private int [] aProductos;
	
	public Cliente(String sNombreCliente, int[] aProductos) {
		super();
		this.sNombreCliente = sNombreCliente;
		this.aProductos = aProductos;
	}

	public String getsNombreCliente() {
		return sNombreCliente;
	}
	
	public void setsNombreCliente(String sNombreCliente) {
		this.sNombreCliente = sNombreCliente;
	}

	public int[] getaProductos() {
		return aProductos;
	}

	public void setaProductos(int[] aProductos) {
		this.aProductos = aProductos;
	}

	@Override
	public void run() {
	
		
		
		
	}

	
	
	
	
	

}
