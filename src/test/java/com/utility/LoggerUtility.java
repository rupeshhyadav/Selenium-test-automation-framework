package com.utility;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

public class LoggerUtility {

	private LoggerUtility() {
	}

	public static Logger getLogger(Class<?> clazz) {
		 Logger logger = null;
		if (logger == null) {
			logger = LogManager.getLogger(clazz);
		}
		return logger;
	}

}
