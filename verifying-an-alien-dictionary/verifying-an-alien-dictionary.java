class Solution {
    int[] alpha = new int[126];
    public boolean isAlienSorted(String[] words, String order) {
        int i=0;
        for(char c : order.toCharArray()){
            alpha[c] =i++;
        }
        
        for( i=0;i<words.length-1;i++){
            if(!compare(words[i],words[i+1]))
                return false;
        }
        
        return true;
    }
    
    public boolean compare(String s1, String s2){
        int l1 = s1.length(), l2=s2.length();
        for(int i=0;i<l1&&i<l2;i++){
            if(s1.charAt(i)!=s2.charAt(i)){
                return alpha[s1.charAt(i)]<alpha[s2.charAt(i)];
            }
        }
        
        return l1<=l2;
    }
}