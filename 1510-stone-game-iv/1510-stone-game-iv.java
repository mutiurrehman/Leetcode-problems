class Solution {
    public boolean winnerSquareGame(int n) {
        return dfs(new HashMap<Integer, Boolean>(), n);
    }
    
    public boolean dfs(HashMap<Integer, Boolean> map, int remain){
        if(map.containsKey(remain))
            return map.get(remain);
        
        int sqrt = (int)Math.sqrt(remain);
        
        for(int i=1;i<=sqrt;i++){
            if(!dfs(map, remain - i*i)){
                map.put(remain, true);
                return true;
            }
        }
        
        map.put(remain, false);
        return false;
    }
}