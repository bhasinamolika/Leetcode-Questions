class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int n = nums.length;
        
        //Check boundary conditions if smallest possible combination is still greater largest combination is less
        if (nums[0] + nums[1] + nums[2] >= target) return nums[0] + nums[1] + nums[2];
        if (nums[n-1] + nums[n-2] + nums[n-3] <= target) return nums[n-1] + nums[n-2] + nums[n-3];
        
        int closest = nums[0] + nums[1] + nums[n-1];
        int dif = Integer.MAX_VALUE;
        
        //Set 1 point and and iterate through other 2 points to find closest sum
        for (int i = 0; i < n-2; i++) {
            int l = i+1, r = n-1;
            while (l < r) {
                int sum = nums[i] + nums[l] + nums[r];
                int mid = l + (r-l)/2;
                
                //If current combination equals target return target as best possible result
                if (sum == target) return target;
                
                //Set difference and closest values if current combination is closer
                int curDif = (sum>target) ? sum - target : target - sum;
                if (curDif < dif) {
                    dif = curDif;
                    closest = sum;
                }
                
                //If sum is too high move right pointer.
                if (sum - target > 0) {
                    //Skip to middle and check if its still too high similar to binary search
                    if (r != mid && nums[i]+nums[l]+nums[mid] > target) {
                        r = mid;
                    } 
                    // Else iterate left until unique value
                    else {
                        while(--r > l && nums[r] == nums[r+1]);
                    }
                }  
                //Do the same for left pointer if sum is too low
                else {
                    if (l != mid && nums[i] + nums[mid] + nums[r] < target) {
                        l = mid;
                    } else {
                        while(++l < r && nums[l] == nums[l-1]);
                    }
                }
            }
        }
        return closest;
    }
}