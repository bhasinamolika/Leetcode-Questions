class Solution {
    public boolean increasingTriplet(int[] nums) {
        int min= Integer.MAX_VALUE,mid = Integer.MAX_VALUE;//declared two variable for the middle and minimum or first
        for(int i =0;i<nums.length;i++)
        {
            if(nums[i]<min) //store the min of all in min
            min=nums[i];
            if(nums[i]>min&&nums[i]<mid)// ensure that mid is greater than min and less than mid 
            mid=nums[i];
            if(nums[i]>mid) // ensuring mid as greatest as mid must be smaller than last one.
            return true;
        }
       return false;
    }
}