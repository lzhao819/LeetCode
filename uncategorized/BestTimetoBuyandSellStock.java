//Leetcode 121. Best Time to Buy and Sell Stock
//Say you have an array for which the ith element is the price of a given stock on day i.

//If you were only permitted to complete at most one transaction (i.e., buy one and sell one share of the stock), design an algorithm to find the maximum profit.

//Note that you cannot sell a stock before you buy one.
//time O(n)
//Space O(1)
class Solution {
    public int maxProfit(int[] prices) {
        if(prices ==null) return 0;
        int curMax = 0;
        int globalMax = 0;
        for(int i=1;i<prices.length;i++){
            curMax = Math.max(0, curMax+prices[i]-prices[i-1]);
            globalMax = Math.max(globalMax, curMax);
        }
        return globalMax;
    }
}