package Arrays;

public class ProductOfArrayExceptSelf {
	public static void main(String args[]) {
		int nums [] = {1,2,3,4};
		ProductOfArrayExceptSelf obj = new ProductOfArrayExceptSelf();
		int res[] = obj.productExceptSelf(nums);
		for (int num: res)
			System.out.print(num+" ");
	}
	
	public int[] productExceptSelf(int[] nums) {
		int res[] = new int[nums.length];
		res[0] = 1;
		for (int i = 1; i<nums.length; i++) {
			res[i] = res[i-1] * nums[i-1];
		}
		int right = 1;
		for (int j = nums.length-1; j>=0; j--) {
			res[j] = res[j] * right;
			right = right * nums[j];
		}
		return res;
    }

}
