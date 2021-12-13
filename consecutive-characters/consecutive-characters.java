class Solution {
    public int maxPower(String s) {
        int ans = 0;
        char previous = ' ';
        int count=0;
        
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if(c == previous){
                count++;
            }
            else{
                count = 1;
                previous = c;
            }
            
            ans = Math.max(ans, count);
        }
        
        return ans;
    }
}