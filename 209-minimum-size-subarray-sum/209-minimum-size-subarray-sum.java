class Solution {
    public int minSubArrayLen(int k, int[] nums) {
         int sum=0;
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
        }
        if(sum<k) return 0;
        
        int start_index=0;
        int n=nums.length;
        int start=0;
        int end=0;
        int minlength=n;
        int currsum=0;
        while(end<n){
            while(currsum<k && end<n){
                currsum+=nums[end];
                end++;
            }
            while(currsum>=k && start<n){
                if (end - start <= minlength) {
					minlength = end - start;
					start_index = start;
				}

				// remove starting elements
				currsum = currsum - nums[start];
				start++;
            }
        }
        return minlength;
    }
}