package ua.selftaught.aop;

import java.util.concurrent.TimeUnit;

import org.aspectj.lang.ProceedingJoinPoint;

public class AccountProfiler {
	
	public Object profile(ProceedingJoinPoint pjp) throws Throwable {
		long start = System.nanoTime();
		
		String methodName  = pjp.getSignature().getName();
		
		try {
			return pjp.proceed();
		} finally {
			long stop = System.nanoTime(); 
			System.out.println(String.format("Method -> Account.%s Interval(microseconds) - %d", methodName, TimeUnit.NANOSECONDS.toMicros(stop-start)));
		}
	}
	
}
