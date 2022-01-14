class Solution {
    public int myAtoi(String s) {
        
        
        String str = s.trim();
        if(str.length()==0)
            return 0;
        int i=0;
        int sign =1;
        if(str.charAt(i)=='+' || str.charAt(i)=='-'){
            sign = str.charAt(i) == '-' ? -1 : 1;
            i++;
        }
        
        long ans =0;
        for(;i<str.length();i++){
            char cc = str.charAt(i);
            if(!Character.isDigit(cc))
                return (int)ans*sign;
            
            ans = ans*10 + cc-'0';
            if(ans>Integer.MAX_VALUE  || ans<Integer.MIN_VALUE){
                return sign ==-1 ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }
        }
        
        return (int)ans*sign;
    }
}