class Solution {
    public int maxProfit(int[] prices) {
        int profit=0;
        int leastSoFar=prices[0];
        int n=prices.length;
        
        for(int i=1;i<n;i++){
            if(prices[i]>leastSoFar){
                profit+=prices[i]-leastSoFar;
                leastSoFar=prices[i];
            }
            else if(prices[i]<leastSoFar){
                leastSoFar=prices[i];
            }
        }
        return profit;
    }
}