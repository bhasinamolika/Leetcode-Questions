class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        
        final int n = nums.length;
        
        // stores if num is visited
        final boolean[] visited = new boolean[(int) (1e4 + 1)];

        int currSum = 0, maxSum = 0;
        
        for (int i=0, j=0; j<n; j++) {
            
            // checks if current element is unvisited
            if (!visited[nums[j]]) {
                currSum += nums[j]; // add to current sum
                visited[nums[j]] = true; // mark as visited
            } else {
                
                // if visited ele found then compare with maxSum so far
                if (maxSum < currSum) maxSum = currSum;
                
                // remove all elements (sum) before current duplicate element 
                while (nums[i] != nums[j]) {
                    visited[nums[i]] = false; // It is guaranteed that there are no duplicate elements present before current ele, so remove all elements and mark visited as false
                    currSum -= nums[i++];
                }
                
                // shift one index as i is currently in duplicate element
                i++;   
            }
        }        
        
        // handle last currSum since we only update maxSum on duplicate
        return maxSum < currSum ? currSum : maxSum;
    }
}