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
class BSTIterator {

    private TreeNode node = new TreeNode();
    private List<Integer> l = new ArrayList<>();
    private int count = 0;
    public BSTIterator(TreeNode root) {
        node = root;
        inorder(node);
    }
    
    public int next() {
        return l.get(count++);
    }
    
    private void inorder(TreeNode root){
        if(root == null)
            return;
        inorder(root.left);
        l.add(root.val);
        inorder(root.right);
    }
    
    public boolean hasNext() {
        if(l.size() != count)
            return true;
        else 
            return false;
    }
}
/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */