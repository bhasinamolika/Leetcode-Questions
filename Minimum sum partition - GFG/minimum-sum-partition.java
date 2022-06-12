// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
class GfG
{
    public static void main(String args[])
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t-->0)
                {
                    int n = sc.nextInt();
                    int A[] = new int[n];
                    for(int i = 0;i<n;i++)
                        A[i] = sc.nextInt();
                    Solution ob = new Solution();
                    System.out.println(ob.minDifference(A,n));
                }
        }
}    // } Driver Code Ends


//User function Template for Java

class Solution
{
public int minDifference(int arr[], int n) 
{ 
    // Your code goes here
    int arrSum = 0;
    for(int i=0;i<n;i++){
        arrSum +=arr[i];
    }
    
    int mid = arrSum/2;
    int s1=0;
    
    while(mid<=arrSum){
        if(isSubsetSum(n,arr,mid)){
            s1 = mid;
            break;
        }
        mid++;
    }
    
    //s2 = arrSum - s1   =>  s2-s1 = arrSum -s1 -s1 
    return Math.abs(arrSum - 2*s1);    
    
} 

 static Boolean isSubsetSum(int N, int arr[], int sum){
       // code here
       boolean[][] dp = new boolean[N+1][sum+1];
       
      // dp[0][0] = true;
       
       for(int i =0;i<N+1;i++){
           for(int j = 0;j<sum+1;j++){
               if(i==0 && j!=0){
                   dp[i][j] = false;
               }
               
               if(j==0){
                   dp[i][j] = true;
               }
           }
       }
       
        for(int i =1;i<N+1;i++){
           for(int j = 1;j<sum+1;j++){
               
               if(arr[i-1]<=j){
                   dp[i][j] = ( dp[i-1][j-arr[i-1]] || dp[i-1][j]  );
               }
               else{
                   dp[i][j] = dp[i-1][j];
               }
           }
        }
        return dp[N][sum];
   }

}