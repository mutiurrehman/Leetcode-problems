class Solution {
    public void solve(char[][] board) {
        
        for(int i=0;i<board[0].length;i++){
            dfs(board,0,i);
            dfs(board,board.length-1,i);
        }
        
        for(int i=0;i<board.length;i++){
            dfs(board,i,0);
            dfs(board,i,board[0].length-1);
        }
        
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[i].length;j++){
                if(board[i][j]=='1')
                    board[i][j]='O';
                else
                    board[i][j]='X';
            }
        }
    }
    
    
    public void dfs(char[][] board, int i, int j){
        
        if(board[i][j]=='O'){
            board[i][j]='1';
            
            if(i>0)
                dfs(board,i-1,j);
            
            if(i<board.length-1)
                dfs(board,i+1,j);
            
            if(j<board[i].length-1)
                dfs(board,i,j+1);
            
            if(j>0)
                dfs(board,i,j-1);
        }
    }
}