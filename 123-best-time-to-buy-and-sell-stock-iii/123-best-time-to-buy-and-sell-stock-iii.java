class Solution {
    public int f(int ind,int canBuy,int cap,int []prices,int [][][]dp){
        if(ind==prices.length || cap==0)
            return 0;
        if(dp[ind][canBuy][cap]!=-1)
            return dp[ind][canBuy][cap];
        if(canBuy==1){
            dp[ind][canBuy][cap]=Math.max(-prices[ind]+f(ind+1,0,cap,prices,dp),0+f(ind+1,1,cap,prices,dp));
            return dp[ind][canBuy][cap];
        }
        else{
            dp[ind][canBuy][cap]=Math.max(prices[ind]+f(ind+1,1,cap-1,prices,dp),0+f(ind+1,0,cap,prices,dp));
            return dp[ind][canBuy][cap];
        }
        
    }
    public int maxProfit(int[] prices) {
        int dp[][][]=new int[prices.length][2][3];
        for(int i=0;i<prices.length;i++){
            for(int j=0;j<2;j++){
                Arrays.fill(dp[i][j],-1);
            }
        }
        return f(0,1,2,prices,dp);
    }
}