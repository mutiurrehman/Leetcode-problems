class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        
        int cur = image[sr][sc];
        boolean[][] vis = new boolean[image.length][image[0].length];
        dfs(image,sr,sc,newColor,vis,cur);
        return image;
    }
    
    public void dfs(int[][] image, int sr, int sc, int n, boolean[][] vis, int cur){
        if(sr<0||sr>=image.length||sc<0||sc>=image[0].length||vis[sr][sc]||image[sr][sc]!=cur )
            return ;
        
        vis[sr][sc]=true;
        image[sr][sc]=n;
        
         dfs(image,sr-1,sc,n,vis,cur);
         dfs(image,sr,sc-1,n,vis,cur);
         dfs(image,sr,sc+1,n,vis,cur);
         dfs(image,sr+1,sc,n,vis,cur);
    }
}