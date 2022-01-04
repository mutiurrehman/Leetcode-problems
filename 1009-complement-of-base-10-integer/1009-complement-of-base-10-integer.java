class Solution {
    public int bitwiseComplement(int num) {
        if(num==0)
            return 1;
        int i = 0;
        int j = 0;
        
        while (i < num){
            i += Math.pow(2, j);
            j++;
        }
        
        return i - num;
    }
}