package ctrl;

import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class CtrlFrmPrincipal {

	public static int[][] mPosiciones = { { 0, 0, 0 }, { 0, 0, 0 }, { 0, 0, 0 } };
	public static final String sX = "Image/x.png", sCirculo = "Image/circulo.png";
	public static boolean boExito;
	public static int iContador;
	public static String sFicha;

	public static void Inicio() {
		elegirJugador();
		new view.FrmPrincipal();

	}
	
	public static boolean elegirJugador() {
		
		Random rAleatorio = new Random();
        int iRandom = rAleatorio.nextInt(2);

        System.out.println(iRandom);
        if(iRandom == 0) {
            boExito = true;
        }else {
            boExito = false;
        }
        return boExito;
    }

	public static String colocarFichas(int iContadorFila, int iContadorColumna) {

        if(iContador != 6) {
            if(boExito == true && mPosiciones[iContadorFila][iContadorColumna] == 0) {
                sFicha = sX;
                mPosiciones[iContadorFila][iContadorColumna] = 1;
                boExito = false;
            }else if(boExito == false && mPosiciones[iContadorFila][iContadorColumna] == 0){
                sFicha = sCirculo;
                mPosiciones[iContadorFila][iContadorColumna] = 2;
                boExito = true;
            }else {
                if(mPosiciones[iContadorFila][iContadorColumna] == 2) {
                    sFicha = sCirculo;
                }else {
                    sFicha = sX;
                }

            }
        }

        iContador++;

        return sFicha;
    }
	
	public static int contadorFichas() {
        return iContador;
    }
	
	public static void moverFicha(int iContadorFila, int iContadorColumna) {
		
		
		
		if(mPosiciones[iContadorFila][iContadorColumna] == 1) {
			if(mPosiciones[iContadorFila-1][iContadorColumna] == 0 ) {}
			mPosiciones[iContadorFila-1][iContadorColumna] = 1;
			mPosiciones[iContadorFila][iContadorColumna] = 0;
			
			
		}else {
			
		}
		
	}
	
/*	public static void moverFicha(int iContadorFila, int iContadorColumna) {
		if(mPosiciones[iContadorFila][iContadorColumna] == 1) {
			if(mPosiciones[iContadorFila-1][iContadorColumna] == 0 ) {}
			mPosiciones[iContadorFila-1][iContadorColumna] = 1;
			mPosiciones[iContadorFila][iContadorColumna] = 0;
			
			
		}else {
			
		}
		
	}
	*/

}
