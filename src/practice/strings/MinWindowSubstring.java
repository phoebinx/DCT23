package practice.strings;

import java.util.HashMap;

public class MinWindowSubstring {
	public static void main(String args[]) {
		MinWindowSubstring obj = new MinWindowSubstring();
		String s = "ADOBECODEBANC";
		String t = "ABC";
		System.out.println(obj.minWindow(s, t));
	}

	public String minWindow(String s, String t) {
		 // If t is empty, no valid window can exist, so return an empty string.
        if (t == null || t.length() == 0) return "";

        // Create a frequency map for characters in t.
        HashMap<Character, Integer> tMap = new HashMap<>();
        HashMap<Character, Integer> window = new HashMap<>();

        // Populate tMap with the frequency of each character in t.
        for (char c : t.toCharArray()) {
            tMap.put(c, tMap.getOrDefault(c, 0) + 1);
        }

        // Variables to track how many characters we've matched in the current window.
        int have = 0;          // How many unique characters from t are fully matched in the current window.
        int need = tMap.size(); // The number of unique characters in t that we need to match.

        // Result array to store the start and end indices of the minimum window.
        int[] res = {-1, -1};
        int resLen = Integer.MAX_VALUE; // Length of the minimum window found.

        // Left pointer for the sliding window.
        int l = 0;

        // Iterate over the string s with the right pointer.
        for (int r = 0; r < s.length(); r++) {
            char c = s.charAt(r);
            // Add the current character to the window map and increase its count.
            window.put(c, window.getOrDefault(c, 0) + 1);

            // Check if the current character matches the frequency required in tMap.
            if (tMap.containsKey(c) && window.get(c).intValue() == tMap.get(c).intValue()) {
                have++;
            }

            // When we have all required characters fully matched, try to shrink the window.
            while (have == need) {
                // If the current window is smaller than the previously found smallest window, update the result.
                if ((r - l + 1) < resLen) {
                    res[0] = l;
                    res[1] = r;
                    resLen = r - l + 1;
                }

                // The left character that will be removed from the window.
                char leftChar = s.charAt(l);
                // Reduce the count of the left character in the window map.
                window.put(leftChar, window.get(leftChar) - 1);

                // If after removing the left character, the window no longer satisfies the condition, reduce `have`.
                if (tMap.containsKey(leftChar) && window.get(leftChar) < tMap.get(leftChar)) {
                    have--;
                }

                // Move the left pointer to the right to try and find a smaller valid window.
                l++;
            }
        }

        // If resLen was updated from its initial value, return the substring that corresponds to the minimum window.
        return resLen != Integer.MAX_VALUE ? s.substring(res[0], res[1] + 1) : "";
    }
}
