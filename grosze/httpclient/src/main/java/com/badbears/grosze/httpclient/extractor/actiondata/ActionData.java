package com.badbears.grosze.httpclient.extractor.actiondata;

import java.math.BigDecimal;

public class ActionData {
	
	private Long itemId;
	private String actionName;
	private BigDecimal marketPrice;
	private BigDecimal shippingCost;
	private Integer rebidTime;
	private BigDecimal rebidAmount;
	private Integer rebids;
	
	public ActionData(Long itemId, String actionName, BigDecimal marketPrice,
			BigDecimal shippingCost, Integer rebidTime, BigDecimal rebidAmount, Integer rebids) {
		super();
		this.itemId = itemId;
		this.actionName = actionName;
		this.marketPrice = marketPrice;
		this.shippingCost = shippingCost;
		this.rebidTime = rebidTime;
		this.rebidAmount = rebidAmount;
		this.rebids = rebids;
	}

	@Override
	public String toString() {
		return "ActionData [itemId=" + itemId + ", actionName=" + actionName
				+ ", marketPrice=" + marketPrice + ", shippingCost="
				+ shippingCost + ", rebidTime=" + rebidTime + ", rebidAmount="
				+ rebidAmount + ", rebids=" + rebids + "]";
	}


	public Long getItemId() {
		return itemId;
	}

	public String getActionName() {
		return actionName;
	}

	public BigDecimal getMarketPrice() {
		return marketPrice;
	}

	public BigDecimal getShippingCost() {
		return shippingCost;
	}

	public Integer getRebidTime() {
		return rebidTime;
	}

	public BigDecimal getRebidAmount() {
		return rebidAmount;
	}

	public Integer getRebids() {
		return rebids;
	}
	


	
}
