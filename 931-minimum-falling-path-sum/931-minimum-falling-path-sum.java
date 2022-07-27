class Solution {
    int f(int [][]matrix,int i,int j,int dp[][]){
        if(j<0 || j>=matrix[0].length)
            return 1000000;
        if(i==0) return matrix[0][j];
        
        if(dp[i][j]!=-1) return dp[i][j];
        int u=matrix[i][j]+f(matrix,i-1,j,dp);
        int ld=matrix[i][j]+f(matrix,i-1,j-1,dp);
        int rd=matrix[i][j]+f(matrix,i-1,j+1,dp);
        
        dp[i][j]=Math.min(u,Math.min(ld,rd));
        
        return dp[i][j];
    }
    public int minFallingPathSum(int[][] matrix) {
        int m=matrix.length;
        int n=matrix[0].length;
        int ans=Integer.MAX_VALUE;
        int dp[][]=new int[m][n];
        for(int i=0;i<m;i++){
            Arrays.fill(dp[i],-1);
        }
        for(int i=0;i<n;i++){
            ans=Math.min(ans,f(matrix,m-1,i,dp));
        }
        return ans;
    }
}