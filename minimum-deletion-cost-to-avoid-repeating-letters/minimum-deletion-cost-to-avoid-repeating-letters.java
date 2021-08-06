class Solution {
    public int minCost(String s, int[] cost) {
        HashMap<Character, PriorityQueue<Integer>> map = new HashMap<>();
        int ans=0;
        for(int i=0;i<s.length();i++){
            map.put(s.charAt(i),new PriorityQueue<Integer>());
            while(i<s.length()-1 && s.charAt(i)==s.charAt(i+1)){
                map.get(s.charAt(i)).add(cost[i]);
                i++;
            }
            if(i>0 && s.charAt(i-1)==s.charAt(i))
                map.get(s.charAt(i)).add(cost[i]);
            
           if(map.get(s.charAt(i))!=null && map.get(s.charAt(i)).size()>0){
                while(map.get(s.charAt(i)).size()>1)
                    ans+=map.get(s.charAt(i)).remove();
            }
            
            map.remove(s.charAt(i));
        }
        return ans;
    }
}