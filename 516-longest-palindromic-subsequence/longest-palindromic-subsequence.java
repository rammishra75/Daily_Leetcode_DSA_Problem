class Solution {
    public int LCS(String s, String t, int n){
        int[][] dp = new int[n + 1][n + 1];
        for(int ind1 = 1; ind1 <= n; ind1++){
            for(int ind2 = 1; ind2 <= n; ind2++){
                if(s.charAt(ind1 - 1) == t.charAt(ind2 - 1)){
                    dp[ind1][ind2] = 1 + dp[ind1 - 1][ind2 - 1];
                }
                else{
                    dp[ind1][ind2] = Math.max(dp[ind1 - 1][ind2], dp[ind1][ind2 - 1]);
                }
            }
        }
        return dp[n][n];
    }
    public int longestPalindromeSubseq(String s) {
        String t = new StringBuilder(s).reverse().toString();
        int n = s.length();
        return LCS(s, t, n);
    }
}