package com.badbears.grosze.httpclient.extractor;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.xml.sax.SAXException;


@Component
public class Extractor {

	@Autowired
	private InputStringParser inputStringParser;
	
	@Autowired 
	private XmlParser xmlParser;
	
	public OutputParameters extract(String inputString) {
		
		String table = inputStringParser.findTable(inputString);
		OutputParameters outputParameters = null;
		try {
			outputParameters = xmlParser.parseTable(table);
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return outputParameters;
	}
}
