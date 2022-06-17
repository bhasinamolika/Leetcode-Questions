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
                    String s1 = sc.next();
                    String s2 = sc.next();
                    Solution ob = new Solution();
                    System.out.println(ob.minOperations(s1,s2));
                }
        }
}    // } Driver Code Ends


//User function Template for Java

class Solution
{
	public int minOperations(String str1, String str2) 
	{ 
	    //deletions=str1.length()-LCS length
	    //insertions=str2.length()-LCS length
	    
	    int m=str1.length();
	    int n=str2.length();
	    
	    int insertions=0;
	    int deletions=0;
	    int LCS=0;
	    
	    int dp[][]=new int [m+1][n+1];
	    
	    //initialisation
	    for(int i=0;i<m+1;i++){
	        for(int j=0;j<n+1;j++){
	            if(i==0 || j==0)
	            dp[i][j]=0;
	        }
	    }
	    
	    // main code to find LCS length
	    for(int i=1;i<m+1;i++){
	        for(int j=1;j<n+1;j++){
	            if(str1.charAt(i-1)==str2.charAt(j-1)){
	                dp[i][j]=dp[i-1][j-1]+1;
	            }
	            else{
	                dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
	            }
	        }
	    }
	    LCS=dp[m][n];
	    //System.out.println(LCS);
	    deletions=m-LCS;
	    insertions=n-LCS;
	    
	    
	    return deletions+insertions;
	} 
}