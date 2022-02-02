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
        
        int begin =0,end =0,counter=map.size();
        while(end<s.length()){
            char cc = s.charAt(end);
            if(map.containsKey(cc)){
                map.put(cc, map.get(cc)-1);
                if(map.get(cc)==0)
                    counter--;
            }
            
            end++;
            while(counter==0){
                char ci = s.charAt(begin);
                if(map.containsKey(ci)){
                    map.put(ci,map.get(ci)+1);
                    if(map.get(ci)>0)
                        counter++;
                }
            
                if(end-begin==p.length())
                    res.add(begin);
                begin++;
                    
            }
        }
       return res;
    }
}