class Solution {
    public int findMiddleIndex(int[] nums) {
        int n = nums.length;
        if(n==1)
            return 0;
        
       
        
        int[] suffix = new int[n];
        suffix[n-1] = nums[n-1];
        for(int i=n-2;i>=0;i--){
            suffix[i] = suffix[i+1]+nums[i];
        }
        
         int[] prefix = new int[n];
        prefix[0]=nums[0];
        for(int i=1;i<n;i++){
            prefix[i]=prefix[i-1]+nums[i];
        }
        
        int index =-1;
        for(int i=0;i<n;i++){
            if(i==0){
                if(i<n-1 && suffix[i+1]==0) {
                    index =i;
                    break;
                }
            }
            else if(i==n-1){
                if(i>0 && prefix[i-1]==0){
                    index =i;
                    break;
                }
            }
            else{
                if(i>0 && i<n-1 && prefix[i-1]==suffix[i+1]){
                    index =i;
                    break;
                }
            }
        }
        
        return index;
    }
}