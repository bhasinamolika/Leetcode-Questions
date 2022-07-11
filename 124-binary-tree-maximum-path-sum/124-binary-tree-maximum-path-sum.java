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
    public int maxPathSum(TreeNode root) {
        // Using array to create a refference based variable to store  max sum till now.
        int ans[] =new int[1];
        ans[0] = Integer.MIN_VALUE;
        dfs(root,ans);
        return ans[0];
    }
    
    int dfs(TreeNode root, int[] maxTillNow){
        if(root == null){
            return 0;
        }
        int l = Math.max(0,dfs(root.left, maxTillNow));
        int r = Math.max(0,dfs(root.right, maxTillNow));
        maxTillNow[0] = Math.max(maxTillNow[0], l+r+root.val);
        return Math.max(0,Math.max(l,r)+root.val);
    }
}