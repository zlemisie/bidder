package com.badbears.grosze.analyzer;

import java.util.List;

import com.badbears.grosze.db.AnalyzedQueryResult;
import com.badbears.grosze.db.AuctionBidsInfo;
import com.badbears.grosze.db.model.Item;

public class AnalyzedData {

	private Item item;
	private List<AnalyzedQueryResult> analyzedQueryResults;
	private AuctionBidsInfo auctionBidsInfo;
	
	public AnalyzedData(Item item,
			List<AnalyzedQueryResult> analyzedQueryResults,
			AuctionBidsInfo auctionBidsInfo) {
		super();
		this.item = item;
		this.analyzedQueryResults = analyzedQueryResults;
		this.auctionBidsInfo = auctionBidsInfo;
	}

	public Item getItem() {
		return item;
	}

	public List<AnalyzedQueryResult> getAnalyzedQueryResults() {
		return analyzedQueryResults;
	}

	public AuctionBidsInfo getAuctionBidsInfo() {
		return auctionBidsInfo;
	}
	
}
