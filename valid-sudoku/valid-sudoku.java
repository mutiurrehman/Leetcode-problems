class Solution {
    public boolean isValidSudoku(char[][] board) {
        
        HashSet<String> set = new HashSet<>();
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                
                char cc = board[i][j];
                if(cc!='.'){
                    if(!set.add(cc + " in row " + i) || !set.add(cc + " in coloumn " + j) || !set.add(cc + " in block "+ i/3 + "-" + j/3))
                        return false;
                }
            }
        }
        
        return true;
    }
}