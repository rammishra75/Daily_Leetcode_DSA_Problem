class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int low = 1;
        int high = Integer.MIN_VALUE;
        for (int i : piles) {
            high = Math.max(high, i);
        }
        int ans = high;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (helper(piles, mid, h)) {
                ans = mid;
                high = mid - 1; // Try a smaller speed
            } else {
                low = mid + 1;  // Speed is too slow
            }
        }
        return ans;
    }

    public boolean helper(int[] arr, int cap, int h) {
        long time = 0;
        for (int i : arr) {
            time += (long)(i + cap - 1) / cap;
            if (time > h) return false;
        }
        return true;
    }
}
