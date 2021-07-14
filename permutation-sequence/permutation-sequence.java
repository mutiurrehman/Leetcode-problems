class Solution {
    public String getPermutation(int A, int B) {
        
   ArrayList<Integer> list = new ArrayList<>();
     int fact=1;
     for(int i=1;i<A;i++){
         list.add(i);
         fact*=i;
     }
        list.add(A);
        
        String ans="";
        B=B-1;
        while(true){
            ans += list.get(B/fact);
            list.remove(B/fact);
            if(list.size()==0){
                break;
            }
            
            B=B%fact;
            fact = fact/list.size();
        }
    
        return ans;
    }
    
}