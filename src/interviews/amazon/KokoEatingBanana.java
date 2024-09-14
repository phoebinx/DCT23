package interviews.amazon;

//https://leetcode.com/problems/koko-eating-bananas/
public class KokoEatingBanana {
	public static void main(String args[]) {
		KokoEatingBanana obj = new KokoEatingBanana();
		int[] piles = { 3, 6, 7, 11 };
		int h = 8;
		System.out.println(obj.minEatingSpeed(piles, h));
	}

	public int minEatingSpeed(int[] piles, int h) {
		int maxArr = FindMax(piles);
		int l = 1, r = maxArr;
		int res = maxArr;

		while (l <= r) {
			int k = l + (r - l) / 2;
			int hours = 0;
			for (int pile : piles) {
				hours += pile / k;
				if (pile % k != 0) {
					hours++;
				}
			}
			if (hours <= h) {
				res = k;
				r = k - 1;
			} else {
				l = k + 1;
			}
		}
		return res;
	}

	private int FindMax(int[] piles) {
		int max = Integer.MIN_VALUE;
		for (int pile : piles) {
			if (pile > max)
				max = pile;
		}
		return max;
	}
}
