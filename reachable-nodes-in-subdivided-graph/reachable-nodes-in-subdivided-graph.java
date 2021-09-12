class Solution {
    public int reachableNodes(int[][] edges, int maxMoves, int n) {
        int[][] graph = new int[n][n];
        
        for(int i=0;i<n;i++){
            Arrays.fill(graph[i],-1);
        }
        
        for(int[] arr: edges){
            graph[arr[0]][arr[1]] = arr[2];
            graph[arr[1]][arr[0]] = arr[2];
        }
        
        int res = 0;
        
        boolean[] vis = new boolean[n];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->(b[1]-a[1]));
        
        pq.add(new int[]{0, maxMoves});
        
        while(!pq.isEmpty()){
            int[] cur = pq.poll();
            int curNode = cur[0];
            int moves = cur[1];
            if(vis[curNode])
                continue;
            
            vis[curNode] = true;
            res++;
            for(int i=0;i<n;i++){
                int cost = graph[curNode][i]+1;
                if(cost>0){
                    if(moves>=cost && !vis[i]){
                        pq.add(new int[]{i,moves-cost});
                    }
                    
                    int reach = Math.min(moves, cost-1);
                    res+=reach;
                    
                    graph[i][curNode] -= reach;
                }
            }
        }
        
        return res;
    }
}