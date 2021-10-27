package ctrl;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import model.Jugador;

public class GestionFchXML {

	private Document docXML;

	public GestionFchXML(String sFileName) {

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

	public void addJugador(Jugador j) {
		Element item = docXML.createElement("jugador");

		item.setAttribute("numero", "" + j.getiNumero());

		Element tagName;
		Node tagValue;

		// Nombre

		tagName = docXML.createElement("sNombre");
		tagValue = docXML.createTextNode(j.getsNombre());

		// Asociamos el tagName al tagValue

		tagName.appendChild(tagValue);
		item.appendChild(tagName);

		// Apellidos

		tagName = docXML.createElement("sApellidos");
		tagValue = docXML.createTextNode(j.getsApellidos());
		tagName.appendChild(tagValue);
		item.appendChild(tagName);

		// Nick

		tagName = docXML.createElement("sNick");
		tagValue = docXML.createTextNode(j.getsNick());
		tagName.appendChild(tagValue);
		item.appendChild(tagName);

		// Puntos

		tagName = docXML.createElement("iPuntos");
		tagValue = docXML.createTextNode("" + j.getiPuntos());
		tagName.appendChild(tagValue);
		item.appendChild(tagName);

		// Add al Arbol

		/*
		 * Node nRaiz = docXML.getFirstChild(); nRaiz.appendChild(item); // Es lo mismo
		 * //
		 */

		docXML.getFirstChild().appendChild(item);

	}

	public void saveData() {

		try {

			Transformer tr = TransformerFactory.newInstance().newTransformer();
			tr.setOutputProperty(OutputKeys.INDENT, "yes"); // si queremos que este indentado
			tr.setOutputProperty(OutputKeys.METHOD, "xml"); // el tipo de formato
			tr.setOutputProperty(OutputKeys.ENCODING, "UTF-8"); 
			tr.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4"); // Le indicamos la cantidad de espacios del indent

			// enviar el DOM al fichero

			tr.transform(new DOMSource(docXML), new StreamResult(new FileOutputStream("nuevosdatos.xml")));
			
			// DOMSource -> Documento Origen , StreamResult -> new FileOutputSteram -> Nuevo Documento;
			
			// Si podemos el mismo nombre en el nuevo docoumento se sobreescribe;

		} catch (Exception e) {

		}

	}

	public void mostrarDocumento() {

		XPath xPath = XPathFactory.newInstance().newXPath();

		String sExpression = "/game/jugador";

		try {
			NodeList nodeList = (NodeList) xPath.compile(sExpression).evaluate(docXML, XPathConstants.NODESET);

			for (int iContador = 0; iContador < nodeList.getLength(); iContador++) {
				Node nNode = nodeList.item(iContador);
				if (nNode.getNodeType() == Node.ELEMENT_NODE) {
					Element eElement = (Element) nNode;
					System.out.println("Jugador num: " + eElement.getAttribute("iNumero"));
					System.out.println("Nombre : " + eElement.getElementsByTagName("sNombre").item(0).getTextContent());
					System.out.println(
							"Apellidos : " + eElement.getElementsByTagName("sApellidos").item(0).getTextContent());
					System.out.println("Nick : " + eElement.getElementsByTagName("sNick").item(0).getTextContent());
					System.out.println(
							"Puntos : " + eElement.getElementsByTagName("iPuntos").item(0).getTextContent() + "\n");
				}
			}

		} catch (XPathExpressionException e) {
			e.printStackTrace();
		}

	}

	@SuppressWarnings("null")
	public ArrayList<Jugador> getJugadores() {
		ArrayList<Jugador> aJugadores = new ArrayList<>();

		XPath xPath = XPathFactory.newInstance().newXPath();

		String sExpression = "/game/jugador";

		try {
			NodeList nodeList = (NodeList) xPath.compile(sExpression).evaluate(docXML, XPathConstants.NODESET);

			for (int iContador = 0; iContador < nodeList.getLength(); iContador++) {
				Node nNode = nodeList.item(iContador);
				if (nNode.getNodeType() == Node.ELEMENT_NODE) {
					Element eElement = (Element) nNode;

					String sNombre, sApellidos, sNick;
					int iNumero, iPuntos;

					iNumero = Integer.parseInt(eElement.getAttribute("iNumero"));
					iPuntos = Integer.parseInt(eElement.getElementsByTagName("iPuntos").item(0).getTextContent());
					sNombre = eElement.getElementsByTagName("sNombre").item(0).getTextContent();
					sApellidos = eElement.getElementsByTagName("sApellidos").item(0).getTextContent();
					sNick = eElement.getElementsByTagName("sNick").item(0).getTextContent();

					aJugadores.add(new Jugador(iNumero, iPuntos, sNombre, sApellidos, sNick));

				}
			}

		} catch (XPathExpressionException e) {
			e.printStackTrace();
		}

		return aJugadores;
	}

}
