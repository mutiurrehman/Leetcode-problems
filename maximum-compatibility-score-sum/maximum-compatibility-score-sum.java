class Solution {
    public int maxCompatibilitySum(int[][] students, int[][] mentors) {
        
        boolean[] visited = new boolean[students.length];
         helper(students,mentors,0,0,visited);
        return max;
    }
    
    int max=Integer.MIN_VALUE;
    public void helper(int[][] st, int[][] mt, int pos, int score, boolean[] visited){
        
        if(pos>=st.length){
            max=Math.max(max,score);
            return;
        }
        
        for(int i=0;i<mt.length;i++){
            if(!visited[i]){
                visited[i]=true;
               helper(st,mt,pos+1,score+getScore(st[pos],mt[i]),visited); 
                visited[i]=false;
            }
        }
    }
    
    public int getScore(int[] st, int[] mt){
        int count=0;
        for(int i=0;i<st.length;i++){
            if(st[i]==mt[i])
                count++;
        }
        return count;
    }
}