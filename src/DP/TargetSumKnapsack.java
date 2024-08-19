package DP;

public class TargetSumKnapsack {

	public static void main(String args[]) {
		TargetSumKnapsack obj = new TargetSumKnapsack();
		int nums[] = {1,1,1,1,1}; int target = 3;
		System.out.println(obj.findTargetSumWays(nums, target));
	}

	public int findTargetSumWays(int[] nums, int target) {
		int [][]mem = new int [nums.length][target+1];
		int curSum = 0;
		for (int i =0 ; i< mem.length; i++) {
			for (int j=0; j<mem[i].length; j++) {
				mem[i][j] = -1;
			}
		}
		return findTargetSumWaysUtil(nums, nums.length-1, curSum, target, mem);
	}

	
	private int findTargetSumWaysUtil(int[] nums, int i, int curSum, int target, int[][] mem) {
		if (curSum > target || curSum < 0) return 0;
		if (i < 0 && target == curSum) return 1;
		if (i<0 ) return 0;
		
		if (mem[i][curSum] != -1) return mem[i][curSum];
		
		int positive = findTargetSumWaysUtil(nums, i-1, curSum+nums[i], target, mem);
		int negative = findTargetSumWaysUtil(nums, i-1, curSum+ -nums[i], target, mem);
		mem[i][curSum] = positive+negative;
		return mem[i][curSum];
	}
}
