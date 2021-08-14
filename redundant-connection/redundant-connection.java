class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        
        for(int i=0;i<edges.length;i++){
            adj.add(new ArrayList<Integer>());
        }
        
        int[] ans = new int[2];
        for(int i=0;i<edges.length;i++){
            boolean[] vis = new boolean[edges.length];
            if(dfs(adj,vis,edges[i][0]-1, edges[i][1]-1)){
                ans[0] = edges[i][0];
                ans[1] = edges[i][1];
                break;
            }
            
            adj.get(edges[i][0]-1).add(edges[i][1]-1);
            adj.get(edges[i][1]-1).add(edges[i][0]-1);
        }
        
        return ans;
    }
    
    public boolean dfs(ArrayList<ArrayList<Integer>> adj, boolean[] vis,int src,int target) {
        
        if(!vis[src]){
            vis[src]=true;
            if(src==target)
                return true;
            for(int i=0;i<adj.get(src).size();i++){
                int v = adj.get(src).get(i);    
                if(dfs(adj,vis,v,target))
                    return true;
                        
            }
        }
        return false;
    }
}