class Solution {
    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        List<List<Integer>> adj = new ArrayList<>();
        int n=s.length();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<pairs.size();i++){
            adj.get(pairs.get(i).get(0)).add(pairs.get(i).get(1));
            adj.get(pairs.get(i).get(1)).add(pairs.get(i).get(0));
        }
        char[] arr = s.toCharArray();
        boolean[] vis = new boolean[n];
        List<List<Integer>> cn = getConnectedComponents(adj,n);
        for(List<Integer> l1: cn){
            char[] temp = new char[l1.size()];
            for(int i=0;i<temp.length;i++){
                temp[i] = arr[l1.get(i)];
            }
            Arrays.sort(temp);
            Collections.sort(l1);
            for(int i=0;i<temp.length;i++){
                arr[l1.get(i)] = temp[i];
            }
        }
        
        return String.valueOf(arr);
    }
    
    public void dfs(List<List<Integer>> adj, int src, boolean[] vis, List<Integer> temp){
        
        temp.add(src);
        vis[src] = true;
        for(int i: adj.get(src)){
            if(!vis[i]){
                dfs(adj, i, vis,temp);
            }
        }
    }
    
    public List<List<Integer>> getConnectedComponents(List<List<Integer>> adj, int n){
        
        List<List<Integer>> ans = new ArrayList<>();
        
        boolean[] visited = new boolean[n];
        for(int i=0;i<n;i++){
            if(!visited[i]){
                List<Integer> temp = new ArrayList<>();
                dfs(adj,i,visited,temp);
                ans.add(temp);
            }
        }
        
        return ans;
    }
}