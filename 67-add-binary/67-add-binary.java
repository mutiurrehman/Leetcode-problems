class Solution {
    public String addBinary(String a, String b) {
        
        StringBuilder sb = new StringBuilder();
        int i=a.length()-1, j = b.length()-1;
        
        int carry = 0;
        while(i>=0 || j>=0 || carry>0){
            int cc1 = i>=0 ? a.charAt(i)-'0' : 0;
            int cc2 = j>=0 ? b.charAt(j)-'0' : 0;
            i--;
            j--;
            int sum = (cc1+cc2+carry)%2;
            carry = (cc1+cc2+carry)/2;
            sb.append(sum);
        }
        
        
        return sb.reverse().toString();
    }
}