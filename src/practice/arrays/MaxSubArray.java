package practice.arrays;

public class MaxSubArray {
	public static void main(String args[]) {
		MaxSubArray obj = new MaxSubArray();
		int nums[] = {-2,1,-3,4,-1,2,1,-5,4};
		System.out.println(obj.maxSubArray(nums));
	}
	public int maxSubArray(int[] nums) {
		int curSum = 0;
		int maxSum = nums[0];// not 0 since array can have -ive values
		for (int num : nums) {
			curSum += num; 
			if (curSum < 0 ) curSum = 0;// ignore negative prefix
			maxSum = Math.max(curSum, maxSum);
		}
		return maxSum;
	}
}
