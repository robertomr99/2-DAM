package ctrl;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class CtrlFrmPrincipal {

	public static int[][] mPosiciones = { { 0, 0, 0 }, { 0, 0, 0 }, { 0, 0, 0 } };
	public static final String sX = "Image/x.png", sCirculo = "Image/circulo.png";
	public static boolean boExito;

	public static void Inicio() {
		elegirJugador();
		new view.FrmPrincipal();

	}

	public static boolean elegirJugador() {
		int iRandom = (int) Math.random() * (0 + 1) + 1;

		if (iRandom == 0) {
			boExito = false;
		} else {
			boExito = true;
		}
		return boExito;
	}

	public static String pintarLabel() {
		String sImagen = "";
		if (boExito == false) {
			sImagen = sX;
			boExito = true;
		} else {
			sImagen = sCirculo;
			boExito = false;
		}
		return sImagen;
	}

	public static void comprobar(JLabel label, int X, int Y) {

		if (mPosiciones[X][Y] == 0) {
			if (label.getIcon().toString() == sX) {
				mPosiciones[X][Y] = 1;
			} else {
				mPosiciones[X][Y] = 2;
			}
		}
	}

}
