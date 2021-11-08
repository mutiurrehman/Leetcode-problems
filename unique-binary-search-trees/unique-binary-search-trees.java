class Solution { 
    public int numTrees(int n) {
        HashMap<Integer, Integer> map = new HashMap<>();
        
        return helper(n, map);
    }
    
    public int helper(int n, HashMap<Integer, Integer> map){
        
        if(n==0)
            return 1;
        
        if(map.containsKey(n))
            return map.get(n);
        
        int sum=0;
        for(int i=1;i<=n;i++){
            sum+=helper(i-1,map)*helper(n-i,map);
        }
        
        map.put(n, sum);
        return sum;
    }
}