class Solution {
    public boolean isBipartite(int[][] graph) {
         ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        int A = graph.length;
        for(int i=0;i<A;i++){
            adj.add(new ArrayList<Integer>());
        }
        
        for(int i=0;i<graph.length;i++){
           for(int j=0;j<graph[i].length;j++){
               adj.get(i).add(graph[i][j]);
               adj.get(graph[i][j]).add(i);
           }
        }
        int [] vis = new int[A];
        Arrays.fill(vis,-1);
        
        for(int i=0;i<adj.size();i++){
            if(vis[i]==-1){
                dfs(adj,i,i,1,vis);
                if(!flag)
                    return false;
            }
        }
        
        return flag;
    }
    
    boolean flag = true;
    public void dfs( ArrayList<ArrayList<Integer>> adj, int cur, int parent, int c, int[] visited){
      
        visited[cur]=c;
        for(int i=0;i<adj.get(cur).size();i++){
            int v = adj.get(cur).get(i);
            if(visited[v]==-1){
                dfs(adj, v, parent,3-c,visited);
            }
            else if(v!=parent && visited[v]==c){
                flag = false;
                break;
            }
        }
    }
}