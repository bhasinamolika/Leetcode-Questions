class Solution {
    public int numSubmatrixSumTarget(int[][] matrix, int target) {
        int row = matrix.length;
        int col = matrix[0].length;
            
        // we are doing the PreFix sum in each row
            
        for(int i=0;i<row;i++){
            for(int j=1;j<col;j++){
               matrix[i][j]+= matrix[i][j-1];
            }
        }
        
        int count=0;
        
        // we are going to take the column pair so that each sub matrix pair we can take
        
        for(int startCol=0; startCol<col; startCol++){
            
            for(int currCol=startCol; currCol<col; currCol++){
                Map<Integer,Integer> map = new HashMap<>();
                map.put(0,1);
                int sum=0;
                
                for(int currRow=0; currRow<row; currRow++){
                    // we are using prefix sum to create the subarray in 2D, so we need below condition
                    // for 0 startCol and other currCol it is okey
                    // when startCol>0 we need to remove previous column value so removing
                    sum+= matrix[currRow][currCol]-(startCol>0 ? matrix[currRow][startCol-1] : 0);
                    
                    count+=map.getOrDefault(sum-target,0);
                     map.put(sum,map.getOrDefault(sum,0)+1);
                }
                
            }
        }
          
       return count; 
    }
}