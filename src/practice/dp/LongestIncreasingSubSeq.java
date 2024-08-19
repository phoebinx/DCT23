package practice.dp;

import java.util.Arrays;

public class LongestIncreasingSubSeq {
	public static void main(String args[]) {
		LongestIncreasingSubSeq obj = new LongestIncreasingSubSeq();
		int nums[] = { 10, 9, 2, 5, 3, 7, 101, 18 };
		System.out.println(obj.lengthOfLIS(nums));
	}

	public int lengthOfLIS(int[] nums) {
		int mem[] = new int[nums.length];
		Arrays.fill(mem, 1);
		for (int i = nums.length - 1; i >= 0; i--) {
			for (int j = i + 1; j < nums.length; j++) {
				if (nums[i] < nums[j]) {
					mem[i] = Math.max(mem[i], 1 + mem[j]);
				}
			}
		}
		return Arrays.stream(mem).max().getAsInt();
	}
}
