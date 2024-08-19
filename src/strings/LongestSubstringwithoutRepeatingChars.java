package strings;

import java.util.HashMap;

public class LongestSubstringwithoutRepeatingChars {
	public static void main(String args[]) {
		LongestSubstringwithoutRepeatingChars obj = new LongestSubstringwithoutRepeatingChars();
		String str = "abcabcbb";
		System.out.println(obj.lengthOfLongestSubstring(str));
	}
	
	public int lengthOfLongestSubstring(String s) {
		if (s.length() == 0) return 0;
		if (s.trim().length() == 0) return 0; 
		HashMap<Character, Integer> visited = new HashMap<>();
		int maxLen = 0;
		
		for (int start = 0, end = 0; end < s.length(); end++) {
			if (visited.containsKey(s.charAt(end))) {
				start = Math.max(start, visited.get(s.charAt(end))+1);
			}
			visited.put(s.charAt(end), end);
			maxLen = Math.max(maxLen, end - start + 1);
		}
		return maxLen;
    }

}
