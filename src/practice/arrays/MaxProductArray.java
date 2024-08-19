package practice.arrays;

public class MaxProductArray {
	public static void main(String args[]) {
		MaxProductArray obj = new MaxProductArray();
		int[] nums = { 2, 3, -2, 4 };
		System.out.println(obj.maxProduct(nums));
	}

	public int maxProduct(int[] nums) {
		int minPro, maxPro, res, tempMax;
		minPro = maxPro = res = nums[0];
		for (int i = 1; i<nums.length;i++) {
			int num = nums[i];
			tempMax = maxPro;
			maxPro = Math.max(Math.max(num * maxPro, num * minPro), num);
			minPro = Math.min(Math.min(num * tempMax, num * minPro), num);
			res = Math.max(maxPro, res);
		}
		return res;
	}
}
