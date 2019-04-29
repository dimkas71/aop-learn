package ua.selftaught.aspectj;

import java.util.HashMap;
import java.util.Map;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Aspect
public class CachingAspect {
	
	private static final Logger logger = LoggerFactory.getLogger(CachingAspect.class);
	
	private Map<String, Object> cache = new HashMap<>();
	
	@Pointcut("execution(* *.*(long)) && args(val)")
	void generateExecution(long val) {}
	
	@Around("generateExecution(val)")
	public Object generateAdvice(long val, ProceedingJoinPoint pjp) throws Throwable {
		
		String key = String.format("Key %d", val);
		
		Object value = cache.get(key);
		if (value == null) {
			logger.debug("{}", key);
			value = pjp.proceed(new Object[] {val});
			cache.put(key, value);
		}
		
		return value;
	}

}
