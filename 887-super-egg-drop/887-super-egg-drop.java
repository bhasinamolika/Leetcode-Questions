class Solution {
 
    static int[][] dp;
    public int superEggDrop(int k, int n) {
        dp = new int[k+1][n+1];
        
        for(int[] row: dp){
            Arrays.fill(row,-1);
        }
        
        return solve(k,n);
    }
    
    static int solve(int e,int f){
        if(f==0 || f==1){
            return f;
        }
        
        if(e==1){
            return f;
        }
        if(dp[e][f]!=-1){
            return dp[e][f];
        }
        int min = Integer.MAX_VALUE;
        int high = f;
        int low = 1;
        
        while(low<=high){
            int k = low + (high-low)/2;
            
            int l = 0;
            int r= 0;
            
            if(dp[e-1][k-1]!=-1){
                l= dp[e-1][k-1];
            }else{
                l = solve(e-1,k-1);
            }
            
            if(dp[e][f-k]!=-1){
                r= dp[e][f-k];
            }else{
                r = solve(e,f-k);
            }
            
            if(l>r){
                high = k-1;
            }else{
                low = k+1;
            }
            
            int temp =  1+ Math.max(l,r);
            min = Math.min(min,temp);
        }
        
        
        return dp[e][f] = min;
    }
}