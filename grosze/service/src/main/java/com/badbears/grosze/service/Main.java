package com.badbears.grosze.service;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
	
	// -javaagent:C:\Users\zlemisie\.m2\repository\org\springframework\spring-instrument\3.1.0.RELEASE\spring-instrument-3.1.0.RELEASE.jar
	// -XX:-UseSplitVerifier
	
	public static void main(String[] args) {
		System.setSecurityManager(null);
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("classpath*:/spring/context.xml");
		DataCollector dataCollectorService = ctx.getBean(DataCollector.class);
		
		dataCollectorService.collect("http://za10groszy.pl/auction/pakiet_bidow_plus_489567123.html");
	}

}
