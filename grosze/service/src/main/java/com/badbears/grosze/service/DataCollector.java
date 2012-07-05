package com.badbears.grosze.service;

import java.math.BigDecimal;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.badbears.grosze.db.EntryRepo;
import com.badbears.grosze.db.ItemRepo;
import com.badbears.grosze.db.model.Entry;
import com.badbears.grosze.db.model.Item;
import com.badbears.grosze.httpclient.HttpClientException;
import com.badbears.grosze.httpclient.IHttpClient;
import com.badbears.grosze.httpclient.extractor.actiondata.ActionData;
import com.badbears.grosze.httpclient.extractor.updates.ActionUpdatesOutputParameters;

@Service
public class DataCollector {

	@Autowired
	private IHttpClient httpClient;
	
	@Autowired
	private EntryRepo entryRepository;
	
	@Autowired
	private ItemRepo itemRepository;
		
	public void collect(String address) {		
		
		ActionData actionData = httpClient.getActionData(address);
		Long itemId = actionData.getItemId();
		if (!itemRepository.isInRepo(itemId)) {
			Item item = new Item(actionData.getItemId(), actionData.getActionName(), actionData.getMarketPrice(), actionData.getRebidTime(), actionData.getRebidAmount(), actionData.getShippingCost(), actionData.getRebids());
			itemRepository.save(item);
		}
		
		while (true) {
			try {
				Date timestamp = new Date();
				ActionUpdatesOutputParameters actionUpdates = httpClient.getActionUpdates(itemId);
				
				for (BigDecimal cost:actionUpdates.getBidders().keySet()) {
					if (!entryRepository.isInRepo(itemId, cost)) {
						String bidder = actionUpdates.getBidders().get(cost);
		
						Boolean automatChanged = bidder.contains("(automat - zmiana ustawieñ)");
						Boolean auromatedBid = bidder.contains("(automat)");
						Boolean strike = bidder.contains("(strza³)");
						
						bidder = bidder.replace(" (automat - zmiana ustawieñ)", "");
						bidder = bidder.replace(" (automat)", "");
						bidder = bidder.replace(" (strza³)", "");
						Entry entry = new Entry(itemId, timestamp, bidder, cost, auromatedBid, automatChanged, strike);
						
						entryRepository.save(entry);
						System.err.println("Zapisalem do bazy");
						
					}
					else {
						System.err.println("juz istnieje w bazie");
					}
					
				}
				
				waitFor(5000);
			} catch (HttpClientException e) {
				System.err.println("Timeout");
			} catch (NumberFormatException e) {
				System.err.println("Aukcja jeszcze sie nie rozpoczela");
				waitFor(30000);
			} catch (NullPointerException e) {
				System.err.println("Aukcja jeszcze sie nie rozpoczela");
				waitFor(30000);
			}
		}

	}

	private static void waitFor(int milis) {
		try {
			Thread.sleep(milis);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
