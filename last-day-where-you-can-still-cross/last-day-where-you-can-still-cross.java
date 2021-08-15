class Solution {
    public int latestDayToCross(int row, int col, int[][] cells) {
        int left = 1, right = cells.length;
        int ans=0;
        while(left<=right){
            int mid = (left+right)/2;
            if(canWalk(cells,row,col,mid)){
                ans=mid;
                left=mid+1;
            }
            else
                right=mid-1;
        }
        
        return ans;
    }
    
    int[] dir = {0,1,0,-1,0};
    public boolean canWalk(int[][] cells, int row, int col, int mid){
        int[][] grid = new int[row][col];
        for(int i=0;i<mid;i++)
            grid[cells[i][0]-1][cells[i][1]-1]=1;
        
        Queue<int[]> q = new LinkedList<>();
        for(int i=0;i<col;i++)
            if(grid[0][i]==0){
                q.add(new int[]{0,i});
                grid[0][i]=1;
            }
        while(!q.isEmpty()){
            int[] curr = q.remove();
            int r = curr[0],c=curr[1];
            if(r==row-1)
                return true;
            for(int i=0;i<4;i++){
                int nr = r+dir[i], nc = c+dir[i+1];
                if(nr<0 || nr>=row || nc<0 || nc>=col || grid[nr][nc]==1 )
                    continue;
                grid[nr][nc]=1;
                q.add(new int[]{nr,nc});
            }
        }
        
     return false;   
    }
}