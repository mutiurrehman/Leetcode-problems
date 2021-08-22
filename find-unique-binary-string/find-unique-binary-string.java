class Solution {
    public String findDifferentBinaryString(String[] nums) {
        
        
        String res="";
        
        for(int i=0;i<nums.length;i++){
            res+=(1-(nums[i].charAt(i)-'0'));
        }
        
        
        return res;
    }
}