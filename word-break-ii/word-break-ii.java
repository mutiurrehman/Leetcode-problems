class Solution {
  HashMap<String, List<String>> map = new HashMap<>();
    public List<String> wordBreak(String s, List<String> B) {
        if(map.containsKey(s))
        return map.get(s);
        
        List<String> res = new ArrayList<>();
        
        for(String w: B){
            if(  w.length()<=s.length() && s.substring(0,w.length()).equals(w)){
                if(w.length()==s.length())
                res.add(w);
                else{
                     List<String> temp = wordBreak(s.substring(w.length()),B);
                     for(String t:temp){
                         res.add(w+" "+t);
                     }
                }
            }
        }
        
        map.put(s, res);
        return res;
    }
}