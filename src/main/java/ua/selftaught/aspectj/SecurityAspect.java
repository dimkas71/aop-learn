package ua.selftaught.aspectj;

import java.util.HashMap;
import java.util.Map;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ua.selftaught.aspectj.exception.SecurityAspectException;

@Aspect
public class SecurityAspect {

	public enum ROLE {
		ADMIN,
		USER;
	}
	
	private static final Logger logger = LoggerFactory.getLogger(SecurityAspect.class);
	
	private static final int THRESHOLD = 50;
	
	private static final Map<String, ROLE> ACCOUNTS = new HashMap<>();
	static {
		ACCOUNTS.put("Dimkas", ROLE.ADMIN);
		ACCOUNTS.put("Peter", ROLE.USER);
	}
	
	@Pointcut("execution(* ua.selftaught.model.FibonacciProducer.generate(long)) && args(val)")
	void executionGenerate(long val) {}
	
	@Before("executionGenerate(val)")
	public void beforeCallGenerate(long val) {
		logger.debug("Value -> {}", val);
		if (val > THRESHOLD) {
			//Check security
			String user = System.getProperty("user");
			logger.debug("{}", user);
			ROLE role = ACCOUNTS.get(user == null ? "" : user.trim());
			logger.debug("{}", role);
			if ((role == null) || (role != ROLE.ADMIN)) {
				throw new SecurityAspectException(String.format("Security access: calling fibonacci for value %d > %d allowed only for admins", val, THRESHOLD));
			}
			
		}
		
		
		
	}
	

}
