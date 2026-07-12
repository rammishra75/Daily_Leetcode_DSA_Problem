class Solution { 
    public int dfs(int i, int j, int n, int m, int[] drow, int[] dcol, int[][] grid, int[][] vis){ 
        if(i < 0 || j < 0 || i >= n || j >= m) return 0; 
        
        int ans = grid[i][j]; 
        vis[i][j] = 1; 
        
        for(int k = 0; k < 4; k++){ 
            int nrow = i + drow[k]; 
            int ncol = j + dcol[k]; 
            
            if(nrow >= 0 && nrow < n && ncol >= 0 && ncol < m && grid[nrow][ncol] > 0 && vis[nrow][ncol] != 1){ 
                ans += dfs(nrow, ncol, n, m, drow, dcol, grid, vis); 
            } 
        } 
        return ans; 
    } 

    public int findMaxFish(int[][] grid) { 
        int n = grid.length; 
        int m = grid[0].length; 
        
        // Initialize to 0 so it correctly handles cases with 0 fish
        int ans = 0; 
        
        int[] drow = {-1, 0, 1, 0}; 
        int[] dcol = {0, 1, 0, -1}; 
        int[][] vis = new int[n][m]; 
        
        for(int i = 0; i < n; i++){ 
            // FIXED: Changed j < n to j < m
            for(int j = 0; j < m; j++){ 
                // FIXED: Added check to skip cells already visited by prior components
                if(grid[i][j] > 0 && vis[i][j] == 0){ 
                    ans = Math.max(ans, dfs(i, j, n, m, drow, dcol, grid, vis)); 
                } 
            } 
        } 
        return ans; 
    } 
}
