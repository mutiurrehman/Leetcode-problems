class Solution {
    public int secondMinimum(int n, int[][] edges, int time, int change) {
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        for(int i=0;i<n;i++){
            map.put(i, new ArrayList<Integer>());
        }
        
        for(int i=0;i<edges.length;i++){
            map.get(edges[i][0]-1).add(edges[i][1]-1);
            map.get(edges[i][1]-1).add(edges[i][0]-1);
        }
        
        HashSet<Integer> set = new HashSet<>();
        HashMap<Integer, Integer> vis = new HashMap<>();
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->(a[1]-b[1]));
        
        pq.add(new int[]{0,0});
        
        while(!pq.isEmpty()){
            int[] curr = pq.poll();
            int city = curr[0];
            int timeTillNow = curr[1];
            
            if(city==n-1 && timeTillNow > vis.getOrDefault(city, Integer.MAX_VALUE)){
                return timeTillNow;
            }
            
            if(!vis.containsKey(city)){
                vis.put(city,timeTillNow);
            }
            else if(vis.get(city)==timeTillNow || set.contains(city)){
                continue;
            }
            else{
                set.add(city);
            }
            
            int fac =timeTillNow/change;
            if(fac%2==1){
                timeTillNow = (fac+1)*change;
            }
            
            for(int nei : map.get(city)){
                if(!set.contains(nei)){
                    int tot = timeTillNow + time;
                    pq.add(new int[]{nei, tot});
                }
            }
        }
        
        return -1;
    }
}