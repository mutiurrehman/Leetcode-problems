class Solution {
    public int finalValueAfterOperations(String[] o) {
        int ans =0;
        
        for(int i=0;i<o.length;i++){
            String curr = o[i];
            if(curr.charAt(0)=='+' || curr.charAt(2)=='+')
                ans++;
            else
                ans--;
        }
        return ans;
    }
}