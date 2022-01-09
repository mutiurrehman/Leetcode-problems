class Solution {
    public boolean isRobotBounded(String str) {
        
        int x=0, y=0, dir=0;
        int[][] dirs ={{0,1},{1,0},{0,-1},{-1,0}};
        
        for(int i=0;i<str.length();i++){
            char cc = str.charAt(i);
            if(cc=='R'){
                dir=(dir+1)%4;
                
            }
            else if(cc=='L'){
                dir = (dir+3)%4;
            }
            else{
                x+=dirs[dir][0];
                y+=dirs[dir][1];
            }
            
        }
        
        return (x==0 && y==0) || dir>0;
    }
}