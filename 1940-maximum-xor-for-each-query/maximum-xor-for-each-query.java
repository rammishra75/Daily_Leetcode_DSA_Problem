class Solution {
    public int[] getMaximumXor(int[] nums, int maximumBit) {
        int n = nums.length;
        int[] answer = new int[n];
        
        // Calculate the maximum possible value for k with maximumBit bits
        // (e.g., if maximumBit = 2, mask = 2^2 - 1 = 3, which is '11' in binary)
        int mask = (1 << maximumBit) - 1;
        
        // Step 1: Find the total XOR of all elements in the initial array
        int currentXor = 0;
        for (int num : nums) {
            currentXor ^= num;
        }
        
        // Step 2: Process queries from first to last
        // The ith query targets the current last element, which is at index (n - 1 - i)
        for (int i = 0; i < n; i++) {
            // To maximize the XOR sum, k should flip all bits within the mask
            answer[i] = currentXor ^ mask;
            
            // Remove the last element of the current array for the next query
            currentXor ^= nums[n - 1 - i];
        }
        
        return answer;
    }
}
