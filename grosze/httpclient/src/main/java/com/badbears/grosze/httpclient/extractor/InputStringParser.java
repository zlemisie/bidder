package com.badbears.grosze.httpclient.extractor;

import java.util.Scanner;

import org.springframework.stereotype.Component;

@Component
public class InputStringParser {

	String findTable(String inputString) {
		String foundStringContainingTable = "";
		Scanner lineScanner = new Scanner(inputString);
		lineScanner.useDelimiter("\n");
		while (lineScanner.hasNext()) {
			String nextLine = lineScanner.next();
			Scanner colonScanner = new Scanner(nextLine);
			colonScanner.useDelimiter(";");
			while (colonScanner.hasNext()) {
				String nextValue = colonScanner.next();
				if (nextValue.startsWith("<table")) {
					foundStringContainingTable = nextValue;			
				}
			}
		}
		return foundStringContainingTable;
	}
	
}
