class Solution {
    public boolean detectCapitalUse(String word) {
        
        char c = word.charAt(0);
        int n = word.length();
        if(Character.isUpperCase(c)){
            boolean currS = false, currC = false;
            for(int i=1;i<n;i++){
                char cc = word.charAt(i);
                if(Character.isUpperCase(cc)){
                    currS = true;
                }
                
                if(Character.isLowerCase(cc)){
                    currC = true;
                }
                
            }
            if(currC && currS)
                return false;
                
            if(currC || currS)
                return true;
                
            }
        else{
             boolean currS = false, currC = false;
            for(int i=0;i<n;i++){
                char cc = word.charAt(i);
                if(Character.isUpperCase(cc)){
                    currS = true;
                }
                
                if(Character.isLowerCase(cc)){
                    currC = true;
                }
                
            }
            if(currC && currS)
                return false;
                
            if(currC || currS)
                return true;
        }        
     
        return true;
    }
}