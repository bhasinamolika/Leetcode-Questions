class Solution {
int max=0;
int count=0;
public int maxAreaOfIsland(int[][] grid) {
int[][] visited=new int[grid.length][grid[0].length];
for(int i=0;i<grid.length;i++){
for(int j=0;j<grid[0].length;j++){
if(visited[i][j]==0 && grid[i][j]==1){
count=0;
maxArea(grid,visited,i,j);
}
}
}
return max;
}
void maxArea(int[][] grid,int[][] visited,int i,int j){
if(i<0||j<0||i>=grid.length || j>=grid[0].length || visited[i][j]==1 || grid[i][j]==0){
return;
}
visited[i][j]=1;
count++;
maxArea(grid,visited,i+1,j);
maxArea(grid,visited,i,j+1);
maxArea(grid,visited,i-1,j);
maxArea(grid,visited,i,j-1);
max=Math.max(max,count);
}
}