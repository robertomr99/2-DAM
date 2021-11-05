package ctrl;

public class CtrlFrmPrincipal {

	public static int[][] mPosiciones = { { 0, 0, 0 }, { 0, 0, 0 }, { 0, 0, 0 } };
	public static final String sX = "Image/x.png", sCirculo = "Image/circulo.png";

	public static void Inicio() {
		new view.FrmPrincipal();
	}

	public static boolean elegirJugador() {
		boolean boExito;

		int iRandom = (int) Math.random() * (0 + 1) + 1;

		if (iRandom == 0) {
			boExito = false;
		} else {
			boExito = true;
		}
		return boExito;
	}
}
