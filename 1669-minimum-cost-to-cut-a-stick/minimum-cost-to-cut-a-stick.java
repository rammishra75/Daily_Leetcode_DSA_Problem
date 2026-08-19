class Solution {
    public int minCost(int n, int[] cuts) {
        int m = cuts.length;
        ArrayList<Integer> cut = new ArrayList<>();
        for(int i : cuts) cut.add(i); 
        cut.add(0);
        cut.add(n);
        Collections.sort(cut);
        int[][] dp = new int[m + 2][m + 2];
        for(int[] row: dp) Arrays.fill(row , 0);
        for(int i = m; i >= 1; i--){
            for(int j = 1; j <= m; j++){
                if(i > j) continue;
                int mini = Integer.MAX_VALUE;
                for(int ind = i; ind <= j; ind++){
                    int ans = cut.get(j + 1) - cut.get(i - 1) + dp[i][ind - 1] + dp[ind + 1][j];
                    mini = Math.min(ans, mini);
                }
                dp[i][j] = mini;
            }
        }
        return dp[1][m];
    }
}