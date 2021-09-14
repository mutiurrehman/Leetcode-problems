class Solution {
    public int calculate(String s) {
        String str = s.replaceAll("\\s", ""); 
        
        Stack<Character> operators = new Stack<>();
        Stack<Integer> operands = new Stack<>();
        
        for(int i=0;i<str.length();i++){
            char cc = str.charAt(i);
            if(cc=='('){
                operators.push(cc);
            }
            else if(Character.isDigit(cc)){
                int t = 0;
                while(i<str.length() && Character.isDigit(str.charAt(i))){
                    t=t*10+str.charAt(i)-'0';
                    i++;
                }
                i--;
                operands.push(t);
            }
            else if(cc==')'){
                while(operators.peek()!='('){
                    char opr = operators.pop();
                    int op2 = operands.pop();
                    int op1 = operands.pop();
                    int ans = calVal(op1,op2,opr);
                    operands.push(ans);
                }
                operators.pop();
            }
            else{
               while (operators.size() > 0 && operators.peek() != '('
						&& precedence(cc) <= precedence(operators.peek())) {
                    char opr = operators.pop();
                    int op2 = operands.pop();
                    int op1 = operands.pop();
                    int ans = calVal(op1,op2,opr);
                    operands.push(ans);
                }
                operators.push(cc);
            }
        }
        
        while (operators.size() != 0) {
			char opr = operators.pop();
			int op2 = operands.pop();
			int op1 = operands.pop();

			int ans = calVal(op1, op2, opr);
			operands.push(ans);
		}

		return operands.peek();
    }
    
    public int precedence(char c){
        if (c == '+')
			return 1;
		else if (c == '-')
			return 1;
		else if (c == '*')
			return 2;
		
        return 2;
    }
    
    public int calVal(int a, int b, char c){
        if(c=='+')
            return a+b;
        else if(c=='-')
        return a-b;
        else if(c=='*')
            return a*b;
        
        return a/b;
    }
    
}