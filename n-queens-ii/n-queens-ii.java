class Solution {
    public int totalNQueens(int a) {
   boolean[][] board = new boolean[a][a];
    
        solve(board,0);
        
        return count;
    }
    
    
    int count=0;
    public void solve(boolean[][] board, int row){
        if(board.length==row)
        {
           count++;
            return;
        }
        
        for(int col=0;col<board[0].length;col++){
            if(isItSafe(board,row,col)){             
                board[row][col]=true;
                solve(board,row+1);
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
