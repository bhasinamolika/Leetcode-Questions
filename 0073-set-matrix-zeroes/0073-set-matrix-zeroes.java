class Solution {
    public void setZeroes(int[][] matrix) {
        //My Approach:  traverse the matrix and record the row and column of the zeroes then set them zero in the next traversal
        Set<Integer> rows=new HashSet<>();
        Set<Integer> cols=new HashSet<>();
        
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                if(matrix[i][j]==0){
                    rows.add(i);
                    cols.add(j);
                }
            }
        }
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                if(rows.contains(i)){
                    matrix[i][j]=0;
                }
                if(cols.contains(j)){
                    matrix[i][j]=0;
                }
            }
        }
    }
}