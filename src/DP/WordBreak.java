package DP;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordBreak {
	public static void main(String args[]) {
		WordBreak obj = new WordBreak();
		String s = "leetcode";
		List<String> wordDict = Arrays.asList("leet", "code");
		System.out.println(obj.wordBreak(s, wordDict));
	}

	public boolean wordBreak(String s, List<String> wordDict) {
		HashSet<String> dict = new HashSet<String>(wordDict);
		boolean dp[] = new boolean[s.length() + 1];
		dp[0] = true;
		for (int i = 1; i <= s.length(); i++) {
			for (int j = 0; j < i; j++) {
				if (dp[j] && dict.contains(s.substring(j, i))) {
					dp[i] = true;
					break;
				}
			}
		}
		return dp[s.length()];
	}
}
