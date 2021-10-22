class Solution {
    public String frequencySort(String s) {
        HashMap<Character, Integer> hm = new HashMap<>();
        
        for(int i=0;i<s.length();i++){
            char cc = s.charAt(i);
            hm.put(cc,hm.getOrDefault(cc,0)+1);
        }
        
        List<Map.Entry<Character, Integer>> list =
               new LinkedList<Map.Entry<Character, Integer> >(hm.entrySet());
 
        Collections.sort(list, new Comparator<Map.Entry<Character, Integer> >() {
            public int compare(Map.Entry<Character, Integer> o1,
                               Map.Entry<Character, Integer> o2)
            {
                return (o1.getValue()).compareTo(o2.getValue());
            }
        });
         
        StringBuilder sb = new StringBuilder();
        for(int i=list.size()-1;i>=0;i--){
            int size = list.get(i).getValue();
            while(size-->0){
                sb.append(list.get(i).getKey());
            }
        }
        
        return sb.toString();
    }
}