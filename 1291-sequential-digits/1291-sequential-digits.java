class Solution {
    public List<Integer> sequentialDigits(int low, int high) {
        Queue<Integer> q = new LinkedList<>();
        
        for(int i=1;i<=9;i++){
            q.add(i);
        }
        
        List<Integer> ans = new ArrayList<>();
        while(!q.isEmpty()){
            int f = q.poll();
            if(f<=high && f>=low){
                ans.add(f);
            }
            
            if(f>high)
                break;
            
            int rem = f%10;
            if(rem<9){
                q.add(f*10+rem+1);
            }
        }
        
        return ans;
    }
}