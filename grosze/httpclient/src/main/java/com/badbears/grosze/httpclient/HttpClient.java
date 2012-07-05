package com.badbears.grosze.httpclient;

import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;

import org.apache.http.client.ClientProtocolException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.badbears.grosze.httpclient.extractor.actiondata.ActionData;
import com.badbears.grosze.httpclient.extractor.actiondata.ActionDataExtractor;
import com.badbears.grosze.httpclient.extractor.actiondata.ItemIdExtractor;
import com.badbears.grosze.httpclient.extractor.updates.ActionUpdatesExtractor;
import com.badbears.grosze.httpclient.extractor.updates.ActionUpdatesOutputParameters;

@Service
public class HttpClient implements IHttpClient {

	@Autowired
	private HttpRequest request;
	@Autowired
	private StreamToString stramToString;
	@Autowired
	private ActionUpdatesExtractor actionUpdatesExtractor;
	@Autowired
	private ActionDataExtractor actionDataExtractor;
	@Autowired
	private ItemIdExtractor itemIdExtractor;

	@Override
	public ActionUpdatesOutputParameters getActionUpdates(Long itemId) throws HttpClientException {
		try {
			InputStream inputStream = request.getActionsUpdate(itemId);
			String inputString = stramToString.streamToString(inputStream);
			ActionUpdatesOutputParameters parameters = actionUpdatesExtractor.extractDataFromActionsUpdate(inputString);
			return parameters;
		} catch (ClientProtocolException e) {
			throw new HttpClientException(e);
		} catch (IOException e) {
			throw new HttpClientException(e);
		}
	}
	
	@Override
	public ActionData getActionData(String address) {
		ActionData actionData = null;
		Long itemId = itemIdExtractor.extractItemId(address);
		try {
			InputStream inputStream = request.getActionData(address);
			String inputString = stramToString.streamToString(inputStream);
			actionData = actionDataExtractor.extracActionData(itemId, inputString);
		} catch (ClientProtocolException e) {
			throw new HttpClientException(e);
		} catch (IOException e) {
			throw new HttpClientException(e);
		} catch (ParseException e) {
			throw new HttpClientException(e);
		} 
		return actionData;
	}
	
}
