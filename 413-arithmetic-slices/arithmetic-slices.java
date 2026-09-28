class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        int ans = 0;
        int n = nums.length;
        for(int i = 0; i <= n - 3; i++){
            int diff = nums[i + 1] - nums[i];
            for(int j = i + 1; j < n; j++){
                if(nums[j] - nums[j - 1] != diff){
                    break;
                }
                else{
                    if(j - i + 1 >= 3){
                        ans++;
                    }
                }
            }
        }
        return ans;
    }
}