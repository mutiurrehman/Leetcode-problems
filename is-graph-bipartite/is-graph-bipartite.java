class Solution {
    public boolean isBipartite(int[][] graph) {
         ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        int A = graph.length;        
       
        int [] vis = new int[A];
        Arrays.fill(vis,-1);
        
        for(int i=0;i<A;i++){
            if(vis[i]==-1){
                dfs(graph,i,i,1,vis);
                if(!flag)
                    return false;
            }
        }
        
        return flag;
    }
    
    boolean flag = true;
    public void dfs( int[][] graph, int cur, int parent, int c, int[] visited){
      
        visited[cur]=c;
        for(int i=0;i<graph[cur].length;i++){
            int v = graph[cur][i];
            if(visited[v]==-1){
                dfs(graph, v, cur,3-c,visited);
            }
            else if(v!=parent && visited[v]==c){
                flag = false;
                break;
            }
        }
    }
}