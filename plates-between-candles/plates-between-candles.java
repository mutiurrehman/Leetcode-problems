class Solution {
    public int[] platesBetweenCandles(String s, int[][] queries) {
        int[] ans = new int[queries.length];
        
        TreeSet<Integer> plates = new TreeSet<>();
        List<Integer> platesList = new ArrayList<>();
        TreeSet<Integer> candles = new TreeSet<>();
        for(int i=0;i<s.length();i++){
            char cc = s.charAt(i);
            if(cc=='*'){
                plates.add(i);
                platesList.add(i);
            }
            else
                candles.add(i);
        }
        
        
        int i=0;
        for(int[] q: queries){
            int l = q[0], r = q[1];
            Integer lower, higher;
            if(candles.contains(l)){
                lower = l;
            }
            else{
                lower = candles.higher(l);
            }
            
            
            if(candles.contains(r)){
                higher = r;
            }
            else{
                higher = candles.lower(r);
            }
            
            if(lower==null || higher == null){
                ans[i++] = 0;
                continue;
            }
            
            if(lower >= higher){
                ans[i] = 0;
            }
            
            else{
                int idx1 = searchInsert(platesList, lower);
                int idx2 = searchInsert(platesList, higher);
                ans[i] = idx2-idx1;
            }
            i++;
        }
        
        
        return ans;
    }
    
     public int searchInsert(List<Integer> A, int b) {
        int l=0,h=A.size()-1;
        
        while(l<=h){
            int mid = (l+h)/2;
            if(A.get(mid)==b){
                return mid;
            }
            else if(A.get(mid)<b){
                l=mid+1;
            }
            else{
                h=mid-1;
            }
        }
        
        return l;
    }
}