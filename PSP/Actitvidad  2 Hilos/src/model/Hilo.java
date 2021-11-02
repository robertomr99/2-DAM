package model;

public class Hilo extends Thread {

	private String sNombre, sDia;
	private double dHora;

	public Hilo(String sNombre, String sDia, double dHora) {
		this.sNombre = sNombre;
		this.sDia = sDia;
		this.dHora = dHora;
	}

	public void run() {

		String str = String.valueOf(dHora);

		int intNumber = Integer.parseInt(str.substring(0, str.indexOf('.')));
		int decNumberInt = Integer.parseInt(str.substring(str.indexOf('.') + 1));

		if (intNumber == 8 && decNumberInt < 30) {
			System.out.println("El alumnno " + sNombre + " llegó a tiempo para tomarse la temperatura el día " + sDia);
		} else {
			System.out
					.println("El alumnno " + sNombre + " no llegó a tiempo para tomarse la temperatura el día " + sDia);
		}
	}
}
