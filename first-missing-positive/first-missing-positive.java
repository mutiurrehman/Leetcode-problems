class Solution {
    public int firstMissingPositive(int[] nums) {
        for(int i=0;i<nums.length;i++){
            int num = nums[i];
            int pos = num-1;
            while(pos>=0 && pos<nums.length && nums[pos]!=num){
                nums[i] = nums[pos];
                nums[pos]=num;
                i--;
            }
        }
        
        for(int i=0;i<nums.length;i++){
            if(nums[i]!=i+1)
                return i+1;
        }
        
        return nums.length+1;
    }
}