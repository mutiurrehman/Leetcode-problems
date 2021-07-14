class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> res = new ArrayList<>();
        helper(res, new ArrayList<Integer>(),candidates,0,target);
        return res;
    }
    
    public void helper(List<List<Integer>> res, ArrayList<Integer> temp, int[] nums, int start, int remain){
        if(remain<0)
            return;
        else if(remain==0 && !res.contains(new ArrayList<Integer>(temp)))
        res.add(new ArrayList<Integer>(temp));
        else{
            for(int i=start;i<nums.length;i++){
                temp.add(nums[i]);
                helper(res,temp,nums,i+1,remain-nums[i]);
                temp.remove(temp.size()-1);
            }
        }
    }
    
}