class Solution {
    public int numPairsDivisibleBy60(int[] time) {
        
        
        HashMap<Integer, Integer> map = new HashMap<>();
        int ans=0;
        for(int t:time){
            t = t%60;
            int other = t==0?0 : 60-t;
            ans+=map.getOrDefault(other,0);
            
            map.put(t, map.getOrDefault(t,0)+1);
        }
        
        return ans;
    }
}