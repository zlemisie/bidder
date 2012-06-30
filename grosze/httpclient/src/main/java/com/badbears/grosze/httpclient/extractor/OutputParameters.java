package com.badbears.grosze.httpclient.extractor;

import java.math.BigDecimal;
import java.util.Map;
import java.util.TreeMap;

public class OutputParameters {

	private Map<BigDecimal, String> bidders;
	
	public OutputParameters() {
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
