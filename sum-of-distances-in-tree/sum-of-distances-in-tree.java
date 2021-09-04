class Solution {
    int[] ans, count;
    ArrayList<ArrayList<Integer>> adj;
    int N;
    public int[] sumOfDistancesInTree(int N, int[][] edges) {
        
        this.N = N;
        adj = new ArrayList<>();
        ans = new int[N];
        count = new int[N];
        Arrays.fill(count,1);
       for(int i=0;i<N;i++){
            adj.add(new ArrayList<Integer>());
       }
        
       for(int i=0;i<edges.length;i++){
           adj.get(edges[i][0]).add(edges[i][1]);
           adj.get(edges[i][1]).add(edges[i][0]);
       }
    
        dfs(0,-1);
        dfs2(0,-1);
        
        return ans;
    }
    
    public void dfs(int src, int parent){
        for(int child: adj.get(src)){
            if(child!=parent){
                dfs(child,src);
                count[src]+=count[child];
                ans[src]+=ans[child]+count[child];
            }
        }
    }
    
    public void dfs2(int src, int parent){
        for(int child: adj.get(src)){
            if(child!=parent){
                ans[child] = ans[src] - count[child] + N-count[child];
                dfs2(child,src);
            }
        }
    }
    

}