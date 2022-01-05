class Solution {
    public boolean checkString(String s) {
        boolean checkb = false;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='b'){
                checkb = true;
            }
            
            if(checkb && s.charAt(i)=='a')
                return false;
        }
        
        return true;
    }
}