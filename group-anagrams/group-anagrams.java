class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        
        HashMap<String, List<String>> map = new HashMap<>();
         List<List<String>> ans = new ArrayList<>();
        for(int i=0;i<strs.length;i++){
            char[] curr = strs[i].toCharArray();
            Arrays.sort(curr);
            String temp = String.valueOf(curr);
            if(map.containsKey(temp)){
                map.get(temp).add(strs[i]);
            }
            else{
                List<String> lst = new ArrayList<>();
                lst.add(strs[i]);
                map.put(temp,lst);
            }
        }
        
        for(String k : map.keySet()){
            ans.add(map.get(k));
        }
        
        return ans;
    }
}