package com.flow.service;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.w3c.dom.Document;
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
		NodeList nodeList = writeProcess(doc);
	}

	public static Document readProcess(String path) throws SAXException, IOException {
		Document doc = null;
		File xmlProcess = new File(path);
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		try {
			// use java xml parsers to digest file into xml format
			DocumentBuilder builder = factory.newDocumentBuilder();
			doc = builder.parse(xmlProcess);
			doc.getDocumentElement().normalize();
			// now working with elements in the xml tree
		} catch (ParserConfigurationException pce) {
			System.out.println("Cannot parse file with this configuration on.");
		}
		return doc;
	}
	
	private static NodeList writeProcess(Document document){
		
		NodeList nodeList = document.getDocumentElement().getChildNodes();
		for(int i=0; i<nodeList.getLength(); i++) {
			Node nNode = nodeList.item(i);
			System.out.println("Node Name:" + nNode.getNodeName());
			while(nNode.hasChildNodes()) {
				NodeList subNodes = nNode.getChildNodes();
				System.out.println(subNodes.item(i).getNodeValue().toString());
			}
		}
		
		return nodeList;
		
	}
	

	@RequestMapping("/{name}")
	public String processReader(@PathVariable("name") String name) {
		return new String("Testing 1,2,3");
	}
}
