class Solution {
    public static void dfs(int node, ArrayList<ArrayList<Integer>>adj, int[] vis){
        vis[node] = 1;
        for(Integer it: adj.get(node)){
            if(vis[it] == 0){
                dfs(it, adj, vis);
            }
        }
    }
    public int findCircleNum(int[][] isConnected) {
        int V = isConnected.length;
        ArrayList<ArrayList<Integer>> adjLs = new ArrayList<ArrayList<Integer>>();
        int cnt = 0;
        for(int i = 0; i < V; i++){
            adjLs.add(new ArrayList<Integer>());
        }
        for(int i = 0; i < V; i++){
            for(int j = 0; j < V; j++){
                if(isConnected[i][j] == 1 && i != j){
                    adjLs.get(i).add(j);
                    adjLs.get(j).add(i);
                }
            }
        }
        int[] vis = new int[V];
        for(int i = 0; i < V; i++){
            if(vis[i] == 0){
                cnt += 1;
                dfs(i, adjLs, vis);
            }
        }
        return cnt;
    }
}