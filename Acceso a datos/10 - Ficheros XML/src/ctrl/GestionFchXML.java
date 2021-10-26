package ctrl;

import java.io.IOException;
import java.util.ArrayList;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
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
		ArrayList<Jugador> aJugadores= new ArrayList<>();

		XPath xPath = XPathFactory.newInstance().newXPath();

		String sExpression = "/game/jugador";

		try {
			NodeList nodeList = (NodeList) xPath.compile(sExpression).evaluate(docXML, XPathConstants.NODESET);

			for (int iContador = 0; iContador < nodeList.getLength(); iContador++) {
				Node nNode = nodeList.item(iContador);
				if (nNode.getNodeType() == Node.ELEMENT_NODE) {
					Element eElement = (Element) nNode;
					
					String sNombre , sApellidos, sNick;
					int iNumero, iPuntos;
					
					
				iNumero = Integer.parseInt(eElement.getAttribute("iNumero"));
				iPuntos = Integer.parseInt(eElement.getElementsByTagName("iPuntos").item(0).getTextContent());
				sNombre = eElement.getElementsByTagName("sNombre").item(0).getTextContent();
				sApellidos = eElement.getElementsByTagName("sApellidos").item(0).getTextContent();
				sNick =  eElement.getElementsByTagName("sNick").item(0).getTextContent();
				
				aJugadores.add(new Jugador(iNumero,iPuntos,sNombre,sApellidos,sNick));
				
				}
			}

		} catch (XPathExpressionException e) {
			e.printStackTrace();
		}

		
		return aJugadores;
	}

}
