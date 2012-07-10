package com.badbears.grosze.analyzer;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

//@ RunWith(SpringJUnit4ClassRunner.class)
//@ ContextConfiguration(locations="classpath*:/spring/context.xml")
public class AnalyzerServiceIntegrationTst {

	@Autowired
	private AnalyzerService analyzerService;
	
	//@Test
	public void testAnalyzeAuction() {
		long auctionId = 489567123L;
		AnalyzedData analyzedData = analyzerService.analyzeAuction(auctionId);
		System.out.println(analyzedData);
	}
	
	public void testTrue() {
		return;
	}
	
}
