
class Solution {
    public void gameOfLife(int[][] board) {
        
        int m=board.length;
        int n=board[0].length;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                visit8(i,j,board);
            }
        }
        
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(board[i][j]==-1) board[i][j]=0;
                else if(board[i][j]==2) board[i][j]=1;
            }
        }
    }
    private void visit8(int i,int j,int [][] board){
        int count=0;
        int firsti=i;
        int firstj=j;
        int [][] dirs={{1,0},{0,1},{-1,0},{0,-1},{1,1},{-1,-1},{-1,1},{1,-1}};
        for(int k=0;k<dirs.length;k++){
            int row=firsti+dirs[k][0];
            int col=firstj+dirs[k][1];
            if(row<0 || row>=board.length || col<0 || col>=board[0].length) continue;
            if(board[row][col]==1 || board[row][col]==-1) count++;
        }
        if(board[i][j]==1 && (count!=2 && count!=3)){
            board[i][j]=-1;
        }
        if(board[i][j]==0 && count==3 ) board[i][j]=2;
        
    }
}