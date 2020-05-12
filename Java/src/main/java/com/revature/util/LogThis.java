package com.revature.util;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LogThis {
	
	static Logger logger = LogManager.getLogger();
	
	
	public static void LogIt(String level, String message) {
		/*
		 * debug
		 * warn
		 * error
		 * fatal
		 * info
		 * trace
		 * 
		 */
		switch (level){
		case "debug":
			logger.debug(message);
			break;
		case "warn":
			logger.warn(message);
			break;
		case "error":
			logger.error(message);
			break;
		case "fatal":
			logger.fatal(message);
			break;
		case "info":
			logger.info(message);
			break;
		case "trace":
			logger.trace(message);
			break;
		default:
			System.out.println("logger dumb");

		}
	}

}
