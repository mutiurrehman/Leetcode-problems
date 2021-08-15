class Solution {
    public int[] rearrangeArray(int[] nums) {
        Arrays.sort(nums);
        int n=nums.length;
        
        int i=0,j=n-1;
        ArrayList<Integer> ans = new ArrayList<>();
        while(i<j){
            ans.add(nums[j]);
            ans.add(nums[i]);
            j--;
            i++;
        }
        if(n%2==1)
            ans.add(nums[i]);
        int[] res =  new int[ans.size()];
        for(int k=0;k<res.length;k++){
            res[k]=ans.get(k);
        }
        
        return res;
    }
}