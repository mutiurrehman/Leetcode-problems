class Solution {
    public int maxDistToClosest(int[] seats) {
        TreeSet<Integer> set = new TreeSet<>();
        
        for(int i=0;i<seats.length;i++){
            if(seats[i]==1)
                set.add(i);
        }
        
        int ans=0;
        for(int i=0;i<seats.length;i++){
            if(seats[i]==0){
                Integer before = set.lower(i);
                Integer upper = set.higher(i);
                if(before==null){
                    before = set.higher(i);
                }             
                
                if(upper == null){
                    upper = set.lower(i);
                }
                ans = Math.max(ans, Math.min(Math.abs(i - before),Math.abs(upper-i)));
            }
        }
        
        return ans;
    }
}