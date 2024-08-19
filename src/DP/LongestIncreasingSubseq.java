package DP;

import java.util.Arrays;

public class LongestIncreasingSubseq {
	public static void main(String args[]) {
		LongestIncreasingSubseq obj = new LongestIncreasingSubseq();
		int nums[] = {10,9,2,5,3,7,101,18};
		System.out.println(obj.lengthOfLIS(nums));
	}

	public int lengthOfLIS(int[] nums) {
		int lis[] = new int[nums.length];
		Arrays.fill(lis, 1);
		//starting i from last makes sense because list[last] will always be 1. 
		for (int i = nums.length-1; i>=0; i--) {
			for (int j = i+1; j<nums.length;j++) {
				if (nums[i] < nums[j]) {
					lis[i] = Math.max(lis[i], 1+lis[j]);
				}
			}
		}
		return Arrays.stream(lis).max().getAsInt();
	}
}
