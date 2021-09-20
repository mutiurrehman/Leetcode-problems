class Solution {
    public String longestSubsequenceRepeatedK(String s, int k) {
        String res="";
        Queue<String> q = new LinkedList<>();
        q.add("");
        
        while(!q.isEmpty()){
            int size = q.size();
            while(size-->0){
                String curr = q.poll();
                
                for(int j=0;j<26;j++){
                    String next = curr+(char)('a'+j);
                    if(isSubK(s,next,k)){
                        res = next;
                        q.add(next);
                    }
                }
            }
        }
        
        return res;
    }
    
    
    public boolean isSubK(String s, String next, int k){
        int j=0, repeat=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)==next.charAt(j)){
                j++;
                if(j==next.length()){
                    repeat++;
                    if(repeat == k)
                        return true;
                    j=0;
                }
            }
        }
        return false;
    }
}