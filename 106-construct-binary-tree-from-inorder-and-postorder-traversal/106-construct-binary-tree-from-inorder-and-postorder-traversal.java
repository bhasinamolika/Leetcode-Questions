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
    HashMap<Integer, Integer> map;
    int last;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        map = new HashMap<Integer, Integer>();
        for(int i = 0; i < inorder.length; i++)
            map.put(inorder[i], i);
        last = postorder.length-1;
        return helper(inorder, 0, inorder.length-1, postorder);
    }
    
    public TreeNode helper(int[] inorder, int start, int end, int[] postorder) {
        if (start > end) return null;
        TreeNode root = new TreeNode(postorder[last]);
        int mid = map.get(postorder[last]);
        last--;
        root.right = helper(inorder, mid+1, end, postorder);
        root.left = helper(inorder, start, mid-1, postorder);
        return root;
    }
}