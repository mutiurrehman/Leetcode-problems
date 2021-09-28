class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
     
        HashMap<String, Integer> map = new HashMap<>();
        for(int i=0;i<words.length;i++){
            map.put(words[i],map.getOrDefault(words[i],0)+1);
        }
        List<Integer> res = new ArrayList<>();
        int m = words[0].length();
        int n =  words[0].length()*words.length;
        for(int i=0;i<=s.length()-n;i++){
            String toCheckIn = s.substring(i,i+n);
            
            HashMap<String, Integer> check = new HashMap<>();
            for(int j=0;j<toCheckIn.length();j=j+m){
                
                String curr = toCheckIn.substring(j,j+m);
                if(check.containsKey(curr)){
                    check.put(curr, check.get(curr)+1);
                }
                else{
                    check.put(curr,1);
                }
            }
            if(check.equals(map)){
                res.add(i);
            }
        }
        
        return res;
    }
}