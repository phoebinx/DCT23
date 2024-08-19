package Arrays;

// maintain a min and a max, use min and max to compute new max since current number could be negative and min could be negative making the number positive

public class MaximumProductSubarray {
	
	public static void main(String args[]) {
		MaximumProductSubarray obj = new MaximumProductSubarray();
		int nums [] = {2,0,-1, -6};
		System.out.println(Integer.toString(obj.maxProduct(nums)));
	}
	
	public int maxProduct(int[] nums) {
		int curMin, curMax, res, tempMax;
		curMin = curMax = res = nums[0];
        for (int i = 1; i< nums.length; i++) {
        	tempMax = curMax;
        	curMax = Math.max(Math.max(curMax*nums[i], curMin*nums[i]), nums[i]);
        	curMin = Math.min(Math.min(tempMax*nums[i], curMin*nums[i]), nums[i]);
        	res = Math.max(curMax, res);
        }
        return res;
    }

}
