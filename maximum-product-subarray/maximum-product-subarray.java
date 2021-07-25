class Solution {
    public int maxProduct(int[] A) {
        int prod=1,max=Integer.MIN_VALUE;
        for(int i=0;i<A.length;i++){
            prod=prod*A[i];
            
            max =Math.max(prod,max);
            if(A[i]==0){
                prod=1;
            }
        }
        
        prod=1;
        for(int i=A.length-1;i>=0;i--){
            prod=prod*A[i];
            
            max =Math.max(prod,max);
            if(A[i]==0){
                prod=1;
            }
        }
        
        
        return max;
    }
}