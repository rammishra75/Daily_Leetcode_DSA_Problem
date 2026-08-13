import java.util.HashSet;

class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        long maxSum = 0;
        long currentSum = 0;
        int left = 0;
        HashSet<Integer> seen = new HashSet<>();

        for (int right = 0; right < nums.length; right++) {
            // Shrink window from the left if a duplicate is found
            while (seen.contains(nums[right])) {
                seen.remove(nums[left]);
                currentSum -= nums[left];
                left++;
            }

            // Add the current element to the window
            seen.add(nums[right]);
            currentSum += nums[right];

            // If the window reaches size k, record the max sum
            if (right - left + 1 == k) {
                maxSum = Math.max(maxSum, currentSum);
                
                // Slide the left pointer forward for the next iteration
                seen.remove(nums[left]);
                currentSum -= nums[left];
                left++;
            }
        }

        return maxSum;
    }
}
