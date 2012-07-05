package com.badbears.grosze.analyzer;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.badbears.grosze.db.EntryRepo;
import com.badbears.grosze.db.ItemRepo;
import com.badbears.grosze.db.model.Entry;
import com.badbears.grosze.db.model.Item;

@Service
public class AnalyzerService {
	
	@Autowired
	private EntryRepo entryRepo;
	
	@Autowired
	private ItemRepo itemRepo;

	public AnalyzedData analyzeAuction(Long auctionId) {
		AnalyzedData data = new AnalyzedData();
		
		Item item = itemRepo.find(auctionId);
		List<Entry> entries = entryRepo.find(auctionId);
		
		return data;
	}
}
