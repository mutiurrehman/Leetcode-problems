class Solution {
    public String makeFancyString(String s) {
        StringBuilder ans = new StringBuilder();
        
        for(int i=0;i<s.length();i++){
            int c=0;
            while(i< s.length()-1 && s.charAt(i)==s.charAt(i+1)){
                i++;
                c++;
            }
            
            if(c>=2){
                ans.append(s.charAt(i-1));
                ans.append(s.charAt(i-1));
            }
            else if(c==1){
                  ans.append(s.charAt(i-1));
                ans.append(s.charAt(i-1));
            }
            else{
                  ans.append(s.charAt(i));
            }
        }
    
            return ans.toString();
    }
}