class Solution {
    public int minStoneSum(int[] piles, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        
        for(int i=0;i<piles.length;i++)
            pq.add(piles[i]);
        
        while(k-->0){
            int cur = pq.remove();
            pq.add((cur+1)/2);
        }
        int ans =0;
        while(!pq.isEmpty()){
            ans+=pq.poll();
        }
        
        return ans;
    }
}