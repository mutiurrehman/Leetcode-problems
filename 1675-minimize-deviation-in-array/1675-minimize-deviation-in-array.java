class Solution {
    public int minimumDeviation(int[] A) {
        
        
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->(b-a));
        int min = Integer.MAX_VALUE, res = Integer.MAX_VALUE;
        for(int i:A){
            if(i%2==1)
                i = i*2;
            
            pq.add(i);
            min = Math.min(min, i);
        }
        
        while(pq.peek()%2==0){
            int curr = pq.poll();
            res = Math.min(res, curr - min);
            min = Math.min(min, curr/2);
            pq.add(curr/2);
        }
        
        return Math.min(res, pq.peek()-min);
    }
}