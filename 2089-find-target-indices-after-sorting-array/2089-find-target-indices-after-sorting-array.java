class Solution {
    
    public List<Integer> targetIndices(int[] nums, int target) {
        List<Integer> ans=new ArrayList<>();
        Arrays.sort(nums);
        int start=0,end=nums.length-1,mid=0;
        while(start<=end){
            mid=start+(end-start)/2;
            if(nums[mid]==target){
                ans.add(mid);
                break;
            }
            else if(nums[mid]<target){
                start=mid+1;
                
            }
            else if(nums[mid]>target){
                end=mid-1;
            }
        }
        
        for(int i=mid+1;i<nums.length;i++){
            if(nums[i]==target)
            ans.add(i);
            else
                break;
        }
        for(int i=mid-1;i>=0 && nums[i]==target;i--){
            ans.add(i);
        }
        Collections.sort(ans);
        return ans;
    }
}