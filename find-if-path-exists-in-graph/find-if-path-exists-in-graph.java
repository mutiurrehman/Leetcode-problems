class Solution {
    public boolean validPath(int n, int[][] edges, int start, int end) {
        
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0;i<n;i++)
            adj.add(new ArrayList<>());
        
        for(int i=0;i<edges.length;i++){
            adj.get(edges[i][0]).add(edges[i][1]);
            adj.get(edges[i][1]).add(edges[i][0]);
        }
        
        boolean[] vis = new boolean[n];
        
        return dfs(adj,vis,start,end);
    }
    
    public boolean dfs( ArrayList<ArrayList<Integer>> adj, boolean[] vis, int src, int end){
        if(src==end)
            return true;
        
        vis[src] = true;
        for(int i:adj.get(src)){
            if(!vis[i]){
                if(dfs(adj,vis,i,end))
                    return true;
            }
        }
        
        return false;
    }
}