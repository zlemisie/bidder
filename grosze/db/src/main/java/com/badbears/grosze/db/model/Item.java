
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
		
	private Integer rebidTime;
	
	@Column(precision=12, scale=2)
	private BigDecimal rebidAmount;
	
	private BigDecimal shippingCost;
	
	private Integer rebids;

	public Item() {}

	public Item(Long itemId, String itemName, BigDecimal marketPrice,
			Integer rebidTime, BigDecimal rebidAmount, BigDecimal shippingCost,
			Integer rebids) {
		super();
		this.itemId = itemId;
		this.itemName = itemName;
		this.marketPrice = marketPrice;
		this.rebidTime = rebidTime;
		this.rebidAmount = rebidAmount;
		this.shippingCost = shippingCost;
		this.rebids = rebids;
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

	public Integer getRebidTime() {
		return rebidTime;
	}

	public BigDecimal getRebidAmount() {
		return rebidAmount;
	}

	public BigDecimal getShippingCost() {
		return shippingCost;
	}

	public Integer getRebids() {
		return rebids;
	}
	





}
