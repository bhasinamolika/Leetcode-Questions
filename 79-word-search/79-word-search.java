class Solution {
    static boolean vis[][];
    public boolean exist(char[][] board, String word) {
        vis = new boolean[board.length][board[0].length];
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                if(word.charAt(0) == board[i][j] && search(0, i, j, board, word, vis)){
                    return true;
                }
            }
        }
        return false;
    }
    public boolean search(int ind, int i, int j, char[][] board, String word, boolean[][]vis)
    {
        if(ind == word.length()){
            return true;
        }
        
        if(i < 0 || i >= board.length || j < 0 || j >= board[0].length || 
          board[i][j] != word.charAt(ind) || vis[i][j] == true){
            return false;
        }
        vis[i][j] = true;
        
        if(search(ind + 1, i + 1, j, board, word, vis)||
          search(ind + 1, i, j + 1, board, word, vis)||
          search(ind + 1, i - 1, j, board, word, vis)||
          search(ind + 1, i, j - 1, board, word, vis)){
            return true;
        }
   
        vis[i][j] = false;
        return false;
        
    }
}