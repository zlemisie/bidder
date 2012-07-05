package com.badbears.grosze.httpclient;

import com.badbears.grosze.httpclient.extractor.actiondata.ActionData;
import com.badbears.grosze.httpclient.extractor.updates.ActionUpdatesOutputParameters;

public interface IHttpClient {

	public abstract ActionUpdatesOutputParameters getActionUpdates(Long itemId) throws HttpClientException;

	public abstract ActionData getActionData(String address);

}