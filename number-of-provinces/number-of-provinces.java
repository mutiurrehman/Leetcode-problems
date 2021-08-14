class Solution {
    public int findCircleNum(int[][] tt) {
        
        int n = tt.length;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<Integer>());
        }
        
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(i!=j && tt[i][j]==1){
                    adj.get(i).add(j);
                }
            }
        }
        
        boolean[] vis = new boolean[n];
      
        int ans =0;
        for(int i=0;i<n;i++){
    
            if(!vis[i]){
                 dfs(adj,vis,i);
                ans++;
               
            }
        }
        
        return ans;
    }
    
    public void dfs(ArrayList<ArrayList<Integer>> adj, boolean[] vis, int src){
    
        for(int i=0;i<adj.get(src).size();i++){
            int v = adj.get(src).get(i);
            if(!vis[v]){
                vis[v]=true;
                dfs(adj,vis,v);
            }
        }
    }
}