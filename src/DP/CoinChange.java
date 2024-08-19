package DP;

import java.util.Arrays;

public class CoinChange {
	public static void main(String args[]) {
		CoinChange obj = new CoinChange();
		int coins[] = { 1, 2, 5 }, amount = 11;
		System.out.println(obj.coinChange(coins, amount));
	}

	public int coinChange(int[] coins, int amount) {
		Arrays.sort(coins);
		int mem[] = new int[amount+1];
		Arrays.fill(mem, amount+1);
		mem[0]= 0;
		for (int i = 0; i<=amount; i++) {
			for (int j = 0; j<coins.length; j++) {
				if (i < coins[j]) break;
				mem[i] = Math.min(mem[i], 1+mem[i-coins[j]]);
			}
		}
		return mem[amount] > amount ? -1 : mem[amount];
	}
}
/*
 * 
 * In the "Coin Change" problem, mem[i] represents the minimum number of coins
 * required to make up the amount i using the coin denominations given in the
 * coins array.
 * 
 * Base Case (mem[0] = 0): Interpretation: The minimum number of coins needed to
 * make up the amount 0 is zero coins. You don't need any coins to achieve a sum
 * of zero. Reasoning: The problem is to find the minimum number of coins needed
 * to reach a target amount. Since no coins are needed to make up the amount
 * zero, mem[0] is initialized to 0.
 */