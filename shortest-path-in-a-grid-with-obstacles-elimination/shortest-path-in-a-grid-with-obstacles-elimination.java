class Solution {
    public int shortestPath(int[][] grid, int k) {
     
        int m = grid.length, n = grid[0].length;
        int[][] seen = new int[m][n];
        for(int i=0;i<m;i++){
            Arrays.fill(seen[i], Integer.MAX_VALUE);
            
        }
        
        int step = 0;
        int[][] dirs= {{0,1},{1,0},{-1,0},{0,-1}};
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0,0,0});
        seen[0][0] = 0;
        
        while(!q.isEmpty()){
            int size = q.size();
            
            for(int i=0;i<size;i++){
                int[] curr = q.poll();
                int x = curr[0], y = curr[1];
                if(x==m-1 && y == n-1)
                    return step;
                
                for(int[] dir:dirs){
                    int newX = dir[0]+x, newY = dir[1]+y;
                    if(newX<0 || newX>=m || newY<0|| newY>=n){
                        continue;
                    }
                    
                    int o = grid[newX][newY]+curr[2];
                    if(o>=seen[newX][newY] || o>k)
                        continue;
                    seen[newX][newY] = o;
                    q.add(new int[]{newX, newY, o});
                }
            }
            step++;
        }
        
        return -1;
    }
}