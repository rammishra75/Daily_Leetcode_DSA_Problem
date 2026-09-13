class Solution {
    public void bfs(int r, int c, int n, int m, char[][] arr, int[][] vis){
        vis[r][c] = 1;
        Queue<int[]> q = new LinkedList<>();
        int[] drow = {-1, 0, 1 ,0};
        int[] dcol = {0, 1, 0, -1};
        q.add(new int[]{r, c});
        while(!q.isEmpty()){
            int[] a = q.poll();
            for(int i = 0; i < 4; i++){
                int nrow = a[0] + drow[i];
                int ncol = a[1] + dcol[i];
                if(nrow >= 0 && nrow < n && ncol >= 0 && ncol < m && arr[nrow][ncol] == '1' && vis[nrow][ncol] == 0){
                    vis[nrow][ncol] = 1;
                    q.add(new int[]{nrow, ncol});
                }
            }
        }
    }
    public int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int cnt = 0; 
        int[][] vis = new int[n][m];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(grid[i][j] == '1' && vis[i][j] == 0){
                    bfs(i, j, n, m, grid, vis);
                    cnt++;
                }
            }
        }
        return cnt;
    }
}