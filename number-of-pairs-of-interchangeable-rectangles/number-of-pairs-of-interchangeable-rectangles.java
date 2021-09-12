class Solution {
    public long interchangeableRectangles(int[][] r) {
        HashMap<Double, Integer> map = new HashMap<>();
        
        for(int i=0;i<r.length;i++){
            
            double curr = (double)r[i][0]/r[i][1];
            if(map.containsKey(curr)){
                map.put(curr,map.get(curr)+1);
            }
            else{
                map.put(curr,1);
            }
        }
        
        long ans =0;
        for(double i:map.keySet()){
            if(map.get(i)>=2){
                int n = map.get(i);
              
                long ad = (n-1);
                
                long ad2 = n*ad;
               
                ans += ad2/2;
            }
        }
        
        return ans;
    }
}