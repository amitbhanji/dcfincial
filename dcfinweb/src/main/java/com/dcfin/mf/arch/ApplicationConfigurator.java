package com.dcfin.mf.arch;

import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import com.dcfin.mf.model.AppConfig;

public class ApplicationConfigurator {

	public static synchronized Map<String, AppConfig> buildApplicationConfig(InputStream appConfigInput) {
		// Instantiate the Factory
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		try {
			// parse XML file
			DocumentBuilder db = dbf.newDocumentBuilder();
			// read from a project's resources folder
			Document doc = db.parse(appConfigInput);
			System.out.println("Root Element :" + doc.getDocumentElement().getNodeName());
			System.out.println("------");
			if (doc.hasChildNodes()) {
				printNote(doc.getChildNodes());
			}
		} catch (ParserConfigurationException | SAXException | IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	private static void printNote(NodeList nodeList) {
		for (int count = 0; count < nodeList.getLength(); count++) {
			Node tempNode = nodeList.item(count);
			// make sure it's element node.
			if (tempNode.getNodeType() == Node.ELEMENT_NODE) {
				// get node name and value
				System.out.println("\nNode Name =" + tempNode.getNodeName() + " [OPEN]");
				System.out.println("Node Value =" + tempNode.getTextContent());
				if (tempNode.hasAttributes()) {
					// get attributes names and values
					NamedNodeMap nodeMap = tempNode.getAttributes();
					for (int i = 0; i < nodeMap.getLength(); i++) {
						Node node = nodeMap.item(i);
						System.out.println("attr name : " + node.getNodeName());
						System.out.println("attr value : " + node.getNodeValue());
					}
				}
				if (tempNode.hasChildNodes()) {
					// loop again if has child nodes
					printNote(tempNode.getChildNodes());
				}
				System.out.println("Node Name =" + tempNode.getNodeName() + " [CLOSE]");
			}
		}
	}
}