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
    
    TreeNode first;
    TreeNode second;
    TreeNode prev;    
        
    public void recoverTree(TreeNode root) {
        helper(root);
        swap(first, second);
    }
        
    public void helper(TreeNode root) {
        
        if(root != null) {
            
            helper(root.left);
            
            if(prev != null && prev.val > root.val) {
                first=root;
                if(second == null) 
                    second=prev;    
                }
            
            prev = root;
            
            helper(root.right);
        }
    }
    
    private void swap(TreeNode first, TreeNode second) {
        int temp = first.val;
        first.val = second.val;
        second.val = temp;
    }
}