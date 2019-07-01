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

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

@RestController
public class ProcessExportService {

/*	@RequestMapping("/{id}")
	public Rating getRatings(@PathVariable("id") String id ) {
		return new Rating("ID", 3);
	}
*/
	
	public static void main(String[] args) throws SAXException, IOException {
	 Document doc = readProcess();
	System.out.println (doc.getDocumentElement().getNodeName() + " " + doc.getDocumentElement().getNodeValue());
		
	}
	static Document readProcess() throws SAXException, IOException{
	Document doc = null;
	File xmlProcess = new File("src/main/resources/processes/vacation-request.bpmn20.xml");
	System.out.println(xmlProcess.canRead());
	DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
	try {
	//use java xml parsers to digest file into xml format
	DocumentBuilder builder = factory.newDocumentBuilder();
	doc = builder.parse(xmlProcess);
	doc.getDocumentElement().normalize();
	//now working with elements in the xml tree
	NodeList nodeList = doc.getDocumentElement().getChildNodes();
	for(int i=0; i<nodeList.getLength(); i++) {
		System.out.println(i);
	}
	
	} catch(ParserConfigurationException pce) {
		System.out.println("Cannot parse file with this shit goin on.");
	}
	return doc;
	}
	
	@RequestMapping("/{name}")
	public String processReader(@PathVariable("name") String name) {
		return new String("Testing 1,2,3");
	}
}
