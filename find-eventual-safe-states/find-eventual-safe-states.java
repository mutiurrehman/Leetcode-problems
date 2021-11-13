class Solution {
    
    public List<Integer> eventualSafeNodes(int[][] graph) {
       
        List<Integer> ans = new ArrayList<>();
        int[] color = new int[graph.length];
        for(int i = 0;i < graph.length;i++){
            if(dfs(graph, i, color)) 
                ans.add(i);
        }
        return ans;
    }
    
    public boolean dfs(int[][] graph, int src, int[] color){
        if(color[src]!=0)
            return color[src]==1;
        
        color[src] = 2;
        for(int i: graph[src]){
            if(!dfs(graph, i,color))
                return false;
        }
        
        color[src] = 1;
        
        return true;
    }
}