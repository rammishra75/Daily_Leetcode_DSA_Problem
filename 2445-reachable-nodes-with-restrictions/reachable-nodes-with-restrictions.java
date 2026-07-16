class Solution {
    public int reachableNodes(int n, int[][] edges, int[] restricted) {
        List<List<Integer>> adj = new  ArrayList<>();
        for(int i = 0; i < n; i++){
            adj.add(new ArrayList<>());
        }
        for(int[] a: edges){
            adj.get(a[0]).add(a[1]);
            adj.get(a[1]).add(a[0]);
        }
        int[] vis = new int[n];
        int cnt = 0;
        HashSet<Integer> set = new HashSet<>();
        for(int i : restricted){
            set.add(i);
        }
        Queue<Integer> q = new LinkedList<>();
        q.add(0);
        while(!q.isEmpty()){
            int val = q.remove();
            vis[val] = 1;
            cnt++;
            for(int j : adj.get(val)){
                if(vis[j] == 0 && (set.contains(j) == false)){
                    q.add(j);
                }
            }
        }
        return cnt;
    }
}