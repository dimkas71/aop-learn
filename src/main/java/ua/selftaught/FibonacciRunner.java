package ua.selftaught;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ua.selftaught.model.FibonacciProducer;

public class FibonacciRunner {

	private static final int DEFAULT_NUMBER = 30;
	
	private static final Logger logger = LoggerFactory.getLogger(FibonacciRunner.class);
	
	public static void main(String[] args) {
		int value = DEFAULT_NUMBER;
		if (args.length == 1) {
			value = Integer.parseInt(args[0].trim());
		}
		
		FibonacciProducer fbp = new FibonacciProducer();
		
		logger.info("Fibonacci for {} -> {}", value, fbp.generate(value));

	}

}
