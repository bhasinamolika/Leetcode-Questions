class Solution {
    
    public int helper(int i,int j,int m,int n,int[][]dp){
        if(i==m-1 && j==n-1)
            return 1;
        if(i<0 || i>=m || j<0 || j>=n)
            return 0;
        
        if(dp[i][j]!=-1) return dp[i][j];
        int down=helper(i+1,j,m,n,dp);
        int right=helper(i,j+1,m,n,dp);
        
        dp[i][j]=down+right;
        return dp[i][j];
    } 
    public int uniquePaths(int m, int n) {
         int dp[][]=new int[m][n];
        for(int i=0;i<m;i++){
            Arrays.fill(dp[i],-1);
        }
        return helper(0,0,m,n,dp);
    }
}