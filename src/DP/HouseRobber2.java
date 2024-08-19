package DP;

import java.util.Arrays;

public class HouseRobber2 {
	
	public static void main(String args[]) {
		HouseRobber2 obj = new HouseRobber2();
		int nums[] = {1,2,3,1};
		System.out.println(obj.rob(nums));
	}
	
	public int rob(int[] nums) {
		if (nums.length == 1) return nums[0];
		return Math.max(robUtil(Arrays.copyOfRange(nums, 0, nums.length-1)), robUtil(Arrays.copyOfRange(nums, 1, nums.length)));
	}
	
	public int robUtil(int [] nums) {
		int rob1 = 0, rob2 = 0;
		int temp;
		for (int n : nums) {
			temp = Math.max(n+rob1, rob2);
			rob1 = rob2;
			rob2 = temp;
		}
		return Math.max(rob1, rob2);
	}

}
