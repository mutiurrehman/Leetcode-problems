class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        if(p.length()>s.length())
            return res;
        
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i=0;i<p.length();i++){
            char cc = p.charAt(i);
            map.put(cc, map.getOrDefault(cc,0)+1);
        }
        
        
        HashMap<Character, Integer> temp = new HashMap<>();
        for(int i=0;i<p.length();i++){
            char cc = s.charAt(i);
            temp.put(cc, temp.getOrDefault(cc,0)+1);
        }
        
        if(temp.equals(map))
            res.add(0);
        
        int i =1,b=p.length();
        while(i+b-1<s.length()){
            char curr = s.charAt(i+b-1);
            char prev = s.charAt(i-1);
            
            if(prev!=curr){
                if(temp.get(prev)==1)
                temp.remove(prev);
                else
                temp.put(prev,temp.get(prev)-1);
            }
            
            if(temp.containsKey(curr)){
                if(curr!=prev)
                temp.put(curr,temp.get(curr)+1);
            }
            else
            temp.put(curr,1);
           
            if(temp.equals(map))
                res.add(i);
           i++;
        }
        
        return res;
    }
}