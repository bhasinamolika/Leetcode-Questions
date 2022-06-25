class Solution {
    public boolean checkPossibility(int[] nums) {
        int j=-1;
        //currently no out of order banda in our array 
        for(int i=0;i+1<nums.length;i++){
            if (nums[i] > nums[i + 1]) {
			if (j != -1) 
				return false; // > 1 outlier, impossible
			j = i;
		}
        }
	return j < 1
		|| j == nums.length - 2 
		|| nums[j - 1] <= nums[j + 1]
		|| nums[j] <= nums[j + 2] ;
    }
        
}