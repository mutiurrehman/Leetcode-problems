class Solution {
    
    public boolean isPalindrome(String str){
        int i = 0, j = str.length()-1;
        while(i<j){
            if(str.charAt(i)!=str.charAt(j))
                return false;
            i++;
            j--;
        }
        return true;
    }
    
    
    public List<List<String>> partition(String s) {
        
        helper(s, new ArrayList<String> ());
        return ans;
    }
    
    List<List<String>> ans = new ArrayList<>();
    public void  helper(String str, List<String> temp){
        if(str.length()==0)
        {
            ans.add(new ArrayList<String>(temp));
            return;
        }
        
        for(int i=0;i<str.length();i++){
            String prefix = str.substring(0,i+1);
            
            String ros = str.substring(i+1);
            
            if(isPalindrome(prefix)){
                temp.add(prefix);
                helper(ros,temp);
                temp.remove(temp.size()-1);
            }
                
        }
    }
}