class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for(int i:nums){
            set.add(i);
        }
        
        int ans =0;
        for(int i: set){
            if(!set.contains(i-1)){
                int currElement = i;
                int curr = 1;
                while(set.contains(currElement+1)){
                    currElement+=1;
                    curr++;
                }
                ans = Math.max(ans, curr);
            }
        }
        
        return ans;
    }
}