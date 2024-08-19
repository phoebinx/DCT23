package DP;

import java.util.Arrays;

// we are starting from the end, dp[n-1] = 1 if it is valid. 
public class DecodeWays {
	public static void main(String args[]) {
		DecodeWays obj = new DecodeWays();
		String s = "226";
		System.out.println(obj.numDecodings(s));
	}

	public int numDecodings(String s) {
		if (s == null || s.length() == 0)
			return 0;

		int n = s.length();
		int dp[] = new int[n + 1];
		dp[n] = 1; // Base case: an empty string has one way to be decoded.

		String validSecondDigit = "0123456";
		for (int i = n - 1; i >= 0; i--) {

			if (s.charAt(i) == '0')
				dp[i] = 0; // No valid encoding starts with '0'.
			else
				dp[i] = dp[i + 1]; // Single digit decode.

			// Check if a two-digit decode is possible.
			if (i + 1 < n && (s.charAt(i) == '1'
					|| (s.charAt(i) == '2' && s.charAt(i + 1) >= '0' && s.charAt(i + 1) <= '6'))) {
				dp[i] += dp[i + 2];
			}
		}
		return dp[0];
	}
}
