package com.badbears.grosze.web.backing;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;

import com.badbears.grosze.analyzer.AnalyzedData;
import com.badbears.grosze.analyzer.AnalyzerService;

@ManagedBean
@RequestScoped
public class ViewAnalyzedData {

	@ManagedProperty("#{analyzerService}")
	private AnalyzerService analyzerService;
	
	@ManagedProperty("#{param.itemId}")
	private Long itemId;
	
	@ManagedProperty("#{userPrefs}")
	private UserPrefs userPrefs;
	
	public Long getIt() {
		return itemId;
	}
	
	public AnalyzedData getAnalyzedData() {
		AnalyzedData data = null;
		if (itemId != null) {
			data = analyzerService.analyzeAuction(itemId);
			userPrefs.setItemId(itemId);
		} else {
			data = analyzerService.analyzeAuction(userPrefs.getItemId());
		}
		return data;
	}

	public void setItemId(Long itemId) {
		this.itemId = itemId;
	}

	public void setAnalyzerService(AnalyzerService analyzerService) {
		this.analyzerService = analyzerService;
	}

	public void setUserPrefs(UserPrefs userPrefs) {
		this.userPrefs = userPrefs;
	}


}
