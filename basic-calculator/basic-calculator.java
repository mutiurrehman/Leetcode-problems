class Solution {
    public int calculate(String s) {
        Stack<Integer> st = new Stack<>();
        int res = 0, sign = 1;
        
        for(int i=0;i<s.length();i++){
            char cc = s.charAt(i);
            if(Character.isDigit(cc)){
                int num = cc-'0';
                while(i+1<s.length() && Character.isDigit(s.charAt(i+1))){
                    num = num*10 + s.charAt(i+1)-'0';
                    i++;
                }
                res+=num*sign;
            }
            else if(cc=='+'){
                sign = 1;
                
            }
            else if(cc=='-'){
                sign = -1;
            }
            else if(cc=='('){
                st.push(res);
                st.push(sign);
                res=0;
                sign =1;
            }
            else if(cc==')'){
                res = res*st.pop()+st.pop();
            }
        }
        
        return res;
    }
}