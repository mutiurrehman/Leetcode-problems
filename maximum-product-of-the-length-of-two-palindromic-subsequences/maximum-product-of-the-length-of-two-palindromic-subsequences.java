class Solution {
    public int maxProduct(String s) {
        
        dfs(s,0,"","");
        return max;
    }
    
    int max=1;
    public void dfs(String s, int i, String s1, String s2){
        if(i>=s.length()){
           if(isPalin(s1) && isPalin(s2))
            max = Math.max(max, s1.length()*s2.length());
            
            return;
        }
        
        dfs(s,i+1,s1+s.charAt(i),s2);
        dfs(s,i+1,s1,s2+ s.charAt(i));
        dfs(s,i+1,s1,s2);
    }
    
    public boolean isPalin(String str){
        int i=0,j=str.length()-1;
        
        while(i<=j){
            if(str.charAt(i)!=str.charAt(j))
                return false;
            i++;
            j--;
        }
        
        return true;
    }
}