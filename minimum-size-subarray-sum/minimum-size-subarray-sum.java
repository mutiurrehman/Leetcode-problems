class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int[] preSum = new int[nums.length];
        
        preSum[0]=nums[0];
        for(int i=1;i<nums.length;i++){
            preSum[i]=preSum[i-1]+nums[i];
        }
        if(preSum[nums.length-1]<target)
            return 0;
        int i=0,j=0,len=nums.length;
        while(j<nums.length){
            if(preSum[j]>=target){
                len =Math.min(j+1,len);
            }
            
            if((preSum[j]-preSum[i])>=target){
                while(preSum[j]-preSum[i]>=target){
                    i++;
                }
             
                len=Math.min(len,j-i+1);
            }
            j++;
        }
     
        return len;
    }
}