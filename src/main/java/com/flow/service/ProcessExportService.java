package com.flow.service;

import com.flow.util.ProcessUtility;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.w3c.dom.Document;

import org.xml.sax.SAXException;

import java.io.FileNotFoundException;
import java.io.IOException;

@RestController
@RequestMapping("/processes")
public class ProcessExportService {

	@Autowired
	RestTemplate restTemplate = new RestTemplate();
	
	String path = "src/main/resources/processes/";
	String docType = "bpmn20.xml";
	
	
	ProcessUtility docLoader = new ProcessUtility();
	
	@RequestMapping("/{name}")
	public Document processReader(@PathVariable("name") String name) throws SAXException, IOException {
		Document doc = null;
		try {
			doc = docLoader.readProcess(path+name+docType);
		} catch (FileNotFoundException ffe){
			System.out.println("File does not exist");
		}
		return doc;
	}
}
