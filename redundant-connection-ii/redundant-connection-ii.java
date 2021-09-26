class Solution {
    public int[] findRedundantDirectedConnection(int[][] edges) {
        
        int n = edges.length;
        int[] indegree = new int[edges.length];
        Arrays.fill(indegree, -1);
        int b1=-1 ,b2=-1;
        for(int i=0;i<n;i++){
            if(indegree[edges[i][1]-1]!=-1){
                b1 = i;
                b2 = indegree[edges[i][1]-1];
                break;
            }
            else{
                indegree[edges[i][1]-1] = i;
            }
        }
        
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0;i<edges.length;i++){
            adj.add(new ArrayList<Integer>());
        }
        
        
        for(int i=0;i<edges.length;i++){
            if(i==b1)
                continue;
            
            int u = edges[i][0]-1;
            int v = edges[i][1]-1;
            boolean[] vis = new boolean[n];
            boolean[] rec = new boolean[n];
            adj.get(edges[i][0]-1).add(edges[i][1]-1);
            boolean flag = dfs(adj,vis,rec,u);
            if(flag){
                if(b1==-1)
                    return edges[i];
                else
                    return edges[b2];
            }
        }
     
        return edges[b1];
    }
    
    public boolean dfs(ArrayList<ArrayList<Integer>> adj, boolean[] vis, boolean[] rec, int src) {
        if(rec[src])
            return true;
        
        if(vis[src])
            return false;
        
        rec[src] = true;
        vis[src] = true;
        
        for(int child :  adj.get(src)){
          //  if(!vis[child]){
                if(dfs(adj,vis,rec,child))
                    return true;
            //}
        }
        
        rec[src] = false;
        return false;
    }
}