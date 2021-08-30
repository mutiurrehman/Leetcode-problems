class Solution {
    public int maxCount(int m, int n, int[][] ops) {
        if(ops.length==0)
            return m*n;
        
       int minRow = Integer.MAX_VALUE;
        int minCol= Integer.MAX_VALUE;
        for(int i=0;i<ops.length;i++){
            minRow = Math.min(minRow,ops[i][0]);
            minCol = Math.min(minCol,ops[i][1]);
        }
        
        return minRow*minCol;
    }
}