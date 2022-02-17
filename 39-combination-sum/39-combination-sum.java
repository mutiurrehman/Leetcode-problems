class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        
        helper(ans, new ArrayList<Integer>(),candidates,0,target);
        
        return ans;
    }
    
    
    public void helper(List<List<Integer>> ans, List<Integer> temp, int[] arr, int start, int target){
        if(target==0){
            if(!ans.contains(temp))
                ans.add(new ArrayList<Integer>(temp));
            
            return;
        }
        if(target<0)
            return;
        
        for(int i=start;i<arr.length;i++){
            temp.add(arr[i]);
            helper(ans,temp,arr,i,target-arr[i]);
            temp.remove(temp.size()-1);
        }
    }
}