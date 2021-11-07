package ctrl;

import java.io.IOException;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import model.Ciudad;
import model.ComunidadAutonoma;
import model.Provincia;

public class GestionXML {

	private Document docXML;

	public GestionXML(String sFileName) {

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

	
	/// Solo devolvemos esta que tiene todo el contenido
	
 	public ArrayList<ComunidadAutonoma> getInfo() {

		return getCCAA();
	}

	
	// Ponemos todas estas funciones privadas para que no las pueda leer el usuario
	
	private ArrayList<ComunidadAutonoma> getCCAA() {
		ArrayList<ComunidadAutonoma> aCCAA = new ArrayList<ComunidadAutonoma>();

		// Extraemos a un nodo los elementos del XML cono nombre ccaa
		NodeList nNodos = docXML.getElementsByTagName("ccaa");

		for (int i = 0; i < nNodos.getLength(); i++) {
			// Convertimos el nodo en elemento para poder acceder a sus datos
			Element nodo = (Element) nNodos.item(i);

			String sId = nodo.getAttribute("id");
			String sNombre = nodo.getAttribute("nombre");
			ArrayList<Provincia> aProvincias = getProvincias(sId);

			aCCAA.add(new ComunidadAutonoma(sId, sNombre, aProvincias));

		}

		return aCCAA;
	}

	private ArrayList<Provincia> getProvincias(String sCCAAId) {
		ArrayList<Provincia> aProvincias = new ArrayList<Provincia>();

		NodeList nNodos = docXML.getElementsByTagName("provincia");

		for (int i = 0; i < nNodos.getLength(); i++) {
			// Convertimos el nodo en elemento para poder acceder a sus datos
			Element nodo = (Element) nNodos.item(i);

			String sCCAA = nodo.getAttribute("ccaa");
			String sID = nodo.getAttribute("id");
			String sNombreProvincia = nodo.getAttribute("nombre");
			ArrayList<Ciudad> aCiudades = getCiudades(sID);

			if (sCCAA.equals(sCCAAId)) {

				aProvincias.add(new Provincia(sNombreProvincia, sCCAA, sID, aCiudades));
			}

		}
		return aProvincias;
	}

	private ArrayList<Ciudad> getCiudades(String sProvinciaId) {
		ArrayList<Ciudad> aCiudades = new ArrayList<Ciudad>();

		NodeList nNodos = docXML.getElementsByTagName("ciudad");

		for (int i = 0; i < nNodos.getLength(); i++) {
			// Convertimos el nodo en elemento para poder acceder a sus datos
			Element nodo = (Element) nNodos.item(i);

			String sCapital = nodo.getAttribute("capital");
			String sNombreCiudad = nodo.getAttribute("nombre");
			int iTempMax = Integer.parseInt(nodo.getElementsByTagName("tmax").item(0).getTextContent());
			int iTempMin = Integer.parseInt(nodo.getElementsByTagName("tmin").item(0).getTextContent());
			String sCod_Ine = nodo.getAttribute("cod_ine");

			if (sCod_Ine.substring(0, 2).equals(sProvinciaId.substring(0, 2))) {
				aCiudades.add(new Ciudad(sNombreCiudad, sCapital, sCod_Ine, iTempMax, iTempMin));
			}

		}
		return aCiudades;
	}
}
