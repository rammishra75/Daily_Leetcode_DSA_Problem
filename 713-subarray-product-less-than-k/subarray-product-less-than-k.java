class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int ans = 0;
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            long mul = 1;

            for (int j = i; j < n; j++) {
                mul *= nums[j];

                if (mul < k) {
                    ans++;
                } else {
                    break;
                }
            }
        }

        return ans;
    }
}