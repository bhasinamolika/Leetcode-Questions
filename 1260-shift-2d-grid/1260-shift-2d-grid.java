class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {

    int m = grid.length;
    int n = grid[0].length;
    
    int totalElements = m * n;
    
    if(k == 0  ||  k % totalElements == 0)
        return (List)Arrays.asList(grid);
    
    List<List<Integer>> res = new ArrayList<>();
    
    k = k % totalElements; 
    
    int start = m * n - k; 
    
    for (int i = 0; i < m * n;) {
        
        List<Integer> line = new ArrayList<>();
        
        for (int j = 0; j < n; j++) {
            
            int pos = (i + start) % totalElements;
            
            line.add(grid[pos / n][pos % n]);
            
            i++;
        }
        
        res.add(line);
    }
    
    return res;
}
}