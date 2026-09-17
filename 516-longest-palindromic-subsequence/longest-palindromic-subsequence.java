class Solution {
    public int LCS(String s, String t, int i, int j, int[][] dp){
        if(i < 0 || j < 0){
            return 0;
        }
        
        if(dp[i][j] != -1) return dp[i][j];
        if(s.charAt(i) == t.charAt(j)){
            dp[i][j] = 1 + LCS(s, t, i - 1, j - 1, dp);
        }
        else{
            dp[i][j] = Math.max(LCS(s, t, i - 1, j, dp), LCS(s, t, i, j - 1, dp));
        }
        return dp[i][j];
    }
    public int longestPalindromeSubseq(String s) {
        String t = new StringBuilder(s).reverse().toString();
        int n = s.length();
        int[][] dp = new int[n][n];
        for(int[] a : dp){
            Arrays.fill(a, -1);
        }
        return LCS(s, t, n - 1, n - 1, dp);
    }
}