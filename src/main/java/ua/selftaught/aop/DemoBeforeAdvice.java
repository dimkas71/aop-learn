package ua.selftaught.aop;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DemoBeforeAdvice {
	
	private static final Logger logger = LoggerFactory.getLogger(DemoBeforeAdvice.class);
	
	public void before() {
		logger.info("before advicing");
	}

	
	

}
