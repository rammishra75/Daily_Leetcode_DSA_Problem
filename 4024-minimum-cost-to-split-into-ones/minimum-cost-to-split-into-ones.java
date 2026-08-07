class Solution {
   
    public int minCost(int n) {
        return n > 1 ? n - 1 + minCost(n - 1) : 0;
    }
}