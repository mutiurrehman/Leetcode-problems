class Solution {
   

    public int area(int r, int c, int[][] grid) {
        if (r < 0 || r >= grid.length || c < 0 || c >= grid[0].length || grid[r][c] == 0)
            return 0;
        grid[r][c] = 0;
        return (1 + area(r+1, c,grid) + area(r-1, c,grid)
                  + area(r, c-1,grid) + area(r, c+1,grid));
    }

    public int maxAreaOfIsland(int[][] grid) {
        int ans = 0;
        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {
                ans = Math.max(ans, area(r, c,grid));
            }
        }
        return ans;
    }
}