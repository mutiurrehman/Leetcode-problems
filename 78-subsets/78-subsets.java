class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        
        helper(ans, new ArrayList<Integer>(),nums,0);
        return ans;
        
    }
    
    
    public void helper(List<List<Integer>> list, List<Integer> temp, int[] nums, int start){
        
        list.add(new ArrayList<>(temp));
        for(int i=start;i<nums.length;i++){
            temp.add(nums[i]);
            helper(list,temp,nums,i+1);
            temp.remove(temp.size()-1);
        }
    }
}