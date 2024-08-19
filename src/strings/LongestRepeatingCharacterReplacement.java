package strings;

import java.util.HashMap;
import java.util.Map;

public class LongestRepeatingCharacterReplacement {
	public static void main(String args[]) {
		LongestRepeatingCharacterReplacement obj = new LongestRepeatingCharacterReplacement();
		String s = "ABAB";
		int k =2;
		System.out.println(obj.characterReplacement(s, k));
				
	}

	public int characterReplacement(String s, int k) {
		int res = 0;
		HashMap<Character, Integer> map = new HashMap<>();
		for (int l =0, r= 0; r<s.length(); r++) {
			map.put(s.charAt(r), map.getOrDefault(s.charAt(r), 0)+1);
			while (((r-l+1)- maxFreq(map)) > k) {
				map.put(s.charAt(l), map.get(s.charAt(l))-1); // decrement the frequency of l char
				l ++;
			}
			res = Math.max(res, r-l+1);
		}
		return res;
	}
	
	public int maxFreq(HashMap<Character, Integer> map) {
		int max = 0;
		for (int freq : map.values()) {
			max = Math.max(max, freq);
		}
		return max;
	}

}
