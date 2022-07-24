class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = 0;
        int col = matrix[0].length-1;
        while(row<matrix.length && col>=0)
        {
		//check if matrix[row][col]==target
            if(matrix[row][col]==target)
            {
                return true;
            }
		//if element is less than target we can eleminate whole row and check in next row but keeping column unchanged
            if(matrix[row][col]<target)
            {
                row++;
                continue;
            }
	//if element is greater than target we can eleminate whole column and check in previous column but keeping row unchanged
            if(matrix[row][col]>target)
            {
                col--;
                continue;
            }
        }
	//if element is not found in 2D array return false
        return false;
        
    }
}