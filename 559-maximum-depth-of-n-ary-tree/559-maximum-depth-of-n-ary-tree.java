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
    public int maxDepth(Node root) {
        int level=0;
        if(root!=null){
        for(Node child:root.children){
            int clevel=maxDepth(child);
            level=Math.max(level,clevel);
        }
       
        level=level+1;
        }
        return level;
    }
}