class Solution {
    
    class job{
        int strt,end,profit;
        job(int strt, int end, int profit){
            this.strt = strt;
            this.end = end;
            this.profit = profit;
        }
    }
    
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        
        List<job> arr = new ArrayList<>();
        for(int i=0;i<startTime.length;i++) {
            arr.add(new job(startTime[i],endTime[i],profit[i]));
        }
        Collections.sort(arr, (a,b) -> (a.end-b.end));
        TreeMap<Integer, Integer> map = new TreeMap<>();
        int ans = 0;
        
        for(job curr : arr) {
            Integer entryTillStartTime = map.floorKey(curr.strt);
            int maxProfitTillStartTime = entryTillStartTime == null ? 0 : map.get(entryTillStartTime);
            ans = Math.max(ans, maxProfitTillStartTime + curr.profit);
            map.put(curr.end, ans);
        }
        
        return ans;
    }
}