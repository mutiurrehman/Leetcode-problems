class Solution {
    public int countNumbersWithUniqueDigits(int n) {
        if(n==0)
            return 1;
        
        int res=10;
        int uniqueNumbers = 9;
        int availableDigits = 9;
        while(n-->1 && availableDigits>0){
            uniqueNumbers*=availableDigits;
            res+=uniqueNumbers;
            availableDigits--;
        }
        
        return res;
    }
}