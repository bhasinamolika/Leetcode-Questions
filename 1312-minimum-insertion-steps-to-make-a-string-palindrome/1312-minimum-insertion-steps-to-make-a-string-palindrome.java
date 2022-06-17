class Solution {
    public int minInsertions(String s) {
        //answer will be same even if we wanted to know to know the minimum deletions
        //we can make the insertions anywhere in the string that's why it is same
        //just find the length of LPS and ans will be s.length()-LPS length
        String rev="";
        for(int i=0;i<s.length();i++){
            rev=s.charAt(i)+rev;
        }
        return func(s,rev);
    }
    public int func(String s,String rev){
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
                    dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
            }
        }
        return s.length()-dp[m][m];
    }
}