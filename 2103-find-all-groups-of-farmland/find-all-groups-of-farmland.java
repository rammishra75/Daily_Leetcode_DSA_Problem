import java.util.*;

class Solution {
    // Global variables to track the bottom-right corner during DFS
    private int maxRow;
    private int maxCol;

    private void dfs(int[][] land, int[][] vis, int n, int m, int r, int c) {
        vis[r][c] = 1; // Mark the current cell as visited
        
        // Track the furthest bottom-right coordinates seen so far
        maxRow = Math.max(maxRow, r);
        maxCol = Math.max(maxCol, c);

        int[] drow = {-1, 0, 1, 0};
        int[] dcol = {0, 1, 0, -1};

        // Explore all 4 directions
        for (int k = 0; k < 4; k++) {
            int nrow = r + drow[k];
            int ncol = c + dcol[k];

            // Valid boundary check, unvisited check, and ensuring it is land (1)
            if (nrow >= 0 && nrow < n && ncol >= 0 && ncol < m && vis[nrow][ncol] == 0 && land[nrow][ncol] == 1) {
                dfs(land, vis, n, m, nrow, ncol);
            }
        }
    }

    public int[][] findFarmland(int[][] land) {
        int n = land.length;
        int m = land[0].length;
        List<List<Integer>> t = new ArrayList<>();
        int[][] vis = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                // Start a new DFS if we find land that hasn't been visited yet
                if (land[i][j] == 1 && vis[i][j] == 0) {
                    // Reset coordinates for the current rectangular farmland
                    maxRow = i;
                    maxCol = j;

                    dfs(land, vis, n, m, i, j);

                    // Store the result: [r1, c1, r2, c2]
                    List<Integer> arr = new ArrayList<>();
                    arr.add(i);      // Top-left row
                    arr.add(j);      // Top-left col
                    arr.add(maxRow); // Bottom-right row
                    arr.add(maxCol); // Bottom-right col
                    t.add(arr);
                }
            }
        }

        // Convert the List of Lists into the required 2D primitive array
        int[][] ans = new int[t.size()][4];
        for (int i = 0; i < t.size(); i++) {
            for (int j = 0; j < 4; j++) {
                ans[i][j] = t.get(i).get(j);
            }
        }
        return ans;
    }
}
