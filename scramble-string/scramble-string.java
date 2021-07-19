class Solution {
    
    HashMap<String, Boolean> map = new HashMap<>();
    public boolean isScramble(String s1, String s2) {
        if(s1.equals(s2))
            return true;
        if(s1.length()<=1)
            return false;
        
        boolean flag = false;
        int n =s1.length();
        String temp = s1+" "+s2;
        if(map.containsKey(temp))
            return map.get(temp);
        for(int i=1;i<n;i++){
            if((isScramble(s1.substring(0,i),s2.substring(n-i)) && isScramble(s1.substring(i),s2.substring(0,n-i))) || isScramble(s1.substring(0,i),s2.substring(0,i)) && isScramble(s1.substring(i),s2.substring(i))){
                flag = true;
                break;
            }
        }
        
        map.put(temp,flag);
        return flag;
    }
}