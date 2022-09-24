/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> ans=new ArrayList<>();
        dfs(root,ans,0,new ArrayList<>(),targetSum);
        return ans;
    }
    public void dfs(TreeNode root,List<List<Integer>> ans,int runningSum,List<Integer> runningList,int targetSum){
        if(root==null)
            return;
        
        targetSum-=root.val;
        runningList.add(root.val);
        
        if(root.right==null && root.left==null && targetSum==0){
            ans.add(runningList);
            return;
        }
        
        
        dfs(root.left,ans,runningSum+root.val,new ArrayList<>(runningList),targetSum);
        dfs(root.right,ans,runningSum+root.val,new ArrayList<>(runningList),targetSum);
    }
}