class Solution {
    public boolean canReach(int[] arr, int start) {
        
        int n = arr.length;
        boolean[] visited = new boolean[n];
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        
    while(!q.isEmpty()){
            int curr = q.poll();
            if(arr[curr]==0)
                return true;
            
            if(visited[curr])
                continue;
            
            visited[curr] = true;
            int reachf = curr+arr[curr], reachb = curr-arr[curr];
            if(reachf<n){
                q.add(reachf);
            }
            
            if(reachb>=0){
                q.add(reachb);
            }
        }
        
        return false;
    }
}