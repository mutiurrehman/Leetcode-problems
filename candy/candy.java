class Solution {
    public int candy(int[] A) {
        int n= A.length;
        int[] l2r = new int[n];
        int[] r2l = new int[n];
        
        l2r[0]=1;
        for(int i=1;i<n;i++) {
            if(A[i-1]<A[i]) {
                l2r[i]=l2r[i-1]+1;
            }else{
                l2r[i]=1;
            }
        }
        
        r2l[n-1]=1;
        for(int i=n-2;i>=0;i--){
            if(A[i+1]<A[i]){
                r2l[i]=r2l[i+1]+1;
            }else{
                r2l[i]=1;
            }
        }
        
        int sum=0;
        for(int i=0;i<n;i++){
            sum+=Math.max(l2r[i],r2l[i]);
        }
        
        return sum;
    }
}