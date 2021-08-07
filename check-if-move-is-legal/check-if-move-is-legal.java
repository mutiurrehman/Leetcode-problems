class Solution {
    public boolean checkMove(char[][] board, int rMove, int cMove, char color) {
        
        int count=0;
        boolean seen = false;
        
        for(int i=cMove+1;i<board[0].length;i++){
            
             if(board[rMove][i]==color){
                 seen = true;
             }
            if(board[rMove][i]==color || board[rMove][i]=='.'){
                
                break;
            }
            
            count++;
           
        }
        
         if(seen && count>=1)
            return true;
        count=0;
        seen = false;
        for(int i=cMove-1;i>=0;i--){
             if(board[rMove][i]==color){
                 seen = true;
             }
            
            if(board[rMove][i]==color|| board[rMove][i]=='.'){
                break;
            }
            count++;
            
        }
        
        if(seen && count>=1)
            return true;
        
        count=0;
        seen = false;
        for(int i=rMove+1;i<board.length;i++){
            
            if(board[i][cMove]==color)
                seen = true;
            
            if(board[i][cMove]==color|| board[i][cMove]=='.'){
                break;
            }
            count++;
          
        }
          if(seen && count>=1)
            return true;
        
         count=0;
        seen = false;
        for(int i=rMove-1;i>=0;i--){
            
            if(board[i][cMove]==color)
                seen = true;
            if(board[i][cMove]==color|| board[i][cMove]=='.'){
                break;
            }
            count++;
          
        }
          if(seen && count>=1)
            return true;
        
         count=0;
      seen = false;
        for(int i=rMove+1,j=cMove+1;i<board.length && j<board[0].length;i++,j++){
            
            
             if(board[i][j]==color){
                 seen = true;
             }
            
            if(board[i][j]==color|| board[i][j]=='.'){
                break;
            }
            count++;
          
        }
          if(seen && count>=1)
            return true;
        
        count=0;
      seen = false;
        for(int i=rMove+1,j=cMove-1;i<board.length && j>=0;i++,j--){
             if(board[i][j]==color){
                 seen = true;
             }
            
            if(board[i][j]==color|| board[i][j]=='.'){
                break;
            }
            count++;
          
        }
          if(seen && count>=1)
            return true;
        
        
         count=0;
      seen = false;
        for(int i=rMove-1,j=cMove+1;i>=0 && j<board[0].length;i--,j++){
            
             if(board[i][j]==color){
                 seen = true;
             }
            
            if(board[i][j]==color|| board[i][j]=='.'){
                break;
            }
            count++;
          
        }
          if(seen && count>=1)
            return true;
        
        
        
        count=0;
      seen= false;
        for(int i=rMove-1,j=cMove-1;i>=0 && j>=0;i--,j--){
            
             if(board[i][j]==color){
                 seen = true;
             }
            
            if(board[i][j]==color|| board[i][j]=='.'){
                break;
            }
            count++;
          
        }
          if(seen && count>=1)
            return true;
        
        return false;
    }
}