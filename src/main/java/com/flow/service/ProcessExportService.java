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

	

	@RequestMapping("/{name}")
	public String processReader(@PathVariable("name") String name) {
		return new String("Testing 1,2,3");
	}
}
