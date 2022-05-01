class Solution {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String, Node> dict = new HashMap<>();
        
        for (int i = 0; i < values.length; i++) {
            String leafKey = equations.get(i).get(0);
            String rootKey = equations.get(i).get(1);
            dict.putIfAbsent(leafKey, new Node(leafKey));
            dict.putIfAbsent(rootKey, new Node(rootKey));
            Node leaf = dict.get(leafKey);
            Node root = dict.get(rootKey);
            
            if (detectLoop(root, leaf)) continue;
            
            double val = values[i];
            while (!leaf.key.equals(root.key) && leaf.root != null) {
                val /= leaf.val;
                leaf =  leaf.root;
            }
            
            if (!leaf.key.equals(root.key)) {
                leaf.val = val;
                leaf.root = root;
            }
        }
        
        double[] res = new double[queries.size()];
        for (int i = 0; i < queries.size(); i++) {
            String leafKey = queries.get(i).get(0);
            String rootKey = queries.get(i).get(1);
            Node leaf = dict.get(leafKey);
            Node root = dict.get(rootKey);
            
            if (leaf == null || root == null) {
                res[i] = -1;
                continue;
            }
            
            double leafVal = leaf.val;
            while (leaf.root != null) {
                leaf = leaf.root;
                leafVal *= leaf.val;
            }
            double rootVal = root.val;
            while (root.root != null) {
                root = root.root;
                rootVal *= root.val;
            }
            res[i] = root.key.equals(leaf.key) ? leafVal/rootVal : -1;
        }
        
        return res;
    }
    
    private boolean detectLoop(Node root, Node leaf) {
        boolean loop = false;
        do {
            if (root.key.equals(leaf.key)) {
                loop = true;
                break;
            }
            root = root.root;
        } while (root != null);
        return loop;
    }
    
    class Node {
        String key;
        double val;
        Node root;
        public Node(String key) {
            this.key = key;
            this.val = 1;
        }
    }
}