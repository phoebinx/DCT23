package practice.graph;

import java.util.Arrays;
import java.util.HashSet;

public class LongestConsecutiveSeq {
	public static void main(String args[]) {
		LongestConsecutiveSeq obj = new LongestConsecutiveSeq();
		int nums[] = {100,4,200,1,3,2};
		System.out.println(obj.longestConsecutive(nums));
	}
	
	public int longestConsecutive(int[] nums) {
		HashSet<Integer> set = new HashSet<>(Arrays.stream(nums).boxed().toList());
		int maxCount = 0;
		for (int num : set) {
			if (!set.contains(num-1)) { //first element of set
				int count = 1;
				num++;
				while (set.contains(num)) {
					count++;
					num++;
				}
				maxCount = Math.max(maxCount, count);
			}
		}
		return maxCount;
	}
}
//the "Longest Consecutive Sequence" problem is considered a graph problem because it involves finding the longest path in a graph formed by nodes (numbers) connected by edges (consecutive relationships). The concepts of connectivity and traversal in this implicit graph align with graph theory principles, making it natural to approach the problem with graph-based thinking.
