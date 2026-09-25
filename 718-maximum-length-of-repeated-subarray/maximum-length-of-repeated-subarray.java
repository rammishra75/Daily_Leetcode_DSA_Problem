class Solution {
    public int findLength(int[] nums1, int[] nums2) {

        int n1 = nums1.length;
        int n2 = nums2.length;
        int maxLen = 0;

        for (int i = 0; i < n1; i++) {

            for (int j = 0; j < n2; j++) {

                int k = 0;

                while ((i + k < n1) &&
                       (j + k < n2) &&
                       nums1[i + k] == nums2[j + k]) {
                    k++;
                }

                maxLen = Math.max(maxLen, k);
            }
        }

        return maxLen;
    }
}