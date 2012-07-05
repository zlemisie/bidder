package com.badbears.grosze.httpclient.extractor.updates;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.math.BigDecimal;

import javax.xml.parsers.ParserConfigurationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import com.badbears.grosze.httpclient.extractor.TidyXmlParser;

@Component
public class ActionUpdatesXmlParser {
	
	@Autowired
	private TidyXmlParser parser;

	ActionUpdatesOutputParameters parseTable(String table) throws SAXException, IOException, ParserConfigurationException {
		
		Document doc = parser.parseDOM(new ByteArrayInputStream(table.getBytes("UTF-8")));
		
		ActionUpdatesOutputParameters output = new ActionUpdatesOutputParameters();
		
		for (int i=1;i<11;i++) {
			String name = parser.parse(doc, "//tr["+i+"]/td[1]");
			String cost = parser.parse(doc, "//tr["+i+"]/td[2]");
			cost = cost.replace(" z³", "");
			cost = cost.replace(",", ".");
			output.addBidder(new BigDecimal(cost), name);
		}

		return output;

	}
	
}
