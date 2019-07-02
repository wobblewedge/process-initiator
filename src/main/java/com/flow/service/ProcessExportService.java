package com.flow.service;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

@RestController
public class ProcessExportService {

	/*
	 * @RequestMapping("/{id}") public Rating getRatings(@PathVariable("id") String
	 * id ) { return new Rating("ID", 3); }
	 */

	public static void main(String[] args) throws SAXException, IOException {
		Document doc = readProcess("src/main/resources/processes/vacation-request.bpmn20.xml");
	    writeProcess(doc);
	}

	public static Document readProcess(String path) throws SAXException, IOException {
		Document doc = null;
		File xmlProcess = new File(path);
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		try {
			DocumentBuilder builder = factory.newDocumentBuilder();
			doc = builder.parse(xmlProcess);
			doc.getDocumentElement().normalize();
		} catch (ParserConfigurationException pce) {
			System.out.println("Cannot parse file with this configuration on.");
		}
		return doc;
	}
	
	private static void writeProcess(Document document){
		
		NodeList nodeList = document.getChildNodes();
		for(int i=0; i<nodeList.getLength(); i++) {
			Node nNode = nodeList.item(i);
			if (nNode.getNodeType() != 0) {

				// get node name and value
				System.out.println("\nNode Name =" + nNode.getNodeName() + " [OPEN]");
				System.out.println("Node Value =" + nNode.getTextContent());

				if (nNode.hasAttributes()) {
					// get attributes names and values
					NamedNodeMap nodeMap = nNode.getAttributes();

					for (int k = 0; i < nodeMap.getLength(); i++) {
						Node node = nodeMap.item(i);
						System.out.println("attr name : " + node.getNodeName());
						System.out.println("attr value : " + node.getNodeValue());
					}
				}
			if(nNode.hasChildNodes()) {
				System.out.println("Node Name:" + nNode.getNodeName() +" [close]");
			    }		
			}
		}
	}
	

	@RequestMapping("/{name}")
	public String processReader(@PathVariable("name") String name) {
		return new String("Testing 1,2,3");
	}
}
