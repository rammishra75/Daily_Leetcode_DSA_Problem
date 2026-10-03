class Solution {
    public int findMaxLength(int[] nums) {
        int ans = 0;
        int n = nums.length;
        int sum = 0;
        HashMap<Integer, Integer> mpp = new HashMap<>();
        for(int i = 0; i < n; i++){
            sum += nums[i] == 0 ? -1: 1;
            if(sum == 0) {
                ans = i +  1;
            }
            else if(mpp.containsKey(sum)){
                ans = Math.max(ans, i - mpp.get(sum));
            }
            else{
                mpp.put(sum , i);
            }
        }
        return ans;
    }
}