class Solution {
    public String frequencySort(String s) {
        HashMap<Character, Integer> hm = new HashMap<>();
        
        for(int i=0;i<s.length();i++){
            char cc = s.charAt(i);
            hm.put(cc,hm.getOrDefault(cc,0)+1);
        }
        
        List<Character>[] bucket = new List[s.length()+1];
        for(char i: hm.keySet()){
            int val = hm.get(i);
            if(bucket[val]==null){
                bucket[val] = new ArrayList<>();
            }
            
            bucket[val].add(i);
        }
        
        StringBuilder sb = new StringBuilder();
        for(int i=bucket.length-1;i>=0;i--){
            if (bucket[i] != null){
                for (char c : bucket[i]){
                    for (int j = 0; j < i; j++){
                        sb.append(c);
                    }
                }
            }
        }
        
        return sb.toString();
        
    }
}