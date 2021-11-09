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
		int iTiempo =oCliente.getaProductos()[0] + oCliente.getaProductos()[1] + oCliente.getaProductos()[2];
		long lHoraPC = System.currentTimeMillis();
		int iTiempoTotal = (int) ((lHoraPC - iTiempo)/1000); 

		System.out.println(sNombreCajera + " comienza a pasar la compra del cliente "
				+ oCliente.getsNombreCliente());

		for (int i = 0; i < oCliente.getaProductos().length; i++) {
			System.out.println(sNombreCajera + " ha pasado el producto " + i + " del cliente "
					+ oCliente.getsNombreCliente() + " y ha tardado " + oCliente.getaProductos()[i]);
		}

		System.out.println("La cajera " + sNombreCajera + " ha terminado con el cliente " + oCliente.getsNombreCliente() + " y ha tardado " + iTiempoTotal);
	}

}
