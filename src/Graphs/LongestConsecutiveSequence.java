package Graphs;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class LongestConsecutiveSequence {
	public static void main(String args[]) {
		LongestConsecutiveSequence obj = new LongestConsecutiveSequence();
		int nums[] = { 100, 4, 200, 1, 3, 2 };
		System.out.println(obj.longestConsecutive(nums));
	}

	public int longestConsecutive(int[] nums) {
		Set<Integer> numSet = Arrays.stream(nums).boxed().collect(Collectors.toSet());
		int maxLen = 0; 
		for ( int num : numSet) {
			if (!numSet.contains(num-1)) { //start of a sequence
				int len = 1;
				while(numSet.contains(num+1)) {
					++len;
					++num;
				}
				maxLen = Math.max(len, maxLen);
			}
		}
		return maxLen;
	}
}
