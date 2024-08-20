package interviews.intuit;

public class CheckSum {
	public static void main(String args[]) {
		CheckSum obj = new CheckSum();
		String str = "5 7 8 9 \n 8 7 6 \n 4 5 6";
		System.out.println(obj.getCheckSum(str));
	}

	private int getCheckSum(String str) {
		int total = 0;
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;

		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);

			// if c is a digit
			if (c >= '0' && c <= '9') {
				int num = c - '0';
				min = Math.min(min, num);
				max = Math.max(max, num);
			}
			// Handle newline or end of string
			if (c == '\n' || i == str.length() - 1) {
				// Add the min and max values for the current row
				if (min != Integer.MAX_VALUE && max != Integer.MIN_VALUE) {
					total += (min + max);
				}
				// reset min and max
				min = Integer.MAX_VALUE;
				max = Integer.MIN_VALUE;
			}
		}
		return total;
	}

}
