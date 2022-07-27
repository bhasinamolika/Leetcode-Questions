class Solution {
    
    public int maxProfit(int k, int[] prices) {
        int dp[][][]=new int[prices.length+1][2][k+1];
        for(int ind=prices.length-1;ind>=0;ind--){
            for(int canBuy=0;canBuy<2;canBuy++){
                for(int cap=1;cap<=k;cap++){
                    
                    if(canBuy==1)
                    {
                        dp[ind][canBuy][cap]=Math.max(-prices[ind]+dp[ind+1][0][cap],0+dp[ind+1][1][cap]);
                        
                    }
                    else{
                        dp[ind][canBuy][cap]=Math.max(prices[ind]+dp[ind+1][1][cap-1],0+dp[ind+1][0][cap]);
                    }
                }
            }
        }
        return dp[0][1][k];
    }
}