package com.badbears.grosze.httpclient.extractor;

import java.io.InputStream;

import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;

import org.springframework.stereotype.Component;
import org.w3c.dom.Document;
import org.w3c.tidy.Configuration;
import org.w3c.tidy.Tidy;

@Component
public class TidyXmlParser {

	public String parse(Document document, String xpathString) {
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
	
	public Document parseDOM(InputStream input) {
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
		parseDOM.getDocumentElement().normalize();
		return parseDOM;

	}
	
}
