class Solution {
    public int[] findOrder(int n, int[][] p) {
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
            if(!visited[i] && dfs(adj, rec, visited, i))
                return new int[0];
        }
        
        int[] res = new int[ans.size()];
        for(int i=0;i<res.length;i++)
            res[i]=ans.get(i);
        
        return res;
    }
    
 
    List<Integer> ans = new ArrayList<>();
    public boolean dfs(ArrayList<ArrayList<Integer>> adj, boolean[] visited, boolean[] rec, int src){
        if(rec[src])
            return true;
        
        if(visited[src])
            return false;
      
        visited[src]=true;
        rec[src]=true;
        for(int i=0;i<adj.get(src).size();i++){
            int v = adj.get(src).get(i);
            boolean check = dfs(adj,visited,rec,v);
            if(check){
               ans.clear();
               return true; 
            }
           
        }
        
        ans.add(src);
        rec[src]=false;
        return false;
    }
}