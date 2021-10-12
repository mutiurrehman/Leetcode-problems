class Solution {
     public String smallestSubsequence(String s, int k, char letter, int repeat) {
        int count = 0;
        
        for (char c : s.toCharArray()) {
            count += c == letter ? 1 : 0;
        }
        
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            while (!stack.isEmpty() && stack.peek() > c && (s.length() - i + stack.size()  > k) && (stack.peek() != letter || count > repeat)) {
                if (stack.pop() == letter) repeat++;
            }
            
            if (stack.size() < k) {
                if (c == letter) {
                    stack.push(c);
                    repeat--;
                } else if (k - stack.size() - repeat > 0) { 
                    stack.push(c);
                }
            }
            
            if (c == letter) count--;
        }
        
        StringBuilder sb = new StringBuilder(stack.size());
        for(Character c : stack) sb.append(c);
        return sb.toString();
     }
}