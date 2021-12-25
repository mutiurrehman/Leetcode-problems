class Solution {
    public boolean canBeValid(String s, String locked) {
        
        if (s.length() % 2 == 1) return false;
        int tot = 0, op = 0, cl = 0;
        for(int i=0;i<s.length();i++){
            if(locked.charAt(i)=='0')
                tot++;
            else if(s.charAt(i)=='(')
                op++;
             else if(s.charAt(i)==')')
                cl++;
            
            if(tot+op-cl<0)
                return false;
            
        }
        
        tot = 0; op = 0; cl = 0;
        for(int i=s.length()-1;i>=0;i--){
            if(locked.charAt(i)=='0')
                tot++;
            else if(s.charAt(i)=='(')
                op++;
            else if(s.charAt(i)==')')
                cl++;
            
            if(tot+cl-op<0)
                return false;
            
        }
        
        return true;
    }
}