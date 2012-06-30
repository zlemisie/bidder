package com.badbears.grosze.httpclient;

import com.badbears.grosze.httpclient.extractor.OutputParameters;


public interface IHttpClient {

	public abstract OutputParameters ask(Long itemId) throws HttpClientException;

}