class Solution {
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0;i<n;i++)
            adj.add(new ArrayList<Integer>());
        
        for(int i=0;i<manager.length;i++){
            if(manager[i]!=-1)
            adj.get(manager[i]).add(i);
        }
        
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{headID,0});
        
        int ans=0;
        while(!q.isEmpty()){
            int[] curr = q.poll();
            int u = curr[0], time = curr[1];
            ans = Math.max(ans,time);
            for(int v: adj.get(u)){
                q.add(new int[]{v, informTime[u]+time});
            }
        }
        
        return ans;
    }
}