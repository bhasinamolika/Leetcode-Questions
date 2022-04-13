class Solution {
    public int[][] generateMatrix(int n) {
       int matrix[][]= new int[n][n];
       
        int arr[] = new int[n*n];
        int value =1;
        
        for(int i=0;i<n*n ;i++ )
        {
            arr[i] = value;
            value++;
        }
        
        //Putting values of array into matrix
        int size = 0;
        int maxSize = n*n;
        int minr =0;
        int minc=0;
        int maxr= n-1;
        int maxc=n-1;
        
        while(size<maxSize){
            //for upper row
            for(int i=minr , j=minc ; j<=maxc &&  size<maxSize ; j++  ) {
                matrix[i][j]=arr[size];
                size++;
            }
            minr++;
            //for right column
             for(int i=minr , j=maxc ; i<=maxr &&  size<maxSize ; i++){
              matrix[i][j]=arr[size];
                size++;
            }
            maxc--;
            //for bottom row
             for(int i=maxr , j=maxc ; j>=minc &&  size<maxSize ; j--){
                matrix[i][j]=arr[size];
                size++;
            }
            maxr--;
            //for left column
             for(int i=maxr , j=minc ; i>=minr &&  size<maxSize ; i--){
                matrix[i][j]=arr[size];
                size++;
            }
            minc++;
        }
        
        return matrix;
        
    }
}