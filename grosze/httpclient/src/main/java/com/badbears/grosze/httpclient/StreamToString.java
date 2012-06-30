package com.badbears.grosze.httpclient;

import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;

import org.apache.commons.io.IOUtils;
import org.springframework.stereotype.Component;

@Component
public class StreamToString {

	String streamToString(InputStream inputStream) throws IOException {
		StringWriter writer = new StringWriter();
		IOUtils.copy(inputStream, writer, "UTF-8");
		String theString = writer.toString();
		return theString;
	}
	
}
