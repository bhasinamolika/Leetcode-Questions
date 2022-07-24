class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int dp[][]=new int[text1.length()+1][text2.length()+1];
        //initialisation
        for(int i=0;i<text1.length()+1;i++){
            for(int j=0;j<text2.length()+1;j++){
                if(i==0 || j==0)
                    dp[i][j]=0;
            }
        }
            //choice diagram
            for(int i=1;i<text1.length()+1;i++){
                for(int j=1;j<text2.length()+1;j++){
                    if(text1.charAt(i-1)==text2.charAt(j-1))
                        dp[i][j]=1+dp[i-1][j-1];
                    else
                        dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        String lcs="";
        int i=text1.length();
        int j=text2.length();
        while(i>0 && j>0){
            if(text1.charAt(i-1)==text2.charAt(j-1)){
                lcs=text1.charAt(i-1)+lcs;
                i--;
                j--;
            }    
            else{
                if(dp[i-1][j]>dp[i][j-1])
                    i--;
                else
                    j--;
            }
        }
        System.out.println(lcs);
        return dp[text1.length()][text2.length()];
    }
}