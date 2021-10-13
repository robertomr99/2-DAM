package unico;

import java.awt.*;

public class MiVentana extends java.awt.Frame {

	public MiVentana() { // Constructor 
		
		//Color fondoVentana = Color.blue;
		 Color textoError = Color.red;
		Color textoNormal = Color.black;
		
		// new Color (R,G,B)
		
		Color fondoVentanaRGB = new Color( 255, 100, 20);
	
		setTitle("Ejemplo por herencia");
		// setBounds(100, 100, 600, 400);

		// Con esto conseguiremos que la ventana aparezca en el centro de la pantalla
		
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

		int iAncho = 600;
		int iAlto = 400;
		int x = (screenSize.width - iAncho) / 2;
		int y = (screenSize.height - iAlto) / 2;
		
		setBounds(x, y, iAncho, iAlto);

		setVisible(true);
		setBackground(fondoVentanaRGB);
		// setForeground();
	}

}
