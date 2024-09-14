package interviews.tiktok;

public class SubarrayWithElementsGreaterThanVaryingThreshold {
	public static void main(String args[]) {
		SubarrayWithElementsGreaterThanVaryingThreshold obj = new SubarrayWithElementsGreaterThanVaryingThreshold();
		int nums[] = { 1, 3, 4, 3, 1 };
		int threshold = 6;
		System.out.println(obj.validSubarraySize(nums, threshold));
	}

	public int validSubarraySize(int[] nums, int threshold) {
		for (int k = 1; k < nums.length; k++) {
			//calculate target threshold/k for this length k
			double target = (double) threshold/k;
			//use sliding window to check subarrays of size k 
			for (int i = 0; i < nums.length-k; i++) {
				boolean valid = true;
				//check if all elements in the current sub array(i, i+k) is > target
				for (int j = i; j<i+k; j++) {
					if (nums[j] <= target) {
						valid = false;
						break;
					}
				}
				//if valid subarray is found
				if (valid) {
					return k;
				}
			}
		}
		return -1;
	}
}
