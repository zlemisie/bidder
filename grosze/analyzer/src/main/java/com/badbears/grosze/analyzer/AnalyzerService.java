package com.badbears.grosze.analyzer;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.badbears.grosze.db.AnalyzedQueryResult;
import com.badbears.grosze.db.AuctionBidsInfo;
import com.badbears.grosze.db.EntryRepo;
import com.badbears.grosze.db.ItemRepo;
import com.badbears.grosze.db.model.Item;

@Service
public class AnalyzerService {
	
	@Autowired
	private EntryRepo entryRepo;
	
	@Autowired
	private ItemRepo itemRepo;

	public AnalyzedData analyzeAuction(Long itemId) {
		
		Item item = itemRepo.find(itemId);	
		List<AnalyzedQueryResult> analyzedQueryResults = entryRepo.analyze(itemId);
		AuctionBidsInfo auctionBidsInfo = entryRepo.getAuctionBidsInfo(itemId);
		
		return new AnalyzedData(item, analyzedQueryResults, auctionBidsInfo);
	}
}
