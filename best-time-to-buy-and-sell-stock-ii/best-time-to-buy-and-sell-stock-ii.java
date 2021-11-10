class Solution {
    public int maxProfit(int[] arr) {
        int ans=0;
        int min = Integer.MAX_VALUE;
        for(int i=1;i<arr.length;i++){
            if(arr[i]>arr[i-1]){
                ans+=arr[i]-arr[i-1];
            }
        }
        
        return ans;
    }
}