class Solution {
    public int subarraySum(int[] nums, int k) {
        int count =0;
        HashMap<Integer, Integer> map = new HashMap<>();
        int prefix =0;
        for(int i=0;i<nums.length;i++){
            prefix+=nums[i];
            if(prefix==k){
                count++;
            }
            
            if(map.containsKey(prefix-k)){
                count+=map.get(prefix-k);
            }
            
            if(map.containsKey(prefix)){
                map.put(prefix, map.get(prefix)+1);
            }
            else{
                map.put(prefix,1);
            }
        }
        
        return count;
    }
}