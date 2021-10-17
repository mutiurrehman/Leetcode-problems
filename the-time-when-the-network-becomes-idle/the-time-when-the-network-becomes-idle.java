class Solution {
    public int networkBecomesIdle(int[][] edges, int[] patience) {
     
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        
        int n = patience.length;
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<Integer>());
        }
        
        for(int i=0;i<edges.length;i++){
            adj.get(edges[i][0]).add(edges[i][1]);
            adj.get(edges[i][1]).add(edges[i][0]);
        }
         
        int[] dist = new int[n];
        Arrays.fill(dist,-1);
        
        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<adj.get(0).size();i++) 
            q.offer(adj.get(0).get(i));
        int len=0;
        while(!q.isEmpty()){
            int size = q.size();
            len++;
            for(int i=0;i<size;i++){
                int curr = q.poll();
                if(dist[curr]!=-1)
                    continue;
                
                dist[curr] = len;
                for(int j=0;j<adj.get(curr).size();j++){
                    if(dist[adj.get(curr).get(j)]==-1){
                        q.add(adj.get(curr).get(j));
                    }
                }
            }
        }
       
        int max=0;
        for(int i=1;i<n;i++){
            int extraMsgs = (2*dist[i]-1)/patience[i];
            int lastMsg = extraMsgs*patience[i];
            
            int curr = lastMsg+2*dist[i];
            max = Math.max(max,curr);
        }
        
        return max+1;
    }
}