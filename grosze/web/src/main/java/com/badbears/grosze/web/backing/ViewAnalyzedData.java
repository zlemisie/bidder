package com.badbears.grosze.web.backing;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import org.springframework.beans.factory.annotation.Autowired;

import com.badbears.grosze.analyzer.AnalyzedData;
import com.badbears.grosze.analyzer.AnalyzerService;

@ManagedBean
@RequestScoped
public class ViewAnalyzedData {

	@Autowired
	private AnalyzerService analyzerService;
	
	@ManagedProperty(value="#{param.itemId}")
	private Long itemId;
	
	public Long getIt() {
//		AnalyzedData data = analyzerService.analyzeAuction(itemId);
		return itemId;
	}

	public void setItemId(Long itemId) {
		this.itemId = itemId;
	}


}
