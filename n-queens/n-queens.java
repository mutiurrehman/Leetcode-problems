 class Solution {
    public List<List<String>> solveNQueens(int a) {
        
        
        boolean[][] board = new boolean[a][a];
        char[][] ans = new char[a][a];
        for(int i=0;i<ans.length;i++)
        Arrays.fill(ans[i],'.');
        
        solve(board,0,ans);
        
        return res;
    }
    
    
    
    List<List<String>> res = new ArrayList<>();
    
    public void solve(boolean[][] board, int row, char[][] ans){
        if(board.length==row)
        {
            ArrayList<String> temp = new ArrayList<>();
            for(int i=0;i<ans.length;i++){
                temp.add(String.valueOf(ans[i]));
            }
            res.add(temp);
            return;
        }
        
        for(int col=0;col<board[0].length;col++){
            if(isItSafe(board,row,col)){
                ans[row][col]='Q';
                board[row][col]=true;
                solve(board,row+1,ans);
                ans[row][col]='.';
                board[row][col]=false;
                
            }
        }
        
    }
    
    public boolean isItSafe(boolean[][] board, int row, int col){
        
        for(int i=row;i>=0;i--){
            if(board[i][col])
                return false;
        }
        
        for(int i=row,j=col;i>=0 && j>=0;i--,j--){
             if(board[i][j])
                 return false;
        }
        
        for(int i=row,j=col;j<board.length && i>=0 ; i--,j++)
        if(board[i][j])
                 return false;
                 
                 return true;
    }
}
