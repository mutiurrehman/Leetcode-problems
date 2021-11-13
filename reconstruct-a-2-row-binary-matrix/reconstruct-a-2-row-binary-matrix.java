class Solution {
    public List<List<Integer>> reconstructMatrix(int upper, int lower, int[] colsum) {
        int[][] ans = new int[2][colsum.length];
        
        List<List<Integer>> res = new ArrayList<>();
        
        for(int i=0;i<colsum.length;i++){
            if(colsum[i]==2){
                if(lower<=0)
                    return res;
                
                if(upper<=0)
                    return res;
                
                ans[0][i]=1;
                ans[1][i]=1;
                lower--;
                upper--;
            }
        }
        
         for(int i=0;i<colsum.length;i++){
             if(colsum[i]==1){
                 if(upper>0){
                     ans[0][i] = 1;
                     upper--;
                 }
                 else if(lower>0){
                     ans[1][i] = 1;
                     lower--;
                 }
                 else{
                     return res;
                 }
             }
         }
        
        if(lower>0 ||upper>0)
        return res;
        
        for(int i=0;i<ans.length;i++){
            List<Integer> temp = new ArrayList<>();
            for(int j=0;j<ans[i].length;j++){
                temp.add(ans[i][j]);
            }
            res.add(temp);
        }
        
        return res;
    }
}