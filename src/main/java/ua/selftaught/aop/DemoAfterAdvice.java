package ua.selftaught.aop;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DemoAfterAdvice {
	
	private static final Logger logger = LoggerFactory.getLogger(DemoAfterAdvice.class);
	
	public void after() {
		logger.info("After advice: this method is called after method that returns BigDecimal, balance for example");
	}

}
