class Solution {
    public int search(int[] nums, int target) {
        int ans = -1;
        int low = 0;
        int l = nums.length;
        int high = l - 1;
        while(low <= high){
            int mid = (low + high) / 2;
            if(nums[mid] == target){
                ans = mid;
                return ans;
            }
            if(nums[low] <= nums[mid]){
                if(nums[low] <= target && target <= nums[mid]){
                    high = mid - 1;
                }
                else{
                    low = mid + 1;
                }
            }
            else{
                if(nums[mid] <= target && target <= nums[high]){
                    low = mid + 1;
                }
                else{
                    high = mid - 1;
                }
            }
        }
        return ans;
    }
}