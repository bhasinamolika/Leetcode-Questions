class Solution {
    int perimeter = 0;
    public int islandPerimeter(int[][] grid) {
        int perimeter = 0;
        for(int i=0;i<grid.length;i++) {
            for(int j=0;j<grid[i].length;j++) {
                if(grid[i][j] == 1) {
                    int ans = 4;
                    if(check(grid,i+1,j)) ans--;
                    if(check(grid,i-1,j)) ans--;
                    if(check(grid,i,j+1)) ans--;
                    if(check(grid,i,j-1)) ans--;
                    perimeter += ans;
                }
            }
        }
        return perimeter;
    }
    
    public boolean check(int[][] grid, int i, int j) {
        if(i>=0 && i<grid.length && j>=0 && j<grid[i].length && grid[i][j] == 1)
            return true;
        return false;
    }
}