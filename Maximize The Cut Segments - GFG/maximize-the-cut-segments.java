// { Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class Driver
{
    public static void main(String args[])throws IOException
    {
        //reading input using BufferedReader class
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        
        //reading total testcases
        int t = Integer.parseInt(read.readLine());
        
        while(t-- > 0)
        {
            //reading length of line segment
            int n = Integer.parseInt(read.readLine().trim());
            
            
            //reading 3 segment lengths
            String str[] = read.readLine().trim().split(" ");
            
            int x = Integer.parseInt(str[0]);
            int y = Integer.parseInt(str[1]);
            int z = Integer.parseInt(str[2]);
            
            
            //calling method maximizeCuts() of class Solution()
            //and printinting the result
            System.out.println(new Solution().maximizeCuts(n, x, y, z));
        }
    }
}
// } Driver Code Ends


//User function Template for Java


class Solution
{
    //Function to find the maximum number of cuts.
    public int maximizeCuts(int n, int x, int y, int z)
    {
       //Your code here
       int length[]={x,y,z};
       int dp[][]=new int[length.length+1][n+1];
       
       //initialisation
       //first row initialised with INT_MAX-1
       for(int i=0;i<n+1;i++){
           dp[0][i]=Integer.MIN_VALUE;
       }
       //first column initialisation with 1
       for(int i=1;i<length.length+1;i++){
           dp[i][0]=0;
       }
       //initialising second row
       
           for(int j=1;j<n+1;j++){
               if(j%length[0]==0){
                   dp[1][j]=j/length[0];
               }
               else
               dp[1][j]=Integer.MIN_VALUE;
           }
       
       //main code of unbounded knapsack
       for(int i=2;i<length.length+1;i++){
           for(int j=1;j<n+1;j++){
               if(length[i-1]<=j)
               dp[i][j]=Math.max(dp[i-1][j],1+dp[i][j-length[i-1]]);
               else
               dp[i][j]=dp[i-1][j];
           }
       }
    //   for(int i=0;i<length.length;i++){
    //       for(int j=0;j<n+1;j++){
    //           System.out.print(dp[i][j]);
    //       }
    //       System.out.println();
    //   }
       return dp[length.length][n]<0?0:dp[length.length][n];
    }
}