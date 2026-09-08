class Solution {
    public int func(int ind, int buy, int[] prices, int[][] dp, int n){
        if(ind == n) return 0;
        if(dp[ind][buy] != -1){ 
            return dp[ind][buy];
        }
        int profit;
        if(buy == 0){
            profit = Math.max(func(ind + 1 , 0, prices, dp, n) , -prices[ind] + func(ind + 1, 1, prices, dp , n));
        }
        else{
            profit = Math.max(func(ind + 1 , 1, prices, dp, n) , prices[ind] + func(ind + 1, 0, prices, dp , n));
        }
        dp[ind][buy] = profit;
        return dp[ind][buy];
    }
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n][2];
        for(int[] a: dp) Arrays.fill(a, -1);
        return func(0, 0, prices, dp, n);
    }
}