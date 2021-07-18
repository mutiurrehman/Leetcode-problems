class Solution {
    public int addRungs(int[] rungs, int dist) {
     int ans=0;
        int[] arr = new int[rungs.length+1];
        for(int i=1;i<arr.length;i++)
            arr[i]=rungs[i-1];
        
        arr[0]=0;
        
        for(int i=0;i<arr.length-1;i++)
        {
            if((arr[i+1]-arr[i])>dist){
                if((arr[i+1]-arr[i])%dist==0)
                      ans+=(arr[i+1]-arr[i])/dist -1;
                else
                      ans+=(arr[i+1]-arr[i])/dist;
              
            }
        }
        return ans;
    }
}