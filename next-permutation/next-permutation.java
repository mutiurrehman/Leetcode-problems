class Solution {
    public void nextPermutation(int[] nums) {
        int index = -1;
        
        for(int i=nums.length-1;i>0;i--){
            if(nums[i]>nums[i-1]){
                index = i-1;
                break;
            }
        }
        
        if(index == -1){
            Arrays.sort(nums);
            return;
        }
        
        int indexToSwapWith = -1;
        for(int i = nums.length-1;i>index;i--){
            if(nums[i]>nums[index]){
                indexToSwapWith = i;
                break;
            }
        }
        
        int temp = nums[index];
        nums[index] = nums[indexToSwapWith];
        nums[indexToSwapWith]= temp;
        
        Arrays.sort(nums,index+1,nums.length);
        
    }
}