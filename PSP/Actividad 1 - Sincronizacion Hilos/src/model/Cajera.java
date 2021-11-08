package model;

public class Cajera implements Runnable {

	private String sNombreCajera;
	private Cliente oCliente;

	public Cajera(String sNombreCajera, Cliente oCliente) {
		this.sNombreCajera = sNombreCajera;
		this.oCliente = oCliente;
	}
	
	public Cliente getoCliente() {
		return oCliente;
	}

	public void setoCliente(Cliente oCliente) {
		this.oCliente = oCliente;
	}

	@Override
	public void run() {

		System.out.println("La cajera " + sNombreCajera + " comienza a pasar la compra del cliente "
				+ oCliente.getsNombreCliente());

		for (int i = 0; i < oCliente.getaProductos().length; i++) {
			System.out.println("La cajera " + sNombreCajera + " ha pasado el producto " + i + "del cliente"
					+ oCliente.getsNombreCliente() + "y ha tardado " + oCliente.getaProductos()[i]);
		}
	}

}
