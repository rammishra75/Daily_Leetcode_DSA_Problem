class Solution {
    public int findLengthOfLCIS(int[] nums) {
        int n = nums.length;
        int ans = 1;
        if(n == 1) return 1;
        int cnt = 1;
        for(int i = 1; i < n; i++){
            if(nums[i] > nums[i - 1]){
                cnt++;
            }
            else{
                cnt = 1;
            }
            if(cnt > ans){
                ans = cnt;
            }
        }
        return ans;
    }
}