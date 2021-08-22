class Solution {
    
    int[] dist;
    long[] dp;
    public int countPaths(int n, int[][] roads) {
    
        dist = new int[n];
        dp = new long[n];
        Map<Integer, List<int[]>> graph = new HashMap<>();
        Arrays.fill(dist, Integer.MAX_VALUE);
        for(int i=0;i<n;i++){
            graph.put(i, new ArrayList());
        }
        
         for(int[] e: roads){
            graph.get(e[0]).add(new int[]{e[1], e[2]});
            graph.get(e[1]).add(new int[]{e[0], e[2]});
        }
        
        djikstra(graph);
 
        return (int)dp[n-1]%1_000_000_007;
    }
    
    public void djikstra(Map<Integer, List<int[]>> graph){
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->(a[1]-b[1]));
        pq.add(new int[]{0,0});
        dist[0] = 0;
        dp[0] = 1;
        while(!pq.isEmpty()){
            int[] curr = pq.poll();
            int u=curr[0], d = curr[1];
            if(dist[u]<d)
                continue;
            
            for(int[] v: graph.get(u)){
                if(dist[v[0]]>v[1]+d){
                    dist[v[0]]= v[1]+d;
                    dp[v[0]] = dp[u];
                    pq.add(new int[]{v[0],dist[v[0]]});
                }
                else if(dist[v[0]]==v[1]+d){
                    dp[v[0]]+=dp[u];
                    dp[v[0]]%=1_000_000_007;
                }
            }
            
        }
        
    }
}