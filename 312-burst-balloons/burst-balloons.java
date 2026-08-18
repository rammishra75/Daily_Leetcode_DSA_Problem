class Solution {
    public int helper(int i, int j, List<Integer> arr, int[][] dp){
        if(i > j) return 0;
        if(dp[i][j] != -1) return dp[i][j];
        int cost = Integer.MIN_VALUE;
        for(int ind = i; ind <= j; ind++){
            int val = arr.get(i - 1) * arr.get(ind) * arr.get(j + 1) + helper(i, ind - 1, arr, dp) + helper(ind + 1, j, arr, dp);
            cost = Math.max(cost, val);
        }
        return dp[i][j] = cost;
    }
    public int maxCoins(int[] nums) {
        int n = nums.length;
        List<Integer> arr = new ArrayList<>();
        arr.add(1);
        for(int i : nums) arr.add(i);
        arr.add(1);
        int[][] dp = new int[n + 1][n + 1];
        for(int[] a: dp) Arrays.fill(a, -1);
        return helper(1, n, arr, dp);
    }
}