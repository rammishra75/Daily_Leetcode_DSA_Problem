class Solution {
    public int minimumArea(int[][] grid) {
        int up = Integer.MAX_VALUE;
        int left = Integer.MAX_VALUE;
        int right = Integer.MIN_VALUE;
        int down = Integer.MIN_VALUE;
        int n = grid.length;
        int m = grid[0].length;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(grid[i][j] == 1){
                    up = Math.min(up, i);
                    left = Math.min(left, j);
                    right = Math.max(right, j);
                    down = Math.max(down, i);
                }
            }
        }
        return (down - up + 1) * (right - left + 1);
    }
}