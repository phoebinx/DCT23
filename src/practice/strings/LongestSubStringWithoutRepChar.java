package practice.strings;

import java.util.HashMap;

public class LongestSubStringWithoutRepChar {
	public static void main(String args[]) {
		LongestSubStringWithoutRepChar obj = new LongestSubStringWithoutRepChar();
		String s = "pwwkew";
		System.out.println(obj.lengthOfLongestSubstring(s));
	}

	public int lengthOfLongestSubstring(String s) {
		if (s.length() == 0)
			return 0;
		if (s.trim().length() == 0)
			return 1;
		HashMap<Character, Integer> map = new HashMap<>();
		int maxLen = 0;
		for (int start = 0, end = 0; end < s.length(); end++) {
			if (map.containsKey(s.charAt(end))) {
				// move start pointer
				start = Math.max(start, map.get(s.charAt(end)) + 1);
			}
			map.put(s.charAt(end), end);
			maxLen = Math.max(maxLen, end - start + 1);
		}
		return maxLen;
	}
}
