class Solution {
    public long[] getDistances(int[] arr) {
        HashMap<Integer, Long> sum = new HashMap<>();
        HashMap<Integer, Integer> count = new HashMap<>();
        
        int n = arr.length;
        long[] ans = new long[n];
        
        for(int i=0;i<n;i++){
            if(!sum.containsKey(arr[i])){
                sum.put(arr[i], 0L);
                count.put(arr[i], 0);
            }
            
            ans[i] += i*(long)count.get(arr[i]) - sum.get(arr[i]);
            sum.put(arr[i], sum.get(arr[i])+i);
            count.put(arr[i], count.get(arr[i])+1);
        }
        
        sum = new HashMap<>();
        count = new HashMap<>();
        for(int i=n-1;i>=0;i--){
            if(!sum.containsKey(arr[i])){
                sum.put(arr[i], 0L);
                count.put(arr[i], 0);
            }
            
            ans[i] += (n - i - 1)*(long)count.get(arr[i]) - sum.get(arr[i]);
            sum.put(arr[i], sum.get(arr[i]) + (n - i - 1));
            count.put(arr[i], count.get(arr[i])+1);
        }
        
        return ans;
    }
}