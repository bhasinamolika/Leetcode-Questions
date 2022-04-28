/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    public List<Integer> postorder(Node root) {
        List<Integer> ans=new ArrayList<>();
        if(root!=null)
            helper(ans,root);
        return ans;
    }
    public void helper(List<Integer> ans,Node root){
        for(Node child:root.children){
            helper(ans,child);
        }
        ans.add(root.val);
    }
}