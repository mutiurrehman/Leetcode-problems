class Solution {
    int maxOr = 0;
    public int countMaxOrSubsets(int[] nums) {
        
        
        for(int i:nums){
            maxOr|=i;
        }
        
        helper(nums,0,0);
        
        return count;
    }
    
    int count=0;
    public void helper(int[] arr, int start, int or){
        
        if(maxOr==or)
            count++;
        
        for(int i=start;i<arr.length;i++){
            helper(arr,i+1,or|arr[i]);
        }
    }
}