class Solution {
    public List<Integer> findNumOfValidWords(String[] words, String[] puzzles) {
        
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0;i<words.length;i++){
            String curr = words[i];
            int mask =0;
            for(int j=0;j<curr.length();j++){
                mask |= 1<<(curr.charAt(j)-'a');
            }
            map.put(mask , map.getOrDefault(mask,0)+1);
        }
        
        List<Integer> res = new ArrayList<>();
        
        for(String p :puzzles){
            int mask =0;
            for(int i=0;i<p.length();i++){
                mask |= 1<<(p.charAt(i)-'a');
            }
            int c=0;
            int sub = mask;
            int first = (1<<(p.charAt(0)-'a'));
            while(true){
                if((sub&first)==first && map.containsKey(sub)){
                    c+=map.get(sub);
                }
                
                if(sub==0)
                    break;
                
                sub = (sub-1)&mask;
            }
            
            res.add(c);
        }
        
        return res;
    }
}