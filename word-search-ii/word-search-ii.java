class Solution {
    public List<String> findWords(char[][] board, String[] words) {
        List<String> ans = new ArrayList<>();
       
        HashSet<String> set= new HashSet<>();
     for(int k=0;k<words.length;k++){
        String word = words[k];
          boolean[][] vis = new boolean[board.length][board[0].length];
        for(int i =0;i<board.length;i++){
            for(int j=0;j<board[i].length;j++){
                    if(board[i][j]==word.charAt(0)){
                        if(dfs(board,word,i,j,0,vis) && !set.contains(word)){
                            ans.add(word);
                            set.add(word);
                        }
                    }
                }
            }
        }
        
        return ans;
    }
    
    public boolean dfs(char[][] board, String word, int i, int j, int index, boolean[][] vis){
        
        
        if(index==word.length()){
            return true;
        }
        
        if(i<0 || i>=board.length || j<0 || j>=board[i].length || vis[i][j]||board[i][j] != word.charAt(index))
            return false;
        
       
        vis[i][j]=true;
        if(dfs(board, word,i+1,j,index+1,vis) || dfs(board, word,i-1,j,index+1,vis) || dfs(board, word,i,j+1,index+1,vis) || dfs(board, word,i,j-1,index+1,vis))
           return true;
        
        vis[i][j]=false;
        return false;
    }
    
}