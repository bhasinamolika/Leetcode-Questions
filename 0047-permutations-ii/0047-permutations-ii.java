class Solution {
    List<List<Integer>> ans;
    public List<List<Integer>> permuteUnique(int[] nums) {
        ans = new LinkedList<>();
        LinkedList<Integer> path = new LinkedList<>();
        boolean[] used = new boolean[nums.length];
        Arrays.sort(nums);
        backtrack(nums, path, used);
        return ans;
    }
    
    private void backtrack(int[] nums, LinkedList<Integer> path, boolean[] used) {
        if (path.size() == nums.length) {
            ans.add(new LinkedList<>(path));
        }
        
        for (int i = 0; i < nums.length; i++) {
            if (used[i]) {
                continue;
            }
            if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) {
                continue;
            }
            path.add(nums[i]);
            used[i] = true;
            backtrack(nums, path, used);
            used[i] = false;
            path.removeLast();
        }
    }
}