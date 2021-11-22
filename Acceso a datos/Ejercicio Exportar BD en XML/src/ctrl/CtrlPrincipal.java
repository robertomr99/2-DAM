package ctrl;

import java.io.File;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;

public class CtrlPrincipal {

	public static ArrayList<String> aTablas = new ArrayList<String>();
	public static ArrayList<String> aNombreCampos = new ArrayList<String>();
	public static ArrayList<String> aResultadoTablas = new ArrayList<String>();
	public static ArrayList<String> aNombreObjetos = new ArrayList<String>();
	private static int iNumero = 0;

	private static Document documento;

	public static void crearXML()  {
		try {
		rellenarNombreObjetos();

		logic.Logic.getNombreTablas();
		logic.Logic.getResultadoTablas(iNumero);

		for (int i = 0; i < ctrl.CtrlPrincipal.aTablas.size(); i++) {

			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			DOMImplementation implementation = builder.getDOMImplementation();

			documento = implementation.createDocument(null, aTablas.get(i), null);
			documento.setXmlVersion("1.0");
			
			if(documento==null) {
				System.out.println("ES NULO");
			} else {
				System.out.println("NO ES NULO");

			}
			rellenarXML();

			Source source = new DOMSource(documento);

			// Creo el Result, indicado que fichero se va a crear

			Result result = new StreamResult(new File("" + aTablas.get(i) + ".xml"));

			// Creo un transformer, se crea el fichero XML

			System.out.println("HOLA");
			Transformer transformer = TransformerFactory.newInstance().newTransformer();
			transformer.transform(source, result);
			iNumero++;
		}
		} catch(Exception e) {
			System.out.println("MI FALLO ES: " + e.getMessage());
			e.printStackTrace();
		}

	}

	public static void rellenarNombreObjetos() {
		aNombreObjetos.add("CASA");
		aNombreObjetos.add("COCHE");
		aNombreObjetos.add("DEPARTAMENTO");
		aNombreObjetos.add("EMPLEADO");
	}

	public static void rellenarXML() {
		for (int v = 0; v < aTablas.size(); v++) {
			//System.out.println(aTablas.get(v));
			
		}
		
		for (int y = 0; y < aTablas.size(); y++) {
			 //System.out.println("ESTOY AQUI");
			//System.out.println(aTablas.get(y));

			Element eTabla = documento.createElement(aTablas.get(y));
			Element eObjetoTabla = documento.createElement(aNombreObjetos.get(y));

			for (int i = 0; i < aNombreCampos.size(); i++) {
				Element eCampo = documento.createElement(aNombreCampos.get(i));
				for (int x = 0; x < aResultadoTablas.size(); x++) {
					Text txtResultadoCampo = documento.createTextNode(aTablas.get(x));
					eCampo.appendChild(txtResultadoCampo);
					eObjetoTabla.appendChild(eCampo);
				}
				eTabla.appendChild(eObjetoTabla);
			}
			documento.getDocumentElement().appendChild(eTabla);
		}

	}

}
