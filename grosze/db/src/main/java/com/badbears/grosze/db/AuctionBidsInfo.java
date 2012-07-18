package com.badbears.grosze.db;

import java.math.BigDecimal;
import java.util.Date;

public class AuctionBidsInfo {

	private BigDecimal startCost;
	private BigDecimal currentCost;
	private Date firstRecordedDate;
	private Date lastRecordedDate;
	
	public AuctionBidsInfo(BigDecimal startCost, 
			BigDecimal currentCost, 
			Date firstRecordedDate,
			Date lastRecordedDate) {
		super();
		this.startCost = startCost;
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

	public BigDecimal getStartCost() {
		return startCost;
	}
	
	
	
}
