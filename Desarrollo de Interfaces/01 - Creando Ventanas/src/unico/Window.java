package unico;

public class Window extends java.awt.Frame {

	public static void main(String[] args) {

		Window miApp = new Window(); // Creamos un objetos Frame dentro de la misma clase
		miApp.inicializarComponentes();

		System.out.println("Todo Ok");
	}

	private void inicializarComponentes() {
		setBounds(100, 100, 600, 400);
		setVisible(true);

	}
}
