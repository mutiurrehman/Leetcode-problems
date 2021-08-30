class Solution {
    public String convert(String s, int numRows) {
        
        if (numRows == 1) return s;

        
        List<StringBuilder> sb = new ArrayList<>();
        for(int i=0;i<Math.min(numRows,s.length());i++)
            sb.add(new StringBuilder());
        
        int curRow= 0;
        boolean goingDown = false;
        
        for(char c : s.toCharArray()){
            sb.get(curRow).append(c);
            if(curRow==0 || curRow == numRows-1)
                goingDown = !goingDown;
            
            curRow += goingDown ? 1 : -1; 
        }
        
        StringBuilder ans = new StringBuilder();
        
        for(int i=0;i<sb.size();i++)
            ans.append(sb.get(i));
        
        return ans.toString();
    }
}