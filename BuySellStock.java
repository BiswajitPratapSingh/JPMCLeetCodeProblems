/* 121. Best Time to Buy and Sell Stock
You are given an array prices where prices[i] is the price of a given stock on the ith day.

You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.

Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.



Example 1:

Input: prices = [7,1,5,3,6,4]
Output: 5
Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
Note that buying on day 2 and selling on day 1 is not allowed because you must buy before you sell.
Example 2:

Input: prices = [7,6,4,3,1]
Output: 0
Explanation: In this case, no transactions are done and the max profit = 0.


Constraints:

1 <= prices.length <= 105
0 <= prices[i] <= 104

Approach
1. Initialize variables buy with the first element of the prices array and profit as 0.
2. Iterate through the prices starting from the second element.
3. Update the buy variable if the current price is lower than the current buying price.
4. Update the profit if the difference between the current price and the buying price is greater than the current profit.
5. Return the final profit.

*/
class BuySellStock {
    public int maxProfit(int[] prices) {
       int buy = prices[0];
       int profit = 0;

       if(prices.length <= 1) {
        return profit;
       } else {
         for(int i = 1; i < prices.length; i++) {
            if(prices[i] < buy) {
                buy = prices[i];
            } else if((prices[i] - buy) > profit){
                profit = prices[i] - buy ;
            }
         }
       }
    return profit;
    }
}
