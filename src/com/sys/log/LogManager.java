package com.sys.log;

import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;


public class LogManager {
	private static Logger logger = null;
	private static boolean isInit = false;
	
	private static void initConfig() throws Exception{
		System.setProperty("log.path","c:\\");
		String path = LogManager.class.getResource("").getPath()+"log4j.xml";
		DOMConfigurator.configure(path);
		logger = Logger.getLogger("sys.logger");
		isInit = true;
	}
	
	public static Logger getLogger() throws Exception {
		if(isInit) {
			return logger;
		}else {
			initConfig();
			return logger;
		}
	}
	
}
