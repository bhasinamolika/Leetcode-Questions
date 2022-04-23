class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ans=new ArrayList<>();
        List<Integer> temp=new ArrayList<>();
        solve(ans,temp,n,k);
        return ans;
    }
    public void solve(List<List<Integer>> ans,List<Integer> temp,int n,int k){
        if(n<0) return;
        if(temp.size()==k){
            ans.add(new ArrayList<>(temp));
            return;
        }
        temp.add(n);
        solve(ans,temp,n-1,k);
        temp.remove(temp.size()-1);
        solve(ans,temp,n-1,k);
    }
}