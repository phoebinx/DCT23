package practice.arrays;

import java.util.Arrays;

public class productOfArrayExceptSelf {
	public static void main(String args[]) {
		productOfArrayExceptSelf obj = new productOfArrayExceptSelf();
		int nums[] = { 1, 2, 3, 4 };
		for (int num : obj.productExceptSelf(nums)) {
			System.out.print(num + " ");
		}
	}

	public int[] productExceptSelf(int[] nums) {
		int res[] = new int[nums.length];
		  // Initialize the result array with 1s
		Arrays.fill(res, 1);
		// Calculate products of elements to the right of each element
	    for (int i = nums.length - 2; i >= 0; i--) {
			res[i] = res[i + 1] * nums[i + 1];
		}
	    
		int leftProduct = 1;
		// Calculate products of elements to the left of each element and
	    // multiply with the existing values in the result array
		for (int i = 1; i < nums.length; i++) {
			leftProduct = leftProduct * nums[i - 1];
			res[i] = res[i] * leftProduct;
		}
		return res;
	}

}
