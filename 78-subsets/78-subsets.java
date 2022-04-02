class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans=new ArrayList<>();
        List<Integer> temp=new ArrayList<>();
        fill(ans,nums,0,temp);
        return ans;
    }
    public void fill(List<List<Integer>> ans,int[] nums,int idx,List<Integer> temp){
        if(idx==nums.length){
            ArrayList<Integer> out = new ArrayList<>(temp);
            ans.add(out);
            return;
        }
        temp.add(nums[idx]);
        fill(ans,nums,idx+1,temp);
        temp.remove(temp.size()-1);
        fill(ans,nums,idx+1,temp);
        return;
    }
}