class Solution {
    public int maxProfit(int[] prices, int fee) {
        int obsp=-prices[0];
        int ossp = 0;
        
        for(int i=1;i<prices.length;i++){
            int tossp=ossp;
            ossp = Math.max(ossp,obsp+prices[i]-fee);
            obsp=Math.max(obsp,tossp-prices[i]);
        }
        
        return ossp;
    }
}