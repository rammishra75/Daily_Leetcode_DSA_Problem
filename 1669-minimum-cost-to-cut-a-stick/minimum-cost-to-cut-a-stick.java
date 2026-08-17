class Solution {
    public int func(int i, int j, ArrayList<Integer> cuts, int[][] dp){
        if(i > j) return 0;
        if(dp[i][j] != -1) return dp[i][j];
        int mini = Integer.MAX_VALUE;
        for(int ind = i; ind <= j; ind++){
            int ans = cuts.get(j + 1) - cuts.get(i - 1) + func(i, ind - 1, cuts, dp) + func(ind + 1, j, cuts, dp);
            mini = Math.min(mini, ans);
        }
        return dp[i][j] = mini;
    }
    public int minCost(int n, int[] cuts) {
        int m = cuts.length;
        ArrayList<Integer> cut = new ArrayList<>();
        for(int i : cuts) cut.add(i); 
        cut.add(0);
        cut.add(n);
        Collections.sort(cut);
        int[][] dp = new int[m + 1][m + 1];
        for(int[] row: dp) Arrays.fill(row, -1);
        return func(1, m, cut, dp);
    }
}