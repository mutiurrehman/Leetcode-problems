class Solution {
    public String reversePrefix(String word, char ch) {
        int index =-1;
        
        for(int i=0;i<word.length();i++){
            if(word.charAt(i)==ch){
                index = i;
                break;
            }
        }
        if(index ==-1)
            return word;
        
        String t = word.substring(0,index+1);
        
        StringBuilder temp = new StringBuilder(t);
        
        return temp.reverse().toString() + word.substring(index+1);
    }
}