class Solution {
    public int minimumOperations(int[] nums, int start, int goal) {
        
        
        Queue<Integer> q = new LinkedList<>();
        int moves =0;
        q.add(start);
        Set<Integer> set = new HashSet<>();
        while(!q.isEmpty()){
            int size = q.size();
            
            for(int i=0;i<size;i++){
                int curr = q.poll();
                if(curr==goal)
                    return moves;
                
                if(set.contains(curr) || curr<0 || curr>1000)
                    continue;;
                set.add(curr);
                for(int j=0;j<nums.length;j++){
                    q.add(curr+nums[j]);
                    q.add(curr-nums[j]);
                    q.add(curr^nums[j]);
                }
            }
            moves++;
        }
        
        return -1;
    }
}