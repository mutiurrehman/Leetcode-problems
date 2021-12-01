class Solution {
    public List<Integer> findAllPeople(int n, int[][] meetings, int firstPerson) {
        List<Integer> ans = new ArrayList<>();
        HashSet<Integer> visited = new HashSet<>();
        
        HashMap<Integer, List<int[]>> map = new HashMap<>();
        
        for(int[] meet: meetings){
            map.putIfAbsent(meet[0], new ArrayList<>());
            map.putIfAbsent(meet[1], new ArrayList<>());
            
            map.get(meet[0]).add(new int[]{meet[1],meet[2]});
            map.get(meet[1]).add(new int[]{meet[0], meet[2]});
        }
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[1] - b[1]);
        pq.add(new int[]{0, 0});
        pq.add(new int[]{firstPerson,0});
        
        while(!pq.isEmpty()){
            int[] p = pq.poll();
            
            if(!visited.contains(p[0])){
                visited.add(p[0]);
                ans.add(p[0]);
            }
            
            if(!map.containsKey(p[0])){
                continue;
            }
            
            List<int[]> meetAt = map.get(p[0]);
            for(int[] m : meetAt){
                if(m[1]<p[1]){
                    continue;
                }
                
                pq.add(new int[]{m[0],m[1]});
            }
            
            map.remove(p[0]);
        }
        
        return ans;
    }
}