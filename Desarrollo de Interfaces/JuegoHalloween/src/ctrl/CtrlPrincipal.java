package ctrl;

import java.util.ArrayList;

public class CtrlPrincipal {

	public static ArrayList<String> aImagenes = new ArrayList<String>();

	public static int iNumRandom;
	public static int max = aImagenes.size();
	public static int iRandom;
	public static int omitir[];

	public static void cargarImagenes() {
		aImagenes.add("Images/dracula.png");
		aImagenes.add("Images/cemetery.png");
		aImagenes.add("Images/revolver.png");
		aImagenes.add("Images/sun.png");
		aImagenes.add("Images/bat.png");
		aImagenes.add("Images/garlic.png");
		aImagenes.add("Images/pumpkin.png");
		aImagenes.add("Images/religion.png");
		aImagenes.add("");
		aImagenes.add("");
	}

	public static String imagenAleatoria() {
		if (view.FrmPrincipal.boDracula == false) {
			iNumRandom = (int) (Math.random() * (aImagenes.size() - 0) + 0);
		}
		if (view.FrmPrincipal.boDracula == true) {
			aImagenes.remove(iNumRandom);
			view.FrmPrincipal.boDracula = false;
			iNumRandom = (int) (Math.random() * (aImagenes.size() - 0) + 0);
		}
		return aImagenes.get(iNumRandom);
	}

}
