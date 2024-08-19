package practice.dp;

public class DecodeWays {
	public static void main(String args[]) {
		DecodeWays obj = new DecodeWays();
		String s = "11106";
		System.out.println(obj.numDecodings(s));
	}

	public int numDecodings(String s) {
		if (s == null || s.length() == 0)
			return 0;

		int n = s.length();
		int dp[] = new int[n + 1];
		dp[n] = 1; // empty string has 1 way to be decoded.

		for (int i = n - 1; i >= 0; i--) {
			if (s.charAt(i) == '0')
				dp[i] = 0;
			else
				// single digit compute
				dp[i] = dp[i + 1];

			// double digit compute
			if (i + 1 < n
					&& (s.charAt(i) == '1' || 
					(s.charAt(i) == '2' && 
					(s.charAt(i + 1) >= '0' && s.charAt(i + 1) <= '6'))))
				dp[i] += dp[i + 2];
		}
		return dp[0];
	}

}
