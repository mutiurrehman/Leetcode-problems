class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
       
        List<Integer> temp = new ArrayList<>();
        temp.add(0);
        dfs(graph,0,graph.length-1,temp);
        
        return ans;
    }
     List<List<Integer>> ans = new ArrayList<>();
    public void dfs(int[][] graph, int src,int target,List<Integer> temp){
        
        if(src==target){
            ans.add(new ArrayList<>(temp));
            return;
        }
       
        for(int i=0;i<graph[src].length;i++){
             int v = graph[src][i];
             temp.add(v);      
             dfs(graph,v,target,temp);
             temp.remove(temp.size()-1);
        }
    }
}