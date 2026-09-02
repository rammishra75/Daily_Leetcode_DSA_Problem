class Solution {
    private int minUnfairness = Integer.MAX_VALUE;

    public int distributeCookies(int[] cookies, int k) {
        // Sort cookies to process larger bags first (helps prune early)
        Arrays.sort(cookies);
        int[] childrenSum = new int[k];
        
        // Start backtracking from the last element (largest cookie bag)
        backtrack(cookies.length - 1, cookies, childrenSum, k);
        
        return minUnfairness;
    }

    private void backtrack(int cookieIndex, int[] cookies, int[] childrenSum, int k) {
        // Base Case: All cookie bags have been distributed
        if (cookieIndex < 0) {
            int currentMax = 0;
            for (int sum : childrenSum) {
                currentMax = Math.max(currentMax, sum);
            }
            minUnfairness = Math.min(minUnfairness, currentMax);
            return;
        }

        // Optimization 1: Pruning
        // If the current branch already exceeds our minimum unfairness, stop searching
        int currentMax = 0;
        for (int sum : childrenSum) {
            currentMax = Math.max(currentMax, sum);
        }
        if (currentMax >= minUnfairness) {
            return;
        }

        // Distribute the current cookie bag to one of the k children
        for (int childIndex = 0; childIndex < k; childIndex++) {
            // Optimization 2: Break symmetry
            // If this child has the same amount of cookies as the previous child,
            // distributing to them yields a duplicate state.
            if (childIndex > 0 && childrenSum[childIndex] == childrenSum[childIndex - 1]) {
                continue;
            }

            // Choose
            childrenSum[childIndex] += cookies[cookieIndex];

            // Recurse to the next cookie bag
            backtrack(cookieIndex - 1, cookies, childrenSum, k);

            // Unchoose (Backtrack)
            childrenSum[childIndex] -= cookies[cookieIndex];
        }
    }
}
