class Solution {
    public int distinctSubseqII(String s) {
        HashMap<Character, Long> map = new HashMap<>();
        
        long mod = (long)1e9+7;
        for(int i=0;i<s.length();i++){
            char cc = s.charAt(i);
            long sum=0;
            if(map.size()>0){
            for(char c: map.keySet()){
              sum= (sum%mod + map.get(c))%mod;  
            }
            }
            map.put(cc,sum+1);
            
        }
        
        long ans =0;
        for(char c: map.keySet()){
              ans= (ans%mod + map.get(c))%mod;  
            }
            
        return (int)ans%1000000007;
    }
}