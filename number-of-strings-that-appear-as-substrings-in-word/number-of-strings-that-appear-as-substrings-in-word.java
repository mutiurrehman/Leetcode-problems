class Solution {
    public int numOfStrings(String[] patterns, String word) {
       
        
        int ans =0;
        for(int i=0;i<patterns.length;i++){
            for(int j=0;j<word.length();j++){
                for(int k=j+1;k<=word.length();k++){
                   if(patterns[i].equals(word.substring(j,k))){
                       ans++;
                       j=word.length();
                        break;
                   }
                }
            }
        }
        
        return ans;
    }
}