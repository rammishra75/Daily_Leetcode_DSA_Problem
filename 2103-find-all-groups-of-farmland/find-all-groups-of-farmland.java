import java.util.*;

class Solution { 
    public List<Integer> bfs(int[][] arr, int[][] vis, int n, int m, int i, int j){ 
        Queue<int[]> q = new LinkedList<>(); 
        List<Integer> ans = new ArrayList<>(); 
        ans.add(i); 
        ans.add(j); 
        
        q.add(new int[]{i, j}); 
        vis[i][j] = 1; // Mark as visited as soon as it enters the queue
        
        int[] drow = {-1, 0, 1, 0}; 
        int[] dcol = {0, 1, 0, -1}; 
        
        int maxRow = i;
        int maxCol = j;
        
        while(!q.isEmpty()){ 
            int[] top = q.poll(); 
            int r = top[0];
            int c = top[1];
            
            // Track the furthest bottom-right coordinates seen
            maxRow = Math.max(maxRow, r);
            maxCol = Math.max(maxCol, c);
            
            for(int k = 0; k < 4; k++){ 
                int nrow = r + drow[k]; // FIXED: Use r (top[0]) instead of i
                int ncol = c + dcol[k]; // FIXED: Use c (top[1]) instead of j
                
                if(nrow < n && nrow >= 0 && ncol >= 0 && ncol < m && vis[nrow][ncol] == 0 && arr[nrow][ncol] == 1){ 
                    vis[nrow][ncol] = 1; // FIXED: Mark visited here to prevent duplicate queue additions
                    q.add(new int[]{nrow, ncol}); 
                } 
            } 
        } 
        ans.add(maxRow); 
        ans.add(maxCol); 
        return ans; 
    } 
    
    public int[][] findFarmland(int[][] land) { 
        int n = land.length; 
        int m = land[0].length; 
        List<List<Integer>> t = new ArrayList<>(); 
        int[][] vis = new int[n][m]; 
        
        for(int i = 0; i < n; i++){ 
            for(int j = 0; j < m; j++){ 
                // FIXED: Only trigger BFS if it's land AND hasn't been visited yet
                if(land[i][j] == 1 && vis[i][j] == 0){ 
                    List<Integer> arr = bfs(land, vis, n, m, i, j); 
                    t.add(arr); 
                } 
            } 
        } 
        
        int[][] ans = new int[t.size()][4]; 
        for(int i = 0; i < t.size(); i++){ 
            for(int j = 0; j < 4; j++){ 
                ans[i][j] = t.get(i).get(j); 
            } 
        } 
        return ans; 
    } 
}
