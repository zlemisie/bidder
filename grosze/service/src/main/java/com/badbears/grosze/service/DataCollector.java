package com.badbears.grosze.service;

import java.math.BigDecimal;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.badbears.grosze.db.EntryRepo;
import com.badbears.grosze.db.model.Entry;
import com.badbears.grosze.httpclient.HttpClientException;
import com.badbears.grosze.httpclient.IHttpClient;
import com.badbears.grosze.httpclient.extractor.OutputParameters;

@Service
public class DataCollector {

	@Autowired
	private IHttpClient httpClient;
	
	@Autowired
	private EntryRepo repository;
	
	public void collect(Long itemId) {		
		
		while (true) {
			try {
				Date timestamp = new Date();
				OutputParameters output = httpClient.ask(itemId);
				
				for (BigDecimal cost:output.getBidders().keySet()) {
					if (!repository.isInRepo(itemId, cost)) {
						String bidder = output.getBidders().get(cost);
		
						Boolean automatChanged = bidder.contains("(automat - zmiana ustawieñ)");
						Boolean auromatedBid = bidder.contains("(automat)");
						Boolean strike = bidder.contains("(strza³)");
						
						bidder = bidder.replace(" (automat - zmiana ustawieñ)", "");
						bidder = bidder.replace(" (automat)", "");
						bidder = bidder.replace(" (strza³)", "");
						Entry entry = new Entry(itemId, timestamp, bidder, cost, auromatedBid, automatChanged, strike);
						
						repository.save(entry);
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
