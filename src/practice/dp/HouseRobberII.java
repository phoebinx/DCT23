package practice.dp;

import java.util.Arrays;
//rob1: Represents the maximum amount of money you can rob up to the house before the previous one.
//rob2: Represents the maximum amount of money you can rob up to the previous house.
//temp: Temporarily stores the new maximum amount after considering whether to rob the current house.
public class HouseRobberII {
	public static void main(String args[]) {
		HouseRobberII obj = new HouseRobberII();
		int nums[] = { 2, 3, 2 };
		System.out.println(obj.rob(nums));
	}

	public int rob(int[] nums) {
		if (nums.length == 1)
			return nums[0];
		// either take first or last
		return Math.max(robUtil(Arrays.copyOfRange(nums, 0, nums.length - 1)),
				robUtil(Arrays.copyOfRange(nums, 1, nums.length)));
	}

	private int robUtil(int[] nums) {
		int rob1 = 0;
		int rob2 = 0;
		int  temp = 0;
		for (int num : nums) {
			temp = Math.max(rob1+num, rob2);
			rob1 = rob2;
			rob2 = temp;
		}
		return Math.max(rob1, rob2);
	}

}

//The Math.max(rob1 + n, rob2) in the code helps decide whether it's better to include the current house’s value in the total or skip it. This approach ensures you maximize the total amount robbed while adhering to the constraint of not robbing two adjacent houses.
