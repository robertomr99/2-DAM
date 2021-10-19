package view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import model.Empleado;

public class viewEmpleado {
	public static InputStreamReader isr = new InputStreamReader(System.in);
	public static BufferedReader teclado = new BufferedReader(isr);
	public static Empleado oEmpleado = new Empleado();

	public static void Crud_Empleado() throws IOException {

		byte bOpcion;
		String sLineaLeida = "";

		do {

			System.out.println("\nCRUD\n");
			System.out.println("1.Listar Todo");
			System.out.println("2.Buscar por posición");
			System.out.println("3.Modificar");
			System.out.println("4.Añadir");
			System.out.println("0.Salir\n");

			System.out.println("Elige una opción: ");

			try {
				sLineaLeida = teclado.readLine();
			} catch (IOException e) {

				e.printStackTrace();
			}

			bOpcion = Byte.parseByte(sLineaLeida);

			switch (bOpcion) {

			case 1:
				listarTodo();
				break;
			case 2:
				oEmpleado = ctrl.CtrlPrincipal.leerRegistro(pedirPosicion());
				System.out.println(oEmpleado);
				break;
			case 3:
				listarTodo();
				ctrl.CtrlPrincipal.escribirRegistro(pedirPosicion(), agregarEmpleado());
				break;
			case 4:
				ctrl.CtrlPrincipal.escribirRegistro(ctrl.CtrlPrincipal.buscarPosicion(), agregarEmpleado());
				break;
			case 0:
				System.exit(0);
				break;

			}
			ctrl.CtrlPrincipal.fch.seek(0);
		} while (bOpcion != 0);

	}

	public static Empleado agregarEmpleado() {
		String sNombre = "", sApellidos = "", sEmail = "", sEdad = "", sTelefono = "", sSueldo = "";

		System.out.println("Introduce los datos:");
		try {
			System.out.print("Nombre: ");
			sNombre = teclado.readLine();
			System.out.print("Apellidos: ");
			sApellidos = teclado.readLine();
			System.out.print("Email: ");
			sEmail = teclado.readLine();
			System.out.print("Edad: ");
			sEdad = teclado.readLine();
			System.out.print("Teléfono:  ");
			sTelefono = teclado.readLine();
			System.out.print("Sueldo: ");
			sSueldo = teclado.readLine();

		} catch (IOException e) {
			e.printStackTrace();
		}

		return new Empleado(sNombre, sApellidos, sEmail, Integer.parseInt(sEdad), Long.parseLong(sTelefono),
				Double.parseDouble(sSueldo));

	}

	public static byte pedirPosicion() {
		String sLineaLeida = "";
		byte bPosicion;

		System.out.print("Dame la posición que quieres reflejar en el archivo: ");

		try {
			sLineaLeida = teclado.readLine();
		} catch (IOException e) {

			e.printStackTrace();
		}

		return bPosicion = Byte.parseByte(sLineaLeida);
	}
	
	public static void listarTodo() {
		int i = 0;
		try {
			for (i = 0; i < ctrl.CtrlPrincipal.fch.length(); i += Empleado.iLongReg) {
				view.viewEmpleado.oEmpleado = ctrl.CtrlPrincipal.leerTodo();
				System.out.println(view.viewEmpleado.oEmpleado);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
