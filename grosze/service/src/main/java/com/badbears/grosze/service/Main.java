package com.badbears.grosze.service;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
	
	public static void main(String[] args) {
		System.setSecurityManager(null);
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("classpath*:/spring/context.xml");
		DataCollector dataCollectorService = ctx.getBean(DataCollector.class);
		
		dataCollectorService.collect(489252626L);
	}

}
