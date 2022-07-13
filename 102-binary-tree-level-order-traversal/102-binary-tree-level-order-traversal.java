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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> l = new ArrayList<>();
        if(root!=null){
           Queue<TreeNode> q = new LinkedList<>();
            q.add(root);
            while(!q.isEmpty()){
                List<Integer> innerList = new ArrayList<>();
                int count = q.size();
                for(int i=0; i<count; i++){
                   TreeNode temp = q.poll();
                    innerList.add(temp.val);
                    if(temp.left!=null)
                        q.add(temp.left);
                    if(temp.right!=null)
                        q.add(temp.right);
                }
                l.add(innerList); 
            }
        }
        return l;
    }
}
    
