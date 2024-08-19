package practice.binary;

import java.util.Arrays;

public class MissingNumber {
	public static void main(String args[]) {
		MissingNumber obj = new MissingNumber();
		int[] nums = { 3, 0, 1 };
		System.out.println(obj.missingNumber(nums));
	}

	public int missingNumber(int[] nums) {
		// sum of n numbers - sum of nums array
		int n = nums.length;
		int TSum = (n * (n + 1)) / 2;
		int numsSum = 0;
		for (int num : nums)
			numsSum += num;
		
		return TSum-numsSum;
	}
}
