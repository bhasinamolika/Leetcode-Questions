class Solution {
    int f(String word1,int i,String word2,int j,int [][]dp){
        if(i==0) return j;
        if(j==0) return i;
        if(dp[i][j]!=-1) return dp[i][j];
        if(word1.charAt(i-1)==word2.charAt(j-1)){
            dp[i][j]=0+f(word1,i-1,word2,j-1,dp);
            return dp[i][j];
        }
        else{
            //insert 1+f(i,j-1)
            //delete 1+f(i-1,j)
            //replace 1+f(i-1,j-1)
            dp[i][j]=Math.min(1+f(word1,i,word2,j-1,dp),Math.min(1+f(word1,i-1,word2,j,dp),1+f(word1,i-1,word2,j-1,dp)));
            return dp[i][j];
        }
    }
    public int minDistance(String word1, String word2) {
        int m=word1.length();
        int n=word2.length();
        int dp[][]=new int[m+1][n+1];
        for(int i=0;i<m+1;i++){
            Arrays.fill(dp[i],-1);
        }
        return f(word1,m,word2,n,dp);
    }
}