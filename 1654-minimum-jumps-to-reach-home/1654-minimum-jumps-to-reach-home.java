class Solution {
    
    class Node {
        int pos;
        boolean isBackward;
        
        public Node (int pos) {
            this.pos = pos;
        }
        
        public Node (int pos, boolean isBackward) {
            this.pos = pos;
            this.isBackward = isBackward;
        }
    }
    
    public int minimumJumps(int[] forbidden, int a, int b, int x) {
        if (x == 0) return 0;
        
        int furthest = x + a + b;
        
        Set<Integer> forbiddenSet = new HashSet<>();   
        
        for (int ele : forbidden) {
            forbiddenSet.add(ele);
            furthest = Math.max(furthest, ele + a + b);
        }
        
        Deque<Node> queue = new ArrayDeque<>();
        queue.offerLast(new Node(0));
        
        Set<String> visited = new HashSet();
        
        int count=0;
        
        while (queue.size() != 0) {
            
            int sz = queue.size();
            
            while (sz-->0) {
            
                Node currPos = queue.pollFirst();
                visited.add(""+currPos.pos+(currPos.isBackward ? "T" : "F"));
                
                if (currPos.pos == x)   return count;

                if (currPos.isBackward) {
                    if (!forbiddenSet.contains(currPos.pos+a) &&
                        currPos.pos <= furthest &&
                        visited.add(""+(currPos.pos+a)+"F")) 
                        
                        queue.offerLast(new Node(currPos.pos + a, false));
                } else {
                    if (currPos.pos - b >= 0 && 
                        !forbiddenSet.contains(currPos.pos - b) &&
                        visited.add(""+(currPos.pos-b)+"T")) 
                        
                        queue.offerLast(new Node(currPos.pos - b, true));
                    
                    if (!forbiddenSet.contains(currPos.pos+a) &&
                        currPos.pos <= furthest &&
                        visited.add(""+(currPos.pos+a)+"F"))
                        
                        queue.offerLast(new Node(currPos.pos + a, false));
                }
            }
            count++;
        }
        
        return -1;
    }
}