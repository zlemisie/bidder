
package com.badbears.grosze.db.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name="ITEM", uniqueConstraints=@UniqueConstraint(columnNames="ITEMID"))
public class Item {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(unique=true, nullable=false) 
	private Long itemId;
	
	private String itemName;
	
	private BigDecimal marketPrice;
	
	private Integer raiseBids;
	
	private BigDecimal raiseAmount;
	
	private Integer secondsToRaise;
	
	private BigDecimal actualPrice;

	public Item(Long itemId, String itemName, BigDecimal marketPrice,
			Integer raiseBids, BigDecimal raiseAmount, Integer secondsToRaise,
			BigDecimal actualPrice) {
		super();
		this.itemId = itemId;
		this.itemName = itemName;
		this.marketPrice = marketPrice;
		this.raiseBids = raiseBids;
		this.raiseAmount = raiseAmount;
		this.secondsToRaise = secondsToRaise;
		this.actualPrice = actualPrice;
	}

	@Override
	public String toString() {
		return "Item [itemId=" + itemId + ", itemName=" + itemName
				+ ", marketPrice=" + marketPrice + ", raiseBids=" + raiseBids
				+ ", raiseAmount=" + raiseAmount + ", secondsToRaise="
				+ secondsToRaise + ", actualPrice=" + actualPrice + "]";
	}

	public Long getId() {
		return id;
	}

	public Long getItemId() {
		return itemId;
	}

	public String getItemName() {
		return itemName;
	}

	public BigDecimal getMarketPrice() {
		return marketPrice;
	}

	public Integer getRaiseBids() {
		return raiseBids;
	}

	public BigDecimal getRaiseAmount() {
		return raiseAmount;
	}

	public Integer getSecondsToRaise() {
		return secondsToRaise;
	}

	public BigDecimal getActualPrice() {
		return actualPrice;
	}


}
