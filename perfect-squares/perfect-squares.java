class Solution {
    public int numSquares(int n) {
        Queue<Integer> q = new LinkedList<>();
        HashSet<Integer> set = new HashSet<>();
        
        set.add(0);
        q.add(0);
        int depth = 0;
        while(!q.isEmpty()){
            depth++;
            int size = q.size();
            for(int i=0;i<size;i++){
                int curr = q.poll();
                
                for(int j=1;j*j<=n;j++){
                    int val = curr+ j*j;
                    if(set.contains(val)){
                        continue;
                    }
                    
                    if(val== n)
                        return depth;
                    if(val>n)
                        break;
                    if(!set.contains(val)){
                        set.add(val);
                        q.add(val);
                    }
                }
            }
        }
        
        return depth;
    }
}