class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> ans = new ArrayList<>();
        
        
        List<Integer> temp = new ArrayList<>();
        temp.add(0);
        dfs(ans, 0, graph.length-1,temp, graph);
        
        return ans;
        
    }
    
    public void dfs(List<List<Integer>> ans, int start, int end, List<Integer> temp, int[][] graph){
        if(start==end){
            ans.add(new ArrayList<>(temp));
        }    
        
        
        for(int curr: graph[start]){
            temp.add(curr);
            dfs(ans, curr, end, temp, graph);
             temp.remove(temp.size()-1);
        }
        
       
    }
}