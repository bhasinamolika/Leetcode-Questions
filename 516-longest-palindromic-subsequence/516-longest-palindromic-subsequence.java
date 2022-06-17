class Solution {
    public int longestPalindromeSubseq(String s) {
        // Amolika thinks that if she finds the longest common subsequence between s and rev(s) then this problem will be easily solved
        // String rev=s.reverse();
        String rev="";
        for(int i=0;i<s.length();i++){
            rev=s.charAt(i)+rev;
        }
        return LCS(s,rev);
    }
    public int LCS(String s,String rev){
        int m=s.length();
        int dp[][]=new int[m+1][m+1];
        
        //initialisation
        for(int i=0;i<m+1;i++){
            for(int j=0;j<m+1;j++){
                if(i==0 || j==0)
                    dp[i][j]=0;
            }
        }
        //main code
        for(int i=1;i<m+1;i++){
            for(int j=1;j<m+1;j++){
                if(s.charAt(i-1)==rev.charAt(j-1))
                    dp[i][j]=dp[i-1][j-1]+1;
                else
                    dp[i][j]=Math.max(dp[i][j-1],dp[i-1][j]);
            }
        }
        return dp[m][m];
    }
}