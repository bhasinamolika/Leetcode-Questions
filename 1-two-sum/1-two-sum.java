class Solution {
    public int[] twoSum(int[] nums, int target) {
        int ans[]=new int[2];
        HashMap<Integer,Integer> numIdx=new HashMap<>();
        
        for(int i=0;i<nums.length;i++){
            if(numIdx.containsKey(target-nums[i])){
                ans[0]=i;
                ans[1]=numIdx.get(target-nums[i]);
                return ans;
            }
            numIdx.put(nums[i],i);
        }
        return ans;
    }
}