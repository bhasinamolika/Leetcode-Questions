class Solution {
    public int maxResult(int[] nums, int k) {
        int len = nums.length;
        int[] dp = new int[len];
        dp[0] = nums[0];
        
        Deque<Integer> dq = new ArrayDeque<>();
        
        for (int i = 1; i < len; i++) { 
            //to determin dp[i] we need dp[i-3] [i-2] [i-1] in the deque, so after i++:
            //currently in queue: i - 4 i - 3 i - 2 for k = 3
            
            //Now we need the deque including i-3, i-2, i-1
            //1- remove out-ranged idx from queue:
            if (!dq.isEmpty() && dq.peek() < i - k) dq.poll(); //queue: i - 3, i - 2
            //2- maintain the deque as mono-decreasing stack:
            while (!dq.isEmpty() && dp[dq.peekLast()] < dp[i - 1]) {
                dq.pollLast();    
            }
            dq.offerLast(i - 1); //queue: i-3, i-2, i-1
            
            //update dp[i]
            int maxLast = dp[dq.peek()];
            dp[i] = nums[i] + maxLast;
        }
        return dp[len - 1];
    }
}