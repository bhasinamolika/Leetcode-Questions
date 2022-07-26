class Solution {
    public int maxProfit(int[] prices) {
        int leastSoFar=prices[0];
        int maxProfit=0;
        int ProfitToday=0;
        int n=prices.length;
        for(int i=0;i<n;i++){
            leastSoFar=Math.min(leastSoFar,prices[i]);
            ProfitToday=prices[i]-leastSoFar;
            maxProfit=Math.max(maxProfit,ProfitToday);
        }
        return maxProfit;
    }
}