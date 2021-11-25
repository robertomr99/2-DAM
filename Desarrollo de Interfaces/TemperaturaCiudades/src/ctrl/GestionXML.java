package ctrl;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import javax.swing.JComboBox;
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

	private static Document docXML;
	public static File fileCCAA;
	public static GestionXML fchXML = new GestionXML("Ficheros/aemet.xml");

	public static String sFecha = "";

	public static void inicio() throws Exception {
		sFecha = devolverFecha();
		download_AEMET(sFecha);
		rellenarCCAA(ctrl.GestionXML.fchXML);
		new view.FrmPrincipal();
	}

	public static void rellenarCCAA(GestionXML fchXML) {
		// jcomboBox.removeAllItems();

		try {
			for (ComunidadAutonoma CCAA : fchXML.getInfo()) {
				view.FrmPrincipal.comboBoxComunidad.addItem(CCAA.getsNombreComunidad());
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void rellenarCiudades(Provincia p) {
		view.FrmPrincipal.comboBoxCiudad.removeAllItems();

		System.out.println(p.getaCiudades());

		try {
			for (Ciudad c : p.getaCiudades()) {
				view.FrmPrincipal.comboBoxCiudad.addItem(c.getsNombreCiudad());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void rellenarProvincias(ComunidadAutonoma CCAA) {
		view.FrmPrincipal.comboBoxProvincia.removeAllItems();
		try {

			for (Provincia p : CCAA.getaProvincias()) {
				view.FrmPrincipal.comboBoxProvincia.addItem(p.getsNombreProvincia());
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static String devolverFecha() {
		String sHoy = "";

		try {
			DateTimeFormatter dft = DateTimeFormatter.ofPattern("yyyy-MM-dd");

			sHoy = dft.format(LocalDateTime.now());

		} catch (Exception e) {
			e.printStackTrace();
		}
		return sHoy;
	}

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

	public static ArrayList<ComunidadAutonoma> getInfo() {

		return getCCAA();
	}

	// Ponemos todas estas funciones privadas para que no las pueda leer el usuario

	public static ArrayList<ComunidadAutonoma> getCCAA() {
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

	public static ArrayList<Provincia> getProvincias(String sCCAAId) {
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

	public static ArrayList<Ciudad> getCiudades(String sProvinciaId) {
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

	private static void download_AEMET(String sFecha) throws Exception {

		String sUrl = "http://www.aemet.es/es/api-eltiempo/temperaturas/" + sFecha + "/PB";
		String sName = "aemet.xml";
		String sFolder = "Ficheros/";

		fileCCAA = new File(sFolder + sName);
		URLConnection conn = new URL(sUrl).openConnection();
		conn.connect();

		InputStream in = conn.getInputStream();
		OutputStream out = new FileOutputStream(fileCCAA);

		int b = 0;
		while (b != -1) {
			b = in.read();
			if (b != -1) {
				out.write(b);
			}
		}
		out.close();
		in.close();
	}

	public static void listenerCCAA() {
		view.FrmPrincipal.sCCAA = view.FrmPrincipal.comboBoxComunidad.getSelectedItem().toString();
		for (int i = 0; i < view.FrmPrincipal.aCCAA.size(); i++) {
			if (view.FrmPrincipal.aCCAA.get(i).getsNombreComunidad().equals(view.FrmPrincipal.sCCAA)) {
				view.FrmPrincipal.CCAA = view.FrmPrincipal.aCCAA.get(i);
			}
		}
		view.FrmPrincipal.aP = GestionXML.getProvincias(view.FrmPrincipal.CCAA.getsId());
		ctrl.GestionXML.rellenarProvincias(view.FrmPrincipal.CCAA);

	}

	public static void listenerProvincia() {
		view.FrmPrincipal.sProvincia = view.FrmPrincipal.comboBoxProvincia.getSelectedItem().toString();
		for (int i = 0; i < view.FrmPrincipal.aP.size(); i++) {
			if (view.FrmPrincipal.aP.get(i).getsNombreProvincia().equals(view.FrmPrincipal.sProvincia)) {
				view.FrmPrincipal.P = view.FrmPrincipal.aP.get(i);
			}
		}
		view.FrmPrincipal.aC = GestionXML.getCiudades(view.FrmPrincipal.P.getsId());
		ctrl.GestionXML.rellenarCiudades(view.FrmPrincipal.P);
	}
	
	public static void listenerCiudad() {
		view.FrmPrincipal.sCiudad = view.FrmPrincipal.comboBoxCiudad.getSelectedItem().toString(); 
		
		for(int i= 0 ; i < view.FrmPrincipal.aC.size() ; i++) {
			if(view.FrmPrincipal.aC.get(i).getsNombreCiudad().equals(view.FrmPrincipal.sCiudad)) {
				view.FrmPrincipal.C = view.FrmPrincipal.aC.get(i);
				}
		}
		String sTempMax = String.valueOf(view.FrmPrincipal.C.getiTempMax());
		String sTempMin = String.valueOf(view.FrmPrincipal.C.getiTempMin());

		view.FrmPrincipal.lblTemp.setText( "["+sTempMax+"]" +"-"+ "["+sTempMin+"]");
	}
}
