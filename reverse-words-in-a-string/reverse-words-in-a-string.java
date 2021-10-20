class Solution {
    public String reverseWords(String s) {
        
        s = s.trim();
        String[] arr = s.split("\\s+");
        StringBuilder ans = new StringBuilder();
        for(int i=arr.length-1;i>=0;i--){
            ans.append(arr[i]);
            if(i!=0)
            ans.append(" ");
        }
        
        return ans.toString();
    }
}