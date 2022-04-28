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
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> ans=new ArrayList<>();
        List<Integer> temp=new ArrayList<>();
        if(root==null) return ans;
        Queue<Node> mq=new ArrayDeque<>();
        mq.add(root);
        mq.add(new Node(-1));
        while(mq.size()!=0){
            Node node=mq.remove();
            if(node.val!=-1){
            temp.add(node.val);
            for(Node child:node.children){
                mq.add(child);
            }
            }
            else{
                if(!mq.isEmpty())
                    mq.add(new Node(-1));
                ans.add(new ArrayList<>(temp));
                temp=new ArrayList<>();
            }
        }
        return ans;
    }
}