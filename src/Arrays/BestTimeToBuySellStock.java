package Arrays;

public class BestTimeToBuySellStock {
	public static void main(String args[]) {
		BestTimeToBuySellStock obj = new BestTimeToBuySellStock();
		int prices [] = {7,1,5,3,6,4};
		System.out.println(obj.maxProfit(prices));
	}
	
	public int maxProfit(int[] prices) {
		int min = Integer.MAX_VALUE;
		int maxProfit = 0;
		
		for (int price : prices) {
			if (price < min) {
				min = price;
			} else if (maxProfit < (price-min)) {
				maxProfit = price-min;
			}
		}
		return maxProfit;
    }
}
