class Solution {
    public int[] searchRange(int[] nums, int target) {
        int [] res = {-1,-1};
        
        int greatestIdx = greatest(nums, target);
        int smallestIdx = smallest(nums, target);
        
        res[0] = smallestIdx;
        res[1] = greatestIdx;
        
        return res;
    }
    
    private int smallest(int [] nums, int target){
        int l = 0;
        int r = nums.length - 1;
        
        while(l <= r){
            int midIdx = l + (r - l)/2;
            int midVal = nums[midIdx];
            
            if(midVal < target){
                l = midIdx + 1;
            }else if(midVal > target){
                r = midIdx - 1;
            }else{
                if(midIdx == 0){
                    return midIdx;
                }
                
                if(nums[midIdx - 1] != target){
                    return midIdx;
                }
                
                r = midIdx - 1;
            }
        }
        
        return -1;
    }
    
    private int greatest(int [] nums, int target){
        int l = 0;
        int r = nums.length - 1;
        
        while(l <= r){
            int midIdx = l + (r - l)/2;
            int midVal = nums[midIdx];
            
            if(midVal < target){
                l = midIdx + 1;
            }else if(midVal > target){
                r = midIdx - 1;
            }else{
                if(midIdx == nums.length - 1){
                    return midIdx;
                }
                
                if(nums[midIdx + 1] != target){
                    return midIdx;
                }
                
                l = midIdx + 1;
            }
        }
        
        return -1;
    }
}