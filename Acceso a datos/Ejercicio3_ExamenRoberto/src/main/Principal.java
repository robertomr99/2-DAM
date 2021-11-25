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
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import model.Casa;

public class Principal {

	private static String fileName = "archivos/datos.dat";
	private static Document docXML;
	public static void main(String[] args) {
		// TODO Auto-generated method stub


		org.jboss.logging.Logger logger = org.jboss.logging.Logger.getLogger("org.hibernate");
		java.util.logging.Logger.getLogger("org.hibernate").setLevel(java.util.logging.Level.OFF);

		SessionFactory conf = new Configuration().configure().buildSessionFactory();

		Session session = conf.openSession();

		Transaction tx = session.beginTransaction();

		ArrayList<Casa> aCasasLeida = getCasas();

		for (Casa c : aCasasLeida) {
			session.save(c);
		}

		tx.commit();

		session.close();

		conf.close();

	}
	
	
	@SuppressWarnings("null")
	public static ArrayList<Casa> getCasas() {
		ArrayList<Casa> aCasas = new ArrayList<>();

		XPath xPath = XPathFactory.newInstance().newXPath();

		String sExpression = "/Casas/CASA";

		try {
			NodeList nodeList = (NodeList) xPath.compile(sExpression).evaluate(docXML, XPathConstants.NODESET);

			for (int iContador = 0; iContador < nodeList.getLength(); iContador++) {
				Node nNode = nodeList.item(iContador);
				if (nNode.getNodeType() == Node.ELEMENT_NODE) {
					Element eElement = (Element) nNode;

					String sPoblacion;
					Integer iId_Casa, iAseos;
					Double dSuperficie;

					iId_Casa = Integer.parseInt(eElement.getAttribute("ID_CASAS"));
					sPoblacion = eElement.getElementsByTagName("POBLACION").item(0).getTextContent();
					iAseos = Integer.parseInt(eElement.getElementsByTagName("ASEOS").item(0).getTextContent());
					dSuperficie = Double
							.parseDouble(eElement.getElementsByTagName("SUPERFICIE").item(0).getTextContent());

					aCasas.add(new Casa(iId_Casa, sPoblacion, iAseos, dSuperficie));

				}
			}

		} catch (XPathExpressionException e) {
			e.printStackTrace();
		}

		return aCasas;
	}

}