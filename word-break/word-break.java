class Solution {
    HashMap<String, Boolean> map;
    public boolean wordBreak(String s, List<String> wordDict) {
        map = new HashMap<>();
        return helper(s,wordDict);
    }
    
    public boolean helper(String str, List<String> wordDict){
        if(wordDict.contains(str))
            return true;
        
        if(map.containsKey(str))
            return map.get(str);
        
        int n = str.length();
        boolean flag=false;
        for(int i=1;i<=n;i++){
            if(wordDict.contains(str.substring(0,i)) && helper(str.substring(i),wordDict)){
                flag =true;
                break;
            }
        }
        
        map.put(str,flag);
        return flag;
    }
}