class Solution {
    public boolean backspaceCompare(String s, String t) {
        
        Stack<Character> st1 = new Stack<>();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)!='#')
                st1.push(s.charAt(i));
            else{
                if(!st1.isEmpty())
                    st1.pop();
            }
        }
        
        String s1 = "";
        while(st1.size()!=0){
            s1+=st1.pop();
        }
        
        String s2 = "";
        st1 = new Stack<>();
        for(int i=0;i<t.length();i++){
            if(t.charAt(i)!='#')
                st1.push(t.charAt(i));
            else{
                if(!st1.isEmpty())
                    st1.pop();
            }
        }
        
        while(st1.size()!=0){
            s2+=st1.pop();
        }
        
        return s1.equals(s2);
    }
}