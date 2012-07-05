package com.badbears.grosze.httpclient.extractor.updates;

import java.math.BigDecimal;
import java.util.Map;
import java.util.TreeMap;

public class ActionUpdatesOutputParameters {

	private Map<BigDecimal, String> bidders;
	
	public ActionUpdatesOutputParameters() {
		bidders = new TreeMap<BigDecimal, String>();
	}
		
	public void addBidder(BigDecimal cost, String name) {
		bidders.put(cost, name);
	}

	@Override
	public String toString() {
		return "OutputParameters [bidders=" + bidders + "]";
	}

	public Map<BigDecimal, String> getBidders() {
		return bidders;
	}

}
