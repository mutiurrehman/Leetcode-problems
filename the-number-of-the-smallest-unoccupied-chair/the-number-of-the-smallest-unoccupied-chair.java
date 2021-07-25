class Solution {
    public int smallestChair(int[][] times, int targetFriend) {
        int targetStart = times[targetFriend][0];
        Arrays.sort(times,(a,b)->(a[0]-b[0]));
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i=0;i<times.length;i++)
            pq.add(i);
        
        PriorityQueue<int[]> leaving = new PriorityQueue<>((a,b)->(a[0]-b[0]));
        
        for(int i=0;i<times.length;i++){
            while(!leaving.isEmpty() && leaving.peek()[0]<=times[i][0]){
                pq.add(leaving.poll()[1]);
            }
            
            if(targetStart==times[i][0]){
                break;
            }
            
            leaving.add(new int[]{times[i][1],pq.poll()});
        }
        
        return pq.peek();
    }
}