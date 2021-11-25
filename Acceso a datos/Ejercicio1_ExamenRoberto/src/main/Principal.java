package main;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;

import model.Casa;

public class Principal {

	private static String fileName = "archivos/datos.dat";
	private static Document docXML;
	public static ArrayList<Casa> aCasasLleno = rellenarCasas();

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		inicio();
	}

	public static void inicio() throws Exception {
		writeData(fileName, rellenarCasas());
		crearArchivoXML(fileName);
	}

	public Principal(String sFileName) {

		try {
			docXML = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(sFileName);

			docXML.getDocumentElement().normalize();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	private static void crearArchivoXML(String sFileNameTabla) throws Exception {
		ArrayList<String> aColunmName = new ArrayList<String>();
		int iNReg = 0;

		iNReg = aCasasLleno.size();

		aColunmName.add("ID_CASA");
		aColunmName.add("POBLACION");
		aColunmName.add("SUPERFICIE");
		aColunmName.add("ASEOS");

		docXML = DocumentBuilderFactory.newInstance().newDocumentBuilder().getDOMImplementation().createDocument(null,
				"Casas", null);

		if (aColunmName != null) {

			for (int iContador = 0; iContador < iNReg; iContador++) {
				Element elemento = docXML.createElement("CASA");
				ArrayList<String> aInfRegTablas = new ArrayList<String>();
				aInfRegTablas.add(String.valueOf(aCasasLleno.get(iContador).getiId_Casa()));
				aInfRegTablas.add(String.valueOf(aCasasLleno.get(iContador).getsPoblacion()));
				aInfRegTablas.add(String.valueOf(aCasasLleno.get(iContador).getdSuperficie()));
				aInfRegTablas.add(String.valueOf(aCasasLleno.get(iContador).getiAseos()));

				Element NombreTag;
				Node valorTag;

				for (int iContador2 = 0; iContador2 < aColunmName.size(); iContador2++) {

					NombreTag = docXML.createElement(aColunmName.get(iContador2));
					valorTag = docXML.createTextNode(aInfRegTablas.get(iContador2));
					NombreTag.appendChild(valorTag);
					elemento.appendChild(NombreTag);
				}

				Node nRaiz = docXML.getFirstChild();
				nRaiz.appendChild(elemento);

			}
			saveData(sFileNameTabla);
		}
	}

	public static void saveData(String sNombreTabla) {

		try {
			Transformer tr = TransformerFactory.newInstance().newTransformer();
			tr.setOutputProperty(OutputKeys.INDENT, "yes");
			tr.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
			tr.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");

			tr.transform(new DOMSource(docXML), new StreamResult(new FileOutputStream(sNombreTabla + ".xml")));

		} catch (Exception e) {
			System.err.println("Error guardando " + sNombreTabla + ".xml\n" + e.getMessage());
		}

	}

	///////////////////////////////////////////////////////////////////////////////////////////////////

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

}