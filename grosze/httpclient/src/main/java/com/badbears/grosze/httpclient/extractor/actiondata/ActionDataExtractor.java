package com.badbears.grosze.httpclient.extractor.actiondata;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.w3c.dom.Document;

import com.badbears.grosze.httpclient.extractor.TidyXmlParser;

@Component
public class ActionDataExtractor {
	
	private static final String FORMAT = "## #0,00 z³";
	private static final String KWOTA_PRZEBICIA = " s. kwota przebicia ";
	private static final String CZAS_NA_PRZEBICIE = "czas na przebicie ";

	@Autowired
	private TidyXmlParser parser;

	public ActionData extracActionData(Long itemId, String inputString) throws IOException, ParseException {

		Document doc = parser.parseDOM(new ByteArrayInputStream(inputString.getBytes("UTF-8")));
		String actionTitle = parser.parse(doc, "//title");
		String actionName = actionTitle.substring(2 + actionTitle.indexOf("-"));
		String marketPriceString = parser.parse(doc, "//table[@class='savings']/tr[1]/td[2]");
		String shippingCostString = parser.parse(doc, "//div[@class='shipping']/span");
		String rebidsImgString = parser.parse(doc, "//input[@class='bid']/@src");
		String rebidsString = rebidsImgString.substring(rebidsImgString.length()-5, rebidsImgString.length()-4);
		String rebidTimeAmountString = parser.parse(doc, "//div[@class='as_params']");
		String rebidTimeString = rebidTimeAmountString.substring(CZAS_NA_PRZEBICIE.length() + rebidTimeAmountString.indexOf(CZAS_NA_PRZEBICIE), rebidTimeAmountString.indexOf(KWOTA_PRZEBICIA));
		String rebidAmountString = rebidTimeAmountString.substring(KWOTA_PRZEBICIA.length() + rebidTimeAmountString.indexOf(KWOTA_PRZEBICIA));
		Integer rebids = Integer.parseInt(rebidsString);
		Integer rebidTime = Integer.parseInt(rebidTimeString);
		DecimalFormat format = new DecimalFormat(FORMAT);
		format.setParseBigDecimal(true);
		BigDecimal marketPrice = new BigDecimal(format.parse(marketPriceString).toString());
		BigDecimal rebidAmount = new BigDecimal(format.parse(rebidAmountString).toString());
		BigDecimal shippingCost = new BigDecimal(format.parse(shippingCostString).toString());
		
		return new ActionData(itemId, actionName, marketPrice.abs(), shippingCost.abs(), rebidTime, rebidAmount.abs(), rebids);
	}
	
}
