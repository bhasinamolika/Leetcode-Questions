class Solution {
public int findTargetSumWays(int[] nums, int S) {
int sum = 0;
for (int n: nums) sum += n;
if (sum < S || (sum - S) % 2 == 1) return 0;
int target = (sum - S) / 2;
int[] dp = new int[target + 1];
dp[0] = 1;
for (int i = 0; i < nums.length; i++) {
for (int j = target; j >= nums[i]; j--) {
dp[j] += dp[j - nums[i]];
}
}
return dp[target];
}
}