class Solution {
    public int minimizedMaximum(int n, int[] arr) {
       if(n==1)
            return arr[0];
        
    
        int m = arr.length;
        if(m==1)
            return 1;
        long min = 0,max=0;
        long sum=0;
        for(int i=0;i<m;i++){
            max = Math.max(max, arr[i]);
            sum+=arr[i];
        }
        
        if(sum<n)
            return 1;
        
        while(min<max){
            long mid = min + (max-min)/2;
            
            long cnt=0;
            for(int i=0;i<m;i++){
                if(arr[i]%mid==0)
                cnt+=(arr[i]/mid);
                else{
                    cnt+=(arr[i]/mid)+1;
                }
            }
            
            if(cnt<=n){
                max = mid;
            }
            else{
                min = mid+1;
            }
        }
        
        return (int)max;
    }
}