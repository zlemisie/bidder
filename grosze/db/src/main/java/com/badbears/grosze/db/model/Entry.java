
package com.badbears.grosze.db.model;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="ENTRY")
public class Entry {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private Long itemId;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date timestamp;
	
	private String bidder;
	
	@Column(precision=12, scale=2)
	private BigDecimal cost;
	
	private Boolean automatedBid;
	
	private Boolean automatChanged;
	
	private Boolean strike;

	public Entry() {}
	
	public Entry(Long itemId, Date timestamp, String bidder, BigDecimal cost,
			Boolean automatedBid, Boolean automatChanged, Boolean strike) {
		super();
		this.itemId = itemId;
		this.timestamp = timestamp;
		this.bidder = bidder;
		this.cost = cost;
		this.automatedBid = automatedBid;
		this.automatChanged = automatChanged;
		this.strike = strike;
	}


	@Override
	public String toString() {
		return "Entry [id=" + id + ", itemId=" + itemId + ", timestamp="
				+ timestamp + ", bidder=" + bidder + ", cost=" + cost
				+ ", automatedBid=" + automatedBid + ", automatChanged="
				+ automatChanged + ", strike=" + strike + "]";
	}

	public Long getId() {
		return id;
	}

	public Long getItemId() {
		return itemId;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public String getBidder() {
		return bidder;
	}

	public BigDecimal getCost() {
		return cost;
	}

	public Boolean getAutomatedBid() {
		return automatedBid;
	}

	public Boolean getAutomatChanged() {
		return automatChanged;
	}

	public Boolean getStrike() {
		return strike;
	}

	

}
