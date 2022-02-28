class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> ans = new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            int start = nums[i], end = nums[i];
            while(i<nums.length-1 && (nums[i+1]-nums[i])==1){
                i++;
            }
            end = nums[i];
            String curr = "";
            if(start==end){
                curr+=start;
            }
            else{
                curr+=start;
                curr+="->";
                curr+=end;
            }
            ans.add(curr);
        }
    
        return ans;
    }   
}