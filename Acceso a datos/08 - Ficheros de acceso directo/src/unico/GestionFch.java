package unico;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

import model.Persona;

public class GestionFch {

	
	private RandomAccessFile fch;

	public GestionFch(String fileName) {
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

	public void escribirRegistro(int iNumReg, Persona oPersona) {

		try {
			Long lPosicion = getPosicion(iNumReg);
			fch.seek(getPosicion(iNumReg));

			// nombne

			String sNombre = oPersona.getsNombre();
			char chLetra;

			for (int i = 0; i < 5; i++) {

				chLetra = (i < sNombre.length()) ? sNombre.charAt(i) : ' ';

				fch.writeChar(chLetra);

			}

			// edad

			fch.writeInt(oPersona.getiEdad());

			// altura

			fch.writeDouble(oPersona.getdAltura());

		} catch (IOException e) {
			System.err.println("El fichero no es accesible");
		}

	}

	private long getPosicion(int iNumReg) {
		return (iNumReg - 1) * Persona.iLongReg;
	}

	public Persona leerRegistro(int iNumReg) {

		String sNombre = "";
		int iEdad = 0;
		double dAltura = 0.0;

		try {
			Long lPosicion = getPosicion(iNumReg);
			fch.seek(getPosicion(iNumReg));
			
			// Nombre
			for(int i = 0 ; i < Persona.iLongNombre; i++) {
				sNombre += fch.readChar();
			}			
			
			// Edad
				
			iEdad = fch.readInt();
			
			// Altura
		
			dAltura = fch.readDouble();		

		} catch (IOException e) {
			System.err.println("EL fichero no es accesible");
		}

		return new Persona(sNombre, iEdad, dAltura);
	}

}
