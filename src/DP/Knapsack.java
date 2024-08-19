package DP;

public class Knapsack {
	public static void main(String args[]) {
		Knapsack obj = new Knapsack();
		int profit[] = { 60, 100, 120 };
		int weight[] = { 10, 20, 30 };
		int W = 50;
		int n = profit.length-1;
		int mem[][] = new int[weight.length][W+1];
		for (int i = 0; i<mem.length; i++) {
			for (int j = 0; j< mem[i].length; j++) {
				mem[i][j] = -1;
			}
		}
		System.out.println(obj.knapSack(W, weight, profit, n, mem));
	}

	private int knapSack(int W, int[] weight, int[] profit, int n, int[][] mem) {
		if (n == 0 || W == 0)
			return 0;
	
		if (mem[n][W] != -1)
			return mem[weight[n]][W];

		if (weight[n] > W)
			return knapSack(W, weight, profit, n - 1, mem);

		mem[n][W] = Math.max(profit[n] + knapSack(W - weight[n], weight, profit, n - 1, mem),
				knapSack(W, weight, profit, n - 1, mem));
		return mem[n][W];
	}

}
