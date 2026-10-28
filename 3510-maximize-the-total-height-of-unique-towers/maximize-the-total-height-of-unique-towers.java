class Solution {
    public long maximumTotalSum(int[] maximumHeight) {
        long ans = 0;
        int n = maximumHeight.length;
        Arrays.sort(maximumHeight);
        int allowed_height = Integer.MAX_VALUE;
        for(int i = n - 1; i >= 0; i--){
            int curr = Math.min(maximumHeight[i], allowed_height);
            if(curr > 0){
                allowed_height = curr - 1;
                ans += curr;
            }
            else{
                return -1;
            }
        }
        return ans;
    }
}