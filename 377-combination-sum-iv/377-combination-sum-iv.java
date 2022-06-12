class Solution {
public int combinationSum4(int[] nums, int target) {

    int n = nums.length;
    int dp[] = new int[target+1];
    Arrays.fill(dp,-1);
    int ans = func(nums,target,n,dp);
    return ans;
    
}


public int func(int nums[],int t,int n,int dp[]){
    if(t==0) return 1;
    if(dp[t]!=-1) return dp[t];
    int cnt =0;
    for(int i=0;i<n;i++){
        if(nums[i]<=t){
            cnt+=func(nums,t-nums[i],n,dp);
        }
    }
    return dp[t]= cnt;
}
}