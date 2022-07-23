class Solution {
    public int helper(int i,int j,int m,int n,int[][]dp,int [][]Q){
        if(i==m-1 && j==n-1)
            return 1;
        if( i>=m || j>=n || Q[i][j]==1)
            return 0;
        
        if(dp[i][j]!=-1) return dp[i][j];
        int down=helper(i+1,j,m,n,dp,Q);
        int right=helper(i,j+1,m,n,dp,Q);
        
        dp[i][j]=down+right;
        return dp[i][j];
    } 
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m=obstacleGrid.length;
        int n=obstacleGrid[0].length;
        if(obstacleGrid[m-1][n-1]==1)
            return 0;
        int dp[][]=new int[m][n];
        for(int i=0;i<m;i++){
            Arrays.fill(dp[i],-1);
        }
        return helper(0,0,m,n,dp,obstacleGrid);
    }
}




