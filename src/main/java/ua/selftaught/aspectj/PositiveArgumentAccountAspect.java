package ua.selftaught.aspectj;

import java.math.BigDecimal;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Aspect
public class PositiveArgumentAccountAspect {
	
	private static final Logger logger = LoggerFactory.getLogger(PositiveArgumentAccountAspect.class);
	
	@Pointcut(value = "execution(public void ua.selftaught.model.Account.*(java.math.BigDecimal))")
	private void checkArgumentPointcut() {}
	
	@Around(value = "checkArgumentPointcut()")
	public Object checkingArgument(ProceedingJoinPoint pjp) throws Throwable {
		BigDecimal value = (BigDecimal)pjp.getArgs()[0];
		logger.info("Method {} called with argument {}", pjp.getSignature().getName(), value);
		
		if (value.compareTo(BigDecimal.ZERO) < 0) {
			throw new IllegalArgumentException("Value should be greater or equal to zero");
		}
		
		return pjp.proceed();
	}
	
}
