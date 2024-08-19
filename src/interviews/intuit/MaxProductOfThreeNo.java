package interviews.intuit;

import java.util.Arrays;

public class MaxProductOfThreeNo {
	public static void main(String args[]) {
		MaxProductOfThreeNo obj = new MaxProductOfThreeNo();
		int nums[] = { 1, 2, 3, 4 };
		System.out.println(obj.maximumProduct(nums));
	}

	public int maximumProduct(int[] nums) {
		Arrays.sort(nums);
		int n = nums.length;
		return Math.max(nums[n-1]*nums[n-2]*nums[n-3],nums[0]*nums[1]*nums[n-1]);
	}
}
