package interviews.amazon;

public class BestTimeToBuySellStockII {
	public static void main(String args[]) {
		BestTimeToBuySellStockII obj = new BestTimeToBuySellStockII();
		int prices[] =  {7,1,5,3,6,4};
		System.out.println(obj.maxProfit(prices));
	}

	public int maxProfit(int[] prices) {	
		//idea it to add to profit whenever there is an increase in price
		int profit = 0;
		
		for (int i = 1; i < prices.length; i++) {
			if (prices[i] > prices[i-1]) {
				profit += prices[i] - prices[i-1];
			}
		}
		return profit;
	}
}
