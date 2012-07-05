package com.badbears.grosze.httpclient.extractor.updates;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.xml.sax.SAXException;



@Component
public class ActionUpdatesExtractor {

	@Autowired
	private ActionUpdatesInputStringParser inputStringParser;
	
	@Autowired 
	private ActionUpdatesXmlParser xmlParser;
	
	public ActionUpdatesOutputParameters extractDataFromActionsUpdate(String inputString) {
		
		String table = inputStringParser.findTable(inputString);
		ActionUpdatesOutputParameters outputParameters = null;
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
