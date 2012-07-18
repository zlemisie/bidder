package com.badbears.grosze.service;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
	
	// -javaagent:C:\Users\zlemisie\.m2\repository\org\springframework\spring-instrument\3.1.0.RELEASE\spring-instrument-3.1.0.RELEASE.jar
	// -XX:-UseSplitVerifier
	
	public static void main(String[] args) {
		System.setSecurityManager(null);
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("classpath*:/spring/context.xml");
		DataCollector dataCollectorService = ctx.getBean(DataCollector.class);
		
		dataCollectorService.collect("http://www3.za10groszy.pl/auction/komplet_4_opon_dunlop_sp_sport_01_490671086.html");
	}

}
