package com.badbears.grosze.httpclient.extractor.actiondata;

import org.springframework.stereotype.Component;

@Component
public class ItemIdExtractor {

	public Long extractItemId(String address) {
		String itemIdAsString = address.substring(1 + address.lastIndexOf("_"), address.lastIndexOf("."));
		Long itemId = Long.parseLong(itemIdAsString);
		return itemId;
	}
}
