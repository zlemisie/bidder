package com.badbears.grosze.httpclient.extractor;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;

import org.springframework.stereotype.Component;
import org.w3c.dom.Document;
import org.w3c.tidy.Configuration;
import org.w3c.tidy.Tidy;
import org.xml.sax.SAXException;

@Component
public class XmlParser {

	OutputParameters parseTable(String table) throws SAXException, IOException, ParserConfigurationException {
		
		Document doc = parseDOM(new ByteArrayInputStream(table.getBytes("UTF-8")));
		doc.getDocumentElement().normalize();
		
		OutputParameters output = new OutputParameters();
		
		for (int i=1;i<11;i++) {
			String name = parse(doc, "//tr["+i+"]/td[1]");
			String cost = parse(doc, "//tr["+i+"]/td[2]");
			cost = cost.replace(" z³", "");
			cost = cost.replace(",", ".");
			output.addBidder(new BigDecimal(cost), name);
		}

		return output;

	}
	
	private static String parse(Document document, String xpathString) {
		String evaluate = "";
		try {
			XPathExpression xpath = javax.xml.xpath.XPathFactory.newInstance()
					.newXPath().compile(xpathString);
			evaluate = xpath.evaluate(document);
		} catch (XPathExpressionException e) {
			e.printStackTrace();
		}
		return evaluate;

	}
	
	private static Document parseDOM(InputStream input) {
		Document parseDOM = null;
		Tidy tidy = new Tidy();
		tidy.setQuiet(true);
		tidy.setShowWarnings(false);
		tidy.setFixBackslash(true);
		tidy.setWrapAsp(true);
		tidy.setXmlOut(true);
		tidy.setMakeClean(true);
		tidy.setCharEncoding(Configuration.UTF8);
		parseDOM = tidy.parseDOM(input, null);
		return parseDOM;

	}
}
