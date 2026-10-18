class Solution {
    public void dfs(int i, int j, char[][] board, int[][] vis, int n, int m){
        if(i >= n || j >= m) return;
        if(board[i][j] == '.') return;
        vis[i][j] = 1;
        dfs(i + 1, j, board, vis, n, m);
        dfs(i, j + 1, board, vis, n, m);    
    }
    public int countBattleships(char[][] board) {
        int n = board.length;
        int m = board[0].length;
        int[][] vis = new int[n][m];
        int cnt = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(vis[i][j] == 0 && board[i][j] == 'X'){
                    dfs(i, j, board, vis, n, m);
                    cnt++;
                }
            }
        }
        return cnt;
    }
}