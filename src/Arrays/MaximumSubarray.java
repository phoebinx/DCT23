package Arrays;

public class MaximumSubarray {
	public static void main(String args[]) {
		MaximumSubarray obj = new MaximumSubarray();
		int nums[] = {-2,1,-3,4,-1,2,1,-5,4};
		System.out.println(Integer.toString(obj.maxSubArray(nums)));
	}
	public int maxSubArray(int[] nums) {
        int maxSum = nums[0]; // not 0 since array can have -ive values
        int curSum = 0;
        
        for (int num : nums) {
        	if (curSum < 0) curSum = 0; // ignore negative prefix
        	curSum = curSum + num;
        	maxSum = Math.max(maxSum, curSum);
        }
        return maxSum;
    }

}
