class Solution {
    public double frogPosition(int n, int[][] edges, int t, int target) {
        List<List<Integer>> adj = new ArrayList<>();
        
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<Integer>());
        }
        
        for(int i=0;i<edges.length;i++){
            adj.get(edges[i][0]-1).add(edges[i][1]-1);
            adj.get(edges[i][1]-1).add(edges[i][0]-1);
        }
        
        Queue<Integer> q = new LinkedList<>();
        q.add(0);
        boolean[] vis = new boolean[n];
       // vis[0] = true;
        
        double[] prob = new double[n];
        prob[0] = 1f;
        while(!q.isEmpty() && t-->0){
            int size = q.size();
            for(int i=0;i<size;i++){
                int u = q.poll();
                if(vis[u])
                    continue;
                vis[u]=true;
                int nexts = 0;
                for(int j:adj.get(u)){
                    if(!vis[j])
                        nexts++;
                }
                
                for(int v: adj.get(u)){
                    if(!vis[v]){
                        q.add(v);
                        prob[v] = prob[u]/nexts;
                    }
                }
                if(nexts>0){
                    prob[u] = 0;
                }
            }
        }
        
        return prob[target-1];
    }
}