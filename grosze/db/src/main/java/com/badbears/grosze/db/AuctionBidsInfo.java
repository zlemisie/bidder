package com.badbears.grosze.db;

import java.math.BigDecimal;
import java.util.Date;

public class AuctionBidsInfo {

	private BigDecimal currentCost;
	private Date firstRecordedDate;
	private Date lastRecordedDate;
	
	public AuctionBidsInfo(BigDecimal currentCost, Date firstRecordedDate,
			Date lastRecordedDate) {
		super();
		this.currentCost = currentCost;
		this.firstRecordedDate = firstRecordedDate;
		this.lastRecordedDate = lastRecordedDate;
	}

	public BigDecimal getCurrentCost() {
		return currentCost;
	}

	public Date getFirstRecordedDate() {
		return firstRecordedDate;
	}

	public Date getLastRecordedDate() {
		return lastRecordedDate;
	}
	
	
	
}
