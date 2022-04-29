class Solution {
    public boolean isBipartite(int[][] graph) {
        int[] visited = new int[graph.length];
        int[] colorNodes = new int[graph.length];
        Arrays.fill(colorNodes, -1); // Initially every node has color -1
        Arrays.fill(visited, -1); // No node is visited
        boolean ans = false;
        // Breadth first traversal for alternate coloring
        for(int i = 0; i < graph.length; ++i){// BFS for Disconnected Graph
            if(visited[i] == -1){
                 ans = bfs(graph,visited,colorNodes,i);
                if(ans == false){// Whenever alternate color is same then quit
                    break;
                }
            }
        }
        
        return ans;
    }
    public boolean bfs(int[][] graph, int[] visited,int[] colorNodes,int src){
        boolean res = true;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(src); // Add source to queue
        colorNodes[src] = 0;// 0 means red
        
        while(!queue.isEmpty()){
            int neighbor = queue.poll(); // Pop out first element and visit its neighbors
            int color = colorNodes[neighbor];
            if(visited[neighbor] == -1){ // if not visited
                visited[neighbor] = 1; // mark neighbor as visited
                for(int start = 0; start < graph[neighbor].length; ++start){ //Push all neighbors into queue
                    if(visited[graph[neighbor][start]] == -1){ // If neighbor is not visited
                        queue.add(graph[neighbor][start]); // Add neighbor of src
                        if(color == colorNodes[graph[neighbor][start]]){ // If the color of neighbor is same as color of source then we can say that graph is not bipartite since one-to-one mapping rule is violated
                            return false;
                        }
                        // Assign alternate color to neighbor
                        if(color == 0){ 
                            colorNodes[graph[neighbor][start]] = 1;
                        }
                        else{
                            colorNodes[graph[neighbor][start]] = 0;
                        }
                    } 
                }
            }
        }
        return res;
    }
}