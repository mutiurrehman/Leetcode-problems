class Solution {
    public boolean isPrefixString(String s, String[] words) {
        
        String d ="";
        for(int i=0;i<words.length;i++){
            d+=words[i];
            if(d.equals(s))
                return true;
        }
        
        return false;
    }
}