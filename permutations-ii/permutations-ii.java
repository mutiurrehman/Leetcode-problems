class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        
        boolean[] used = new boolean[nums.length];
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        helper(list,new ArrayList<Integer>(),nums,used);
        return list;
    }
    
    
    public void helper(List<List<Integer>> list, List<Integer> temp, int[] nums, boolean[] used){
      if(temp.size()==nums.length){
          list.add(new ArrayList<Integer>(temp));
          return;
      }
        else{
            for(int i=0;i<nums.length;i++){
                if(used[i])
                    continue;
                if(i>0 && nums[i-1]==nums[i] && !used[i-1])
                    continue;
                
                used[i]=true;
                temp.add(nums[i]);
                helper(list,temp,nums,used);
                used[i]=false;
                temp.remove(temp.size()-1);
            }
        }
        
    }
}