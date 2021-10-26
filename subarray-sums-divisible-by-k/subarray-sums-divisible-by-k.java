class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int currSum=0;
        
        int count=0;
        for(int i=0;i<nums.length;i++){
            currSum+=nums[i];
            if(currSum%k==0){
                count++;
            }
            
            int rem = currSum%k;
            
            if(rem<0)
                rem+=k;
            
            if(map.containsKey(rem))
                count+=map.get(rem);
            
            map.put(rem,map.getOrDefault(rem,0)+1);
        }
        
        return count;
    }
}