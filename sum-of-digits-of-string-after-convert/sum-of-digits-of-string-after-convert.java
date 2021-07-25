class Solution {
    public int getLucky(String s, int k) {
        
       StringBuilder str = new StringBuilder();
        for(int i =0;i<s.length();i++){
            str.append(s.charAt(i)-'a'+1);
        }
        
        StringBuilder curr = new StringBuilder(str);
        while(k>0){
            curr = digitSum(curr);
            k--;
        }
        
        return Integer.parseInt(curr.toString());
    }
    
    public StringBuilder digitSum(StringBuilder curr){
      StringBuilder ans=new StringBuilder();

        int num=0;
        for(int i=0;i<curr.length();i++){
            num+=curr.charAt(i)-'0';
        }
        
        while(num!=0){
            ans.append(num%10);
            num=num/10;
        }
        
        ans.reverse();
        
        return ans;
        
    }
}