class Solution {
    public long maxAlternatingSum(int[] nums) {
        long ans = 0;
        int n = nums.length;
        int[] arr = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = Math.abs(nums[i]);
        }
        Arrays.sort(arr);
        for(int i = 0; i < n; i++){
            if(i < n / 2){
                ans -= Math.pow(arr[i], 2);
            }
            else{
                ans += Math.pow(arr[i], 2);
            }
        }
        return ans;
        
    }
}