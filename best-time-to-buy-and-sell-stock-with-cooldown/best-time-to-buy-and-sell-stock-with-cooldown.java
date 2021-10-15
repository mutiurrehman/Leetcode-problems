class Solution {
    public int maxProfit(int[] prices) {
        int obsp = - prices[0], ossp = 0, ocsp=0;
        
        for(int i=0;i<prices.length;i++){
            int nbsp=0,nssp=0, ncsp=0;
            
            if(ocsp - prices[i]>obsp){
                nbsp = ocsp - prices[i];
            }
            else{
                nbsp = obsp;
            }
            
            if(obsp+prices[i]>ossp){
                nssp = obsp + prices[i];
            }
            else{
                nssp = ossp;
            }
            
            if(ossp>ocsp){
                ncsp = ossp;
            }
            else{
                ncsp = ocsp;
            }
            
            obsp = nbsp;
            ocsp = ncsp;
            ossp = nssp;
        }
        
        return ossp;
    }
}