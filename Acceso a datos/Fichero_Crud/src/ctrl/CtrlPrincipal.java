package ctrl;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import model.Empleado;

public class CtrlPrincipal {

	public static RandomAccessFile fch;
	
	
	public CtrlPrincipal (String fileName) {
		abrirFichero(fileName);
	}
	
	
	
	private void abrirFichero(String fileName) {
		try {

			fch = new RandomAccessFile(fileName, "rw"); // r -> Lectura / w -> Escritura / rw -> Lectura/Escritura

		} catch (FileNotFoundException e) {
			System.err.println("El fichero " + fileName + " no existe");	

		}

	}

	public void cerrarFichero() {
		try {
			fch.close();
		} catch (IOException e) {
			System.err.println("No se ha podido cerrar el fichero");
		}
	}

	public static void escribirRegistro(int iNumReg, Empleado oEmpleado) {

		try {
			Long lPosicion = getPosicion(iNumReg);
			fch.seek(lPosicion);

			// sNombne

			String sNombre = oEmpleado.getsNombre();
			char chLetra;

			for (int i = 0; i < Empleado.iLongNombre; i++) {
				chLetra = (i < sNombre.length()) ? sNombre.charAt(i) : ' ';
				fch.writeChar(chLetra);
			}

			// sApellidos
			String sApellidos = oEmpleado.getsApellidos();

			for (int i = 0; i < Empleado.iLongApellidos; i++) {
				chLetra = (i < sApellidos.length()) ? sApellidos.charAt(i) : ' ';
				fch.writeChar(chLetra);
			}

			// sEmail

			String sEmail = oEmpleado.getsEmail();

			for (int i = 0; i < Empleado.iLongEmail; i++) {
				chLetra = (i < sEmail.length()) ? sEmail.charAt(i) : ' ';
				fch.writeChar(chLetra);
			}

			// iEdad

			fch.writeInt(oEmpleado.getiEdad());

			// lTelefono

			fch.writeLong(oEmpleado.getlTelefono());

			// dSueldo

			fch.writeDouble(oEmpleado.getdSueldo());

		} catch (IOException e) {
			System.err.println("El fichero no es accesible");
		}

	}

	private static long getPosicion(int iNumReg) {
		return (iNumReg - 1) * Empleado.iLongReg;
	}

	
	public static Empleado leerRegistro(int iNumReg) {
		String sNombre = "", sApellidos = "", sEmail = "";
		int iEdad = 0;
		long lTelefono = 0;
		double dSueldo = 0.0;

		try {
			Long lPosicion = getPosicion(iNumReg);
			fch.seek(lPosicion);

			// sNombre
			for (int i = 0; i < Empleado.iLongNombre; i++) {
				sNombre += fch.readChar();
			}

			// sApellidos
			for (int i = 0; i < Empleado.iLongApellidos; i++) {
				sApellidos += fch.readChar();
			}

			// sEmail
			for (int i = 0; i < Empleado.iLongEmail; i++) {
				sEmail += fch.readChar();
			}

			// iEdad

			iEdad = fch.readInt();

			// lTelefono

			lTelefono = fch.readLong();

			// dSueldo

			dSueldo = fch.readDouble();

		} catch (IOException e) {
			System.err.println("El fichero no es accesible");
		}

		return new Empleado(sNombre, sApellidos, sEmail, iEdad, lTelefono, dSueldo);
	}
	
	
	public static Empleado leerTodo() {
		String sNombre = "", sApellidos = "", sEmail = "";
		int iEdad = 0;
		long lTelefono = 0;
		double dSueldo = 0.0;

		try {


			// sNombre
			for (int i = 0; i < Empleado.iLongNombre; i++) {
				sNombre += fch.readChar();
			}

			// sApellidos
			for (int i = 0; i < Empleado.iLongApellidos; i++) {
				sApellidos += fch.readChar();
			}

			// sEmail
			for (int i = 0; i < Empleado.iLongEmail; i++) {
				sEmail += fch.readChar();
			}

			// iEdad

			iEdad = fch.readInt();

			// lTelefono

			lTelefono = fch.readLong();

			// dSueldo

			dSueldo = fch.readDouble();

		} catch (IOException e) {
			System.err.println("El fichero no es accesible");
		}

		return new Empleado(sNombre, sApellidos, sEmail, iEdad, lTelefono, dSueldo);
	}
	
	
	public static int buscarPosicion() throws IOException {
		int iLongitud = (int) (fch.length() / Empleado.iLongReg);
		return iLongitud + 1;
	}
	
}
