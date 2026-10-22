class Solution {
    public int numSubarrayBoundedMax(int[] nums, int left, int right) {
        int leftPtr = 0;
        int validCount = 0;
        int answer = 0;

        for (int rightPtr = 0; rightPtr < nums.length; rightPtr++) {
            if (nums[rightPtr] > right) {
                validCount = 0;
                leftPtr = rightPtr + 1;
            } else if (nums[rightPtr] >= left) {
                validCount = rightPtr - leftPtr + 1;
            }

            answer += validCount;
        }

        return answer;
    }
}