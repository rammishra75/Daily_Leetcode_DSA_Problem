class Solution {
    public int[][] divideArray(int[] nums, int k) {
        int n = nums.length;
        Arrays.sort(nums);
        int[][] ans = new int[n / 3][3];
        for(int i = 0; i < n; i++){
            int r = i / 3;
            int c = i % 3;
            ans[r][c] = nums[i];
            if(c == 2){
                if(ans[r][2] - ans[r][0] > k){
                    return new int[0][0];
                }
            } 
        }
        return ans;
    }
}