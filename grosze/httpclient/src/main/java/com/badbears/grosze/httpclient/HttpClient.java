package com.badbears.grosze.httpclient;

import java.io.IOException;
import java.io.InputStream;

import org.apache.http.client.ClientProtocolException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.badbears.grosze.httpclient.extractor.Extractor;
import com.badbears.grosze.httpclient.extractor.OutputParameters;

@Service
public class HttpClient implements IHttpClient {

	@Autowired
	private HttpRequest request;
	@Autowired
	private StreamToString stramToString;
	@Autowired
	private Extractor extractor;

	public OutputParameters ask(Long itemId) throws HttpClientException {
		try {
			InputStream inputStream = request.get(itemId);
			String inputString = stramToString.streamToString(inputStream);
			OutputParameters parameters = extractor.extract(inputString);
			return parameters;
		} catch (ClientProtocolException e) {
			throw new HttpClientException(e);
		} catch (IOException e) {
			throw new HttpClientException(e);
		}
	}
	
}
