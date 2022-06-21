// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            int N = Integer.parseInt(in.readLine());
            String input_line[] = in.readLine().trim().split("\\s+");
            int arr[]= new int[N];
            for(int i = 0; i < N; i++)
                arr[i] = Integer.parseInt(input_line[i]);
            
            Solution ob = new Solution();
            System.out.println(ob.matrixMultiplication(N, arr));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    static int matrixMultiplication(int N, int arr[])
    {
        //step 1: find the values of i and j
        int i=1,j=N-1;
        int dp[][]=new int[101][101];
       for (int[] row : dp)
            Arrays.fill(row, -1);
        
        return solve(arr,i,j,dp);
    }
    static int solve(int [] arr,int i,int j,int [][]dp){
        //step 2:Base condition
        if(i>=j) return 0;
        if(dp[i][j]!=-1) return dp[i][j];
        
        // main MCM logic
        int min=Integer.MAX_VALUE;
        for(int k=i;k<j;k++){
            int temp=solve(arr,i,k,dp)+solve(arr,k+1,j,dp)+arr[i-1]*arr[k]*arr[j];
            min=Math.min(min,temp);
        }
        dp[i][j]=min;
        return min;
    }
}