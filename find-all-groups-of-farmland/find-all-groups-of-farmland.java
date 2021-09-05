class Solution {
    public int[][] findFarmland(int[][] land) {
        int m = land.length;
        int n = land[0].length;
        List<int[]> list = new ArrayList<>();
        
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(land[i][j]==0)
                    continue;
                
                int c2=j;
                while(c2<n && land[i][c2]==1)
                    c2++;
                
                int r2=i;
                while(r2<m && land[r2][j]==1)
                    r2++;
                
                c2--;
                r2--;
                
                int[] temp = {i,j,r2,c2};
                list.add(temp);
                
                for(int k=i;k<=r2;k++){
                    for(int l=j;l<=c2;l++){
                        land[k][l]=0;
                    }
                }
            }
        }
        
        int[][] ans =new int[list.size()][4];
        for(int i=0;i<ans.length;i++){
            ans[i]=list.get(i);
        }
        
        return ans;
    }
}