import java.util.*;

class Solution {
    public int[][] findFarmland(int[][] land) {
        int n = land.length;
        int m = land[0].length;
        List<int[]> result = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                // Check if this cell is the top-left corner of a new farmland rectangle
                if (land[i][j] == 1 && 
                    (i == 0 || land[i - 1][j] == 0) && 
                    (j == 0 || land[i][j - 1] == 0)) {
                    
                    int r2 = i;
                    int c2 = j;

                    // Expand down to find the bottom boundary of this rectangle
                    while (r2 + 1 < n && land[r2 + 1][j] == 1) {
                        r2++;
                    }

                    // Expand right to find the right boundary of this rectangle
                    while (c2 + 1 < m && land[i][c2 + 1] == 1) {
                        c2++;
                    }

                    // Store the coordinates directly: [r1, c1, r2, c2]
                    result.add(new int[]{i, j, r2, c2});
                }
            }
        }

        // Convert the dynamic list into the final primitive 2D array
        return result.toArray(new int[result.size()][]);
    }
}
