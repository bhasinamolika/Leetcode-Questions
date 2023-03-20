//{ Driver Code Starts
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
            int N = sc.nextInt();
            Solution ob = new Solution();
            ArrayList<Integer> ans = ob.factorial(N);
            for (Integer val: ans) 
                System.out.print(val); 
            System.out.println();
        }   
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    static ArrayList<Integer> factorial(int N){
        java.math.BigInteger b = new java.math.BigInteger(N + "");
        ArrayList<Integer> res = new ArrayList<>();
        for (int i = 1; i < N; i++)
            b = b.multiply(new java.math.BigInteger(i + ""));
        String s = String.valueOf(b);
        for (int i = 0; i < s.length(); i++)
            res.add(Character.getNumericValue(s.charAt(i)));
        return res;
    }
}