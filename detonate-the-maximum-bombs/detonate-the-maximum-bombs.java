class Solution {
    public int maximumDetonation(int[][] bombs) {
       
        List<List<Integer>> adj = new ArrayList<>();
        int n = bombs.length;
        for(int i=0;i<n;i++)
            adj.add(new ArrayList<Integer>());
        
        for(int i=0; i<bombs.length; i++){
            for(int j=0; j<bombs.length; j++){
                if(i!=j){
                    if(insideRange(bombs[i], bombs[j])){
                        adj.get(i).add(j);
                    }
                }
            }
        }
        
        
        int ans = 0;

        for(int i=0; i<bombs.length; i++){
            int x = bfs(i, bombs.length, adj);
            ans = Math.max(ans, x);
        }
        
        return ans;
    }
    
    public int bfs(int src, int n, List<List<Integer>> adj){
        
        boolean[] vis = new boolean[n];
        Queue<Integer> q = new LinkedList<>();
        q.add(src);
        vis[src] = true;
        int ans=1;
        int blastedTillNow = 1;
        
        while(!q.isEmpty()){
            int curr = q.poll();
            
            for(int nei: adj.get(curr)){
                if(!vis[nei]){
                    q.add(nei);
                    blastedTillNow++;
                    ans = Math.max(ans, blastedTillNow);
                    vis[nei] = true;
                }
            }
        }
        
        return ans;
    }
    
    public boolean insideRange(int[] a, int[] b) {
        long x = Math.abs((a[0]-b[0]));
        long y = Math.abs((a[1]-b[1]));
        long r = a[2];
        long dis = x*x + y*y;
        return  r*r >= dis ;
    }
}