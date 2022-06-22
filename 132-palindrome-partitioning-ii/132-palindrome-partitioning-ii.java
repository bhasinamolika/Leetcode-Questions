class Solution {
    int dp[][]=new int[2001][2001];
    public boolean isPalindrome(String s,int start,int end){
        boolean flag=true;
        while(start<end){
            if(s.charAt(start)!=s.charAt(end)) return false;
            start++;
            end--;
        }
        return flag;
    }
    public int minCut(String s) {
        for(int r=0;r<dp.length;r++){
            for(int c=0;c<dp[0].length;c++){
                dp[r][c]=-1;
            }
        }
        int i=0,j=s.length()-1;
        return minPalPartion(s,i,j);
    }
    int minPalPartion(String string, int i, int j){   
      if( i >= j || isPalindrome(string, i, j) )
        return 0;
        
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
         dp[i][j] = Integer.MAX_VALUE;
         for(int k = i; k < j; k++){
             if(isPalindrome(string,i,k)){
              int count = Math.min(dp[i][j], minPalPartion(string, i, k) +
                   minPalPartion(string, k + 1, j) + 1);
 
              dp[i][j]=count;
             }
         }
    return dp[i][j];
  }
}