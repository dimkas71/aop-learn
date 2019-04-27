package ua.selftaught.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoggingAdvice {
	
	private static final Logger logger = LoggerFactory.getLogger(LoggingAdvice.class);
	
	public Object logging(ProceedingJoinPoint pjp) throws Throwable {
		
		Object[] args = pjp.getArgs();
		
		logger.info("Account.{}({})", pjp.getSignature().getName(), args != null ? args[0] : "null");
		
		Object result = pjp.proceed();
		
		logger.info("Result {}", result);
		
		return result;
	}

}
