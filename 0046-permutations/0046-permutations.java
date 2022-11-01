class Solution {
    //swapping approach
    private void f(int [] nums,int idx,List<List<Integer>> ans){
        if(idx==nums.length){
            ArrayList<Integer> ds=new ArrayList<>();
            for(int i=0;i<nums.length;i++){
                ds.add(nums[i]);
            }
            ans.add(new ArrayList<>(ds));
            return;
        }
        for(int i=idx;i<nums.length;i++){
            swap(nums,idx,i);
            f(nums,idx+1,ans);
            swap(nums,idx,i);
        }
    }
    private void swap(int []nums,int i,int j){
        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans=new ArrayList<>();
        f(nums,0,ans);
        return ans;
    }
}