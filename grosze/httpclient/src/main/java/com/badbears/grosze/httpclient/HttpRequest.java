package com.badbears.grosze.httpclient;

import java.io.IOException;
import java.io.InputStream;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.params.CookiePolicy;
import org.apache.http.impl.client.DefaultHttpClient;
import org.springframework.stereotype.Component;

@Component
public class HttpRequest {

	InputStream get(Long itemId) throws IOException {
		DefaultHttpClient httpclient = new DefaultHttpClient();

		httpclient
				.getParams()
				.setParameter(
						"http.useragent",
						"Mozilla/5.0 (Windows; U; Windows NT 5.1; en-US; rv:1.9.0.1) Gecko/2008070208 Firefox/3.0.1");
		httpclient.getParams().setParameter("http.protocol.cookie-policy",
				CookiePolicy.BROWSER_COMPATIBILITY);
		httpclient.getParams().setBooleanParameter(
				"http.protocol.single-cookie-header", true);

		httpclient.getParams().setBooleanParameter(
				"http.protocol.allow-circular-redirects", true);
		HttpGet httpget = new HttpGet("http://za10groszy.pl/auctionsUpdate.txt?js=true&ids="+itemId+";&bidsId="+itemId);

		HttpResponse response = httpclient.execute(httpget);
		HttpEntity entity = response.getEntity();
				
		return entity.getContent();

	}	
}
