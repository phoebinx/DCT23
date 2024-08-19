package interviews.intuit;

import java.util.HashMap;

public class Logger {
	HashMap<String, Integer> validityMap;

	public static void main(String args[]) {
		Logger logger = new Logger();
		System.out.println(logger.shouldPrintMessage(1, "foo")); // return true, next allowed timestamp for "foo" is 1 + 10 = 11
		System.out.println(logger.shouldPrintMessage(2, "bar")); // return true, next allowed timestamp for "bar" is 2 + 10 = 12
		System.out.println(logger.shouldPrintMessage(3, "foo")); // 3 < 11, return false
		System.out.println(logger.shouldPrintMessage(8, "bar")); // 8 < 12, return false
		System.out.println(logger.shouldPrintMessage(10, "foo")); // 10 < 11, return false
		System.out.println(logger.shouldPrintMessage(11, "foo")); // 11 >= 11, return true, next allowed timestamp for "foo" is 11 + 10 = 21
	}

	public Logger() {
		validityMap = new HashMap<>();
	}

	public boolean shouldPrintMessage(int timestamp, String message) {
		if (!validityMap.containsKey(message)) {
			validityMap.put(message, timestamp + 10);
			return true;
		} else {
			if (validityMap.get(message) <= timestamp) {
				// update timestamp
				validityMap.put(message, timestamp + 10);
				return true;
			}
		}
		return false;
	}
}
