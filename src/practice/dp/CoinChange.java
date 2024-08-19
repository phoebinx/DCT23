package practice.dp;

import java.util.Arrays;

public class CoinChange {
	public static void main(String args[]) {
		CoinChange obj = new CoinChange();
		int [] coins = {1,2,5};
		int amount = 11;
		System.out.println(obj.coinChange(coins, amount));
	}

	public int coinChange(int[] coins, int amount) {
		Arrays.sort(coins);
		int mem[] = new int[amount+1];
		Arrays.fill(mem, amount+1);
		mem[0] = 0;
		for (int i = 0; i<=amount; i++) {
			for (int j = 0; j<coins.length;j++) {
				if (i < coins[j]) continue;
				mem[i] = Math.min(mem[i],mem[i-coins[j]]+1);
			}
		}
		return mem[amount] >= amount+1 ? -1 : mem[amount];
	}
}
