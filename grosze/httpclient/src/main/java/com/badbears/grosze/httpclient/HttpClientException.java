package com.badbears.grosze.httpclient;

@SuppressWarnings("serial")
public class HttpClientException extends RuntimeException {

	HttpClientException(Exception e) {
		super(e);
	}
	
}
