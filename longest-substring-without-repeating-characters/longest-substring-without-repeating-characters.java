class Solution {
    public int lengthOfLongestSubstring(String A) {
        
        if(A.equals(""))
            return 0;
        HashMap<Character, Integer> map = new HashMap<>();
        int ans = Integer.MIN_VALUE, curr=0;
        for(int i=0;i<A.length();i++){
            char cc = A.charAt(i);
            if(!map.containsKey(cc)){
                map.put(cc,i);
                curr++;
                ans = Math.max(ans,curr);
            }
            else{
                curr=0;
                i = map.get(cc);
                map.clear();
            }
        }
        return ans;
    }
    
}