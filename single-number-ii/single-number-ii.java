class Solution {
    public int singleNumber(int[] nums) {
        
        int ans=0;
        for(int i=0;i<32;i++){
            int count=0;
            for(int j: nums){
                if((j&(1<<i))!=0)
                    count++;
            }
            
            if(count%3!=0)
                ans+=(1<<i);
        }
        
        return ans;
    }
}