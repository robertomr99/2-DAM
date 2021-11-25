package main;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.sql.Statement;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;

import model.Casa;

public class Principal {

	private static String fileName = "archivos/datos.dat";
	private static Document docXML;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		writeData(fileName, rellenarCasas());
		leerArrayObjetos(fileName);
	}

	public static ArrayList<Casa> rellenarCasas() {
		ArrayList<Casa> aCasas = new ArrayList<Casa>();

		aCasas.add(new Casa(1, "Sevilla", 2, 100.5));
		aCasas.add(new Casa(2, "Madrid", 3, 150.2));
		aCasas.add(new Casa(3, "Cádiz", 2, 110.6));

		return aCasas;
	}

	public static void writeData(String fileName, ArrayList<Casa> aCasas) {

		try {
			ObjectOutputStream buff = new ObjectOutputStream(new FileOutputStream(fileName));

			for (Casa c : aCasas) {
				buff.writeObject(c);
			}

			buff.close();
		} catch (FileNotFoundException e) {
			System.err.println("ERROR: " + fileName + " no existe.");

		} catch (IOException e) {
			System.err.println("ERROR: No se puede escribir del fichero.");
		}
	}

	/////////////////////////////////////////////////////////////////

	public static void insertarCasas(ArrayList<Casa> aCasas) throws Exception {
		dbms.DBoracle.openConn();
		Statement stmt = dbms.DBoracle.getConn().createStatement();

		for (Casa oCasa : aCasas) {
			stmt.executeUpdate("INSERT INTO CASA " + "VALUES (" + oCasa.getiId_Casa() + ",'" + oCasa.getsPoblacion()
					+ "'," + oCasa.getiAseos() + "," + oCasa.getdSuperficie() + " )");
		}

		dbms.DBoracle.desconectar();
	}

	public static ArrayList<Casa> leerArrayObjetos(String fileName) {
		ArrayList<Casa> aCasasLeido = new ArrayList<Casa>();

		try {
			ObjectInputStream buff = new ObjectInputStream(new FileInputStream(fileName));

			aCasasLeido =  (ArrayList<Casa>) buff.readObject();

			for (Casa c : aCasasLeido) {
				System.out.println(c);
			}
			
			buff.close();

		}catch(Exception e) {
			e.printStackTrace();
			e.getMessage();		
	/*	} catch (FileNotFoundException e) {
			System.err.println("ERROR: " + fileName + " no existe.");
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			System.err.println("ERROR: el fichero no contiene un coche.");
		}*/
		}
		
		return aCasasLeido;
	}

}