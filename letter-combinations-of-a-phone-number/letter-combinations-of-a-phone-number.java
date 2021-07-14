class Solution {
    
    HashMap<Character, String> map = new HashMap<>(){{
        put('2',"abc");
        put('3',"def");
        put('4',"ghi");
        put('5',"jkl");
        put('6',"mno");
        put('7',"pqrs");
        put('8',"tuv");
        put('9',"wxyz");
    }};
    
    List<String> ans = new ArrayList<>();
    String phone;
    
    public List<String> letterCombinations(String digits) {
        if(digits.length()==0)
            return ans;
        
        phone = digits;
        helper(0,new StringBuilder());    
        return ans;
    }
    
    public void helper(int index, StringBuilder str){
        if(str.length()==phone.length()){
            ans.add(str.toString());
        return;
        }
        
        String possChars = map.get(phone.charAt(index));
        for(char cur : possChars.toCharArray()){
            str.append(cur);
            helper(index+1,str);
            str.deleteCharAt(str.length()-1);
        }
        
    }
}