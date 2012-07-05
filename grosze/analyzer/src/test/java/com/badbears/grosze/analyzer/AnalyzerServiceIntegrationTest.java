package com.badbears.grosze.analyzer;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath*:/spring/context.xml")
public class AnalyzerServiceIntegrationTest {

	@Autowired
	private AnalyzerService analyzerService;
	
	@Test
	public void testAnalyzeAuction() {
		long auctionId = 489199985L;
		AnalyzedData analyzedData = analyzerService.analyzeAuction(auctionId);
		System.out.println(analyzedData);
	}
	
}
