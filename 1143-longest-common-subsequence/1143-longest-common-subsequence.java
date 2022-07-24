class Solution {
    // this is not the most optimal approach,refer the previous submission for more optimal solution but this will also work if you need to print out the longest common subsequence , in that case the return type will be string and we will return dp[text1.length][text2.length] you came up with this approach yourself, refer your notes for optimal solution given by Aditya Verma
    

    public int longestCommonSubsequence(String text1, String text2) {
        String dp[][]=new String[text1.length()+1][text2.length()+1];
        //initialisation
        for(int i=0;i<text1.length()+1;i++){
            for(int j=0;j<text2.length()+1;j++){
                if(i==0 || j==0)
                    dp[i][j]="";
            }
        }
            //choice diagram
            for(int i=1;i<text1.length()+1;i++){
                for(int j=1;j<text2.length()+1;j++){
                    if(text1.charAt(i-1)==text2.charAt(j-1))
                        dp[i][j]=dp[i-1][j-1]+text1.charAt(i-1);
                    else{
                        String max =dp[i-1][j].length()>dp[i][j-1].length()?dp[i-1][j]:dp[i][j-1];
                        dp[i][j]=max;
                    }
                        // dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
                        
                }
            }
        
        return dp[text1.length()][text2.length()].length();
    }
}
