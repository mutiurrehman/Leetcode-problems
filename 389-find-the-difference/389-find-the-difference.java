class Solution {
    public char findTheDifference(String s, String t) {
        Map<Character, Integer> map1 = new HashMap<>();
        Map<Character, Integer> map2 = new HashMap<>();
        
        for(int i=0;i<s.length();i++){
            map1.put(s.charAt(i), map1.getOrDefault(s.charAt(i),0)+1);
        }
        
        for(int i=0;i<t.length();i++){
            map2.put(t.charAt(i), map2.getOrDefault(t.charAt(i),0)+1);
        }
        
        for(char key : map1.keySet()){
            if(map2.containsKey(key)){
                if(map2.get(key) == map1.get(key)){
                    map2.remove(key);
                }
                else{
                    if((map2.get(key)-map1.get(key))>=1){
                        map2.put(key, map2.get(key)-map1.get(key));
                    }
                }
            }
        }
        
        char[] ans= new char[1];
        for(char c:map2.keySet()){
            ans[0] = c;
        }
        
        
        return ans[0];
    }
}