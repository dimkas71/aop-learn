package ua.selftaught.aop;

import java.util.HashMap;
import java.util.Map;


import org.aspectj.lang.ProceedingJoinPoint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CachingAdvice {
	
	private static final Logger logger = LoggerFactory.getLogger(CachingAdvice.class);
	
	private Map<Long, Object> cache = new HashMap<>();
	
	public Object caching(ProceedingJoinPoint pjp, long from) throws Throwable {
		
		logger.info("From {}", from);
		
		Object cachedValue = cache.get(from);
		if (cachedValue == null) {
			
			cachedValue = pjp.proceed(new Object[] {from});
			cache.put(from, cachedValue);
			
		}
		
		return cachedValue;
		
	}

}
