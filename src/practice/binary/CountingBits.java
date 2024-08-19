package practice.binary;

public class CountingBits {
	public static void main(String args[]) {
		CountingBits obj = new CountingBits();
		int n = 5;
		int[] res = obj.countBits2(n);
		for (int num : res)
			System.out.print(num + " ");
	}

	public int[] countBits2(int n ) {
		if (n == 0) return new int[] {0};
		if (n == 1) return new int [] {0,1};
		int dp[] = new int [n+1];
		dp[0]= 0;
		int offset = 1;
		for (int i = 1; i <=n; i++) {
			if (offset*2==i) offset = i; 
			dp[i] = dp[i-offset]+1;
		}
		return dp;
	}

	public int[] countBits(int n) {
		int res[] = new int[n + 1];
		for (int i = 0; i <= n; i++) {
			res[i] = numberOfSetBits(i);
		}
		return res;
	}

	private int numberOfSetBits(int n) {
		int count = 0;
		while (n != 0) {
			if ((n % 2) == 1)
				count++;
			n = (n >> 1);
		}
		return count;
	}
}
