class Solution {
    public String shortestCommonSupersequence(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();
        int[][] dp = new int[n+1][m+1];
             
        int len = lcs_tabu(s1,n,s2,m,dp);
       
        int i=n,j=m;
        StringBuilder sb = new StringBuilder();
        while(i>0 && j>0){
            if(s1.charAt(i-1) == s2.charAt(j-1)){
                sb.append(s1.charAt(i-1));
                i--;
                j--;
            }else if(dp[i-1][j] > dp[i][j-1]){
                sb.append(s1.charAt(i-1));
                i--;
            }else{
                sb.append(s2.charAt(j-1));
                j--;
            }
        }
        
        while(i>0){
            sb.append(s1.charAt(i-1));
            i--;
        }
        while(j>0){
            sb.append(s2.charAt(j-1));
            j--;
        }
        
        
        return sb.reverse().toString();
    }
    
       
    public int lcs_tabu(String s1,int N,String s2,int M,int[][] dp){        
        
        for(int n=0;n<=s1.length();n++){
            for(int m=0;m<= s2.length();m++){
                if(n==0 || m==0){
                    dp[n][m] = 0;
                    continue;
                }
                if(s1.charAt(n-1) == s2.charAt(m-1)){
                    dp[n][m] = dp[n-1][m-1] + 1;
                }else{
                    dp[n][m] = Math.max(dp[n-1][m],dp[n][m-1]);
                }
            }
        }
             return dp[N][M];
    }
}