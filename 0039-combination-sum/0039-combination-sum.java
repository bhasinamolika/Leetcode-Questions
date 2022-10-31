class Solution {
    public void fun(int ind,int [] candidates, int target,List<List<Integer>> ans, List<Integer> ds){
        if (target==0){
            ans.add(new ArrayList<>(ds));
            return;
        }
        if(ind==candidates.length){
            return;
        }
        if(candidates[ind]<=target){
            ds.add(candidates[ind]);
            fun(ind,candidates,target-candidates[ind],ans,ds);
            ds.remove(ds.size()-1);
        }
        fun(ind+1,candidates,target,ans,ds);
    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans=new ArrayList<>();
        fun(0,candidates,target,ans,new ArrayList<>());
        return ans;
    }
}