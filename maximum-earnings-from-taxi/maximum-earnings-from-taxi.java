class Solution {
    
    
    class job{
        int strt,end,profit;
        job(int strt, int end, int profit){
            this.strt = strt;
            this.end = end;
            this.profit = profit;
        }
    }
    
    public long maxTaxiEarnings(int n, int[][] rides) {
        
        int n1 = rides.length;
        int[] startTime = new int[n1];
        int[] endTime = new int[n1];
        int[] profit = new int[n1];
        
        for(int i=0;i<n1;i++){
            startTime[i] = rides[i][0];
            endTime[i] = rides[i][1];
            profit[i] = rides[i][1]-rides[i][0]+rides[i][2];
        }                                              
                                               
        
        List<job> arr = new ArrayList<>();
        for(int i=0;i<startTime.length;i++) {
            arr.add(new job(startTime[i],endTime[i],profit[i]));
        }
        Collections.sort(arr, (a,b) -> (a.end-b.end));
        TreeMap<Integer, Long> map = new TreeMap<>();
        long ans = 0;
        
        for(job curr : arr) {
            Integer entryTillStartTime = map.floorKey(curr.strt);
            long maxProfitTillStartTime = entryTillStartTime == null ? 0 : map.get(entryTillStartTime);
            ans = Math.max(ans, maxProfitTillStartTime + curr.profit);
            map.put(curr.end, ans);
        }
        
        return ans;
    }
}