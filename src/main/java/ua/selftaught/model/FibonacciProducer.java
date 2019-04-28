package ua.selftaught.model;

import java.util.HashMap;
import java.util.Map;

public class FibonacciProducer {
	
	private Map<Long, Object> cache = new HashMap<>();
	
	public long generate(long from) {
		if (from < 0) {
			throw new RuntimeException("The value is less than 0. Operations with a negative value are not supported");
		}
		
		if (from <= 1L) return 1L;
		
		return this.generate(from - 2) + this.generate(from - 1);
	}
	
	public long generateCached(long from) {
		if (from < 0) {
			throw new RuntimeException("The value is less than 0. Operations with a negative value are not supported");
		}
		
		if (from <= 1L) return 1L;
		
		Object cachedValue = cache.get(from);
		
		if (cachedValue == null) {
			cachedValue = generateCached(from - 2) + generateCached(from - 1);
			cache.put(from, cachedValue);
		}
		
		return (long)cachedValue;
	}

}
