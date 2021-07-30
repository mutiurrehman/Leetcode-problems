class Solution {
    public boolean canFinish(int n, int[][] p) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<Integer>());
        }
        
        for(int i=0;i<p.length;i++){
            adj.get(p[i][0]).add(p[i][1]);
        }
        
        boolean[] visited = new boolean[n];
        boolean[] rec = new boolean[n];
        for(int i=0;i<adj.size();i++){
            if(!visited[i] && isCyclic(adj, rec, visited, i))
                return false;
        }
        
        return true;
    }
    
    public boolean isCyclic(ArrayList<ArrayList<Integer>> adj, boolean[] rec, boolean[] vis, int src){
        if(rec[src])
            return true;
        
        if(vis[src])
            return false;
        
        vis[src]=true;
        rec[src]=true;
        for(int i=0;i<adj.get(src).size();i++){
            int v = adj.get(src).get(i);
            if(isCyclic(adj,rec,vis,v)){
                return true;
            }
        }
        rec[src]=false;
        return false;
    }
}