package com.badbears.grosze.db;

import java.util.Date;

public class AnalyzedQueryResult {

	private String bidder;
	private Long bids;
	private Date start;
	private Date end;
	
	public AnalyzedQueryResult(String bidder, Long bids, Date start, Date end) {
		super();
		this.bidder = bidder;
		this.bids = bids;
		this.start = start;
		this.end = end;
	}

	public String getBidder() {
		return bidder;
	}

	public Long getBids() {
		return bids;
	}

	public Date getStart() {
		return start;
	}

	public Date getEnd() {
		return end;
	}
}
