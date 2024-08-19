package practice.arrays;

public class BuySellStock {
	public static void main(String args[]) {
		BuySellStock obj = new BuySellStock();
		int prices[] = {7,1,5,3,6,4};
		System.out.println(obj.maxProfit(prices));
	}
	public int maxProfit(int[] prices) {
		int min = Integer.MAX_VALUE;
		int maxProfit = 0;
		for (int price : prices) {
			if (min > price) {
				min = price;
			}
			maxProfit = Math.max(price-min, maxProfit);
		}
		return maxProfit;
	}
}
