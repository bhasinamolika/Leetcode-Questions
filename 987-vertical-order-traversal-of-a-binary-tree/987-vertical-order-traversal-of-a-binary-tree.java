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
public class Tuple{
    TreeNode node;
    int vh;
    int lh;
   Tuple(TreeNode node , int vh , int lh){
        this.node = node;
        this.vh = vh;
        this.lh = lh;
    }
}
class Solution {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        
        List<List<Integer>> ans = new ArrayList<>();
        TreeMap<Integer,TreeMap<Integer,PriorityQueue<Integer>>> mp = new TreeMap<>();
        Queue<Tuple> q = new LinkedList<>();
        if(root==null){
            return ans;
        }
        q.add(new Tuple(root,0,0));
        
        while(!q.isEmpty()){
            Tuple p = q.poll();
            TreeNode node = p.node;
            int verticalHeight = p.vh;
            int level = p.lh;
            
            if(!mp.containsKey(verticalHeight)){
                mp.put(verticalHeight,new TreeMap<>());
            }
            if(!mp.get(verticalHeight).containsKey(level)){
                mp.get(verticalHeight).put(level,new PriorityQueue<>());
            }
            
            mp.get(verticalHeight).get(level).add(node.val);
            
            if(node.left!=null){
                q.add(new Tuple(node.left,verticalHeight-1,level+1));
            }
            if(node.right!=null){
                q.add(new Tuple(node.right,verticalHeight+1,level+1));
            }
        }
        
        for(TreeMap<Integer,PriorityQueue<Integer>> tm : mp.values()){
            List<Integer> curr = new LinkedList<>();
            for(PriorityQueue<Integer> nodes : tm.values()){
                while(!nodes.isEmpty()){
                    int node = nodes.poll();
                    curr.add(node);
                }
            }
            ans.add(curr);
            
        }
        return ans;
        
    }
}