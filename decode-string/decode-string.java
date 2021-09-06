class Solution {
    public String decodeString(String s) {
        StringBuilder str = new StringBuilder();
        
        Stack<String> st = new Stack<>();
        Stack<Integer> st2 = new Stack<>();
        
        for(int i=0;i<s.length();i++){
            char cc = s.charAt(i);
            if(Character.isDigit(cc)){
                int tot = 0;
                while(Character.isDigit(s.charAt(i))){
                    tot=tot*10+s.charAt(i)-'0';
                    i++;
                }
                i--;
                st2.push(tot);
            }
            else if(cc == '['){
                st.push(cc+"");
            }
            else if(cc>='a' && cc <='z'){
                st.push(cc+"");
            }
            else{
                int r = st2.pop();
                StringBuilder sb = new StringBuilder();
                while(!st.isEmpty() && !st.peek().equals("[")){
                    sb.append(st.pop());
                }
                st.pop();
                StringBuilder temp = new StringBuilder();
                for(int j=0;j<r;j++)
                    temp.append(sb);
                
                st.push(temp.toString());
            }
        }
        StringBuilder ans = new StringBuilder();
        while(!st.isEmpty())
            ans.append(st.pop());
        
        
        return ans.reverse().toString();
    }
}