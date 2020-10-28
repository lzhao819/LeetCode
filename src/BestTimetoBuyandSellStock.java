//Leetcode 121. Best Time to Buy and Sell Stock
//Say you have an array for which the ith element is the price of a given stock on day i.

//If you were only permitted to complete at most one transaction (i.e., buy one and sell one share of the stock), design an algorithm to find the maximum profit.

//Note that you cannot sell a stock before you buy one.
//time O(n)
//Space O(1)
class BestTimetoBuyandSellStock {
    public int maxProfit(int[] prices) {
        int minCost = Integer.MAX_VALUE, maxProfit = 0;
        for(int price : prices) {
            minCost = Math.min(minCost, price);
            maxProfit = Math.max(maxProfit, price - minCost);
        }
        return maxProfit;
    }
}