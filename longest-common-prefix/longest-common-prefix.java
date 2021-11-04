class Solution {
    public String longestCommonPrefix(String[] strs) {
     
        String ans=strs[0];
        
        String curr = strs[0];
        for(int i=1;i<strs.length;i++){
            int j=0,k=0;
            String cc = strs[i];
            while(j<curr.length() && k<cc.length()){
                if(curr.charAt(j)!=cc.charAt(k)){
                    break;
                }
                j++;
                k++;
            }
            if(curr.substring(0,j).length()<ans.length())
            ans = curr.substring(0,j);
        }
        
        return ans;
    }
}