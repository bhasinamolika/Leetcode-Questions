class Solution {
    static boolean subsetSum(int[] nums,int sum) {
        boolean[][] dp=new boolean[nums.length+1][sum+1];
        for (int i=0;i<=nums.length;i++) {
            for (int j=0;j<=sum;j++) {
                if (i==0 && j==0) dp[i][j]=true;
                else if (i==0||j==0) dp[i][j]=false;
                else if (nums[i-1]<=j) {
                    dp[i][j]=dp[i-1][j]||dp[i-1][j-nums[i-1]];
                }
                else {
                    dp[i][j]=dp[i-1][j];
                }
                
            }
        }
        return dp[nums.length][sum];
    }
    public boolean canPartition(int[] nums) {
        int sum=0;
        for (int i:nums) sum+=i;
        if (sum%2!=0) return false;
        return subsetSum(nums,sum/2);
    }
}