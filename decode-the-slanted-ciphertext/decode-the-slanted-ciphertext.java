class Solution {
    public String decodeCiphertext(String s, int rows) {
        int n = s.length();
        char[][] grid = new char[rows][n/rows];
        
        int index = 0;
        for(int i=0;i<rows;i++){
            for(int j=0;j<grid[i].length;j++){
                grid[i][j] = s.charAt(index);
                index++;
            }
        }
        
        StringBuilder ans = new StringBuilder();
        for(int i=0;i<grid[0].length;i++){
            int ind = i;
            for(int j=0;j<grid.length && ind <grid[0].length;j++){
                ans.append(grid[j][ind]);
                ind++;
            }
        }
        String text = ans.toString();
        text = text.replaceFirst("\\s++$", "");
            
        return text;
    }
}