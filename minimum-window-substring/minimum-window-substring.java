class Solution {
    public String minWindow(String A, String B) {
        
       HashMap<Character, Integer> map = new HashMap<>();
        for(int i=0;i<B.length();i++){
            char c = B.charAt(i);
            if(map.containsKey(c))
            map.put(c,map.get(c)+1);
            else
            map.put(c,1);
        }
        
        int i=0,j=0,count=map.size(),ans =Integer.MAX_VALUE,start=0,end=0;
        
        while(j<A.length()){
            char cc = A.charAt(j);
            if(map.containsKey(cc)){
                map.put(cc,map.get(cc)-1);
                if(map.get(cc)==0)
                count--;
            }
            
                    
                    while(count==0){
                        
                        if(ans> j-i+1){
                            ans=j-i+1;
                            start=i;
                            end=j;
                        }
                        
                        char cd = A.charAt(i);
                        if(map.containsKey(cd)){
                            map.put(cd,map.get(cd)+1);
                            if(map.get(cd)>0)
                            count++;
                            
                        }
                        i++;
                
                }
                j++;
            }
            
            if(ans == Integer.MAX_VALUE)
            return "";
            
            return A.substring(start,end+1);
            
        
    }
}