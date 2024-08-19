package DP;

public class HouseRobber1 {
	public static void main(String args[]) {
		HouseRobber1 obj = new HouseRobber1();
		int []nums = {2,7,9,3,1};
		System.out.println(obj.rob(nums));
	}

	public int rob(int[] nums) {
		int rob1 = 0, rob2  = 0;
		int temp;
		for (int n :nums) {
			temp = Math.max(rob1+n, rob2);
			rob1 =rob2;
			rob2 = temp;
		}
		return Math.max(rob1, rob2);
	}
}
