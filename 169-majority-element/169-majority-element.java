class Solution {
    public int majorityElement(int[] nums) {
        int maj1 = -1, maj2 =-1;
        int count1=0, count2=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i] == maj1){
                count1++;
            }
            else if(nums[i] == maj2){
                count2++;
            }
            else if(count1==0){
                count1++;
                maj1 = nums[i];
            }
            else if(count2==0){
                count2++;
                maj2 = nums[i];
            }
            else{
                count1--;
                count2--;
            }
        }
        
        count1=0;count2=0;
        for(int i=0;i<nums.length;i++){
            if(maj1==nums[i])
            count1++;
            if(maj2==nums[i])
            count2++;
        }
        
        if(count1>nums.length/2)
        return maj1;
        
        return maj2;
        
    }
}