//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*;


// } Driver Code Ends
//User function Template for Java

class Solution{
    
   // Function for finding maximum AND value.
    public static int maxAND (int arr[], int N) {
        
        // Your code here
        // You can add extra function (if required)
        int maxAndPair = findMaxAndPair(arr, N);
        return maxAndPair;
        
    }
    
    static boolean findHas2SetBits(int pattern, int[] arr, int len)
    {
        int count = 0;
        for (int i = 0; i < len; i++)
        {
            if ((arr[i] & pattern) == pattern)
                count++;
            
            if (count == 2)
                return true;
        }
        return false;
    }
    
    static int findMaxAndPair(int[] arr, int len)
    {
        int res = 0;
        int pattern = 0;
        //first we assign a number having it's 17th bit set
        for (int bit = 16; bit >= 0; --bit)
        {
            //we shift 1 every time from the MSB to the LSB and send the patter to another function to check if the respective bit is set or not.
            //the result will be in boolean, if true then we add the decimal equivalent of that set bit to the result else discard it and go for the 
            //next iteration.
            boolean has2SetBits = findHas2SetBits((pattern | (1 << bit)), arr, len);
            
            //if true, then the pattern will be modified and an additional 1 will be added in it else it will stay the same.
            if (has2SetBits)
            {
                res += 1 * Math.pow(2, bit);
                pattern = pattern | (1 << bit);
            }
        }
        return res;
    }
    

    
}

//{ Driver Code Starts.

class BitWise {
    
	public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim()); //Inputting the testcases
		while(t-->0){
		    
		    //input size of array
		    int n = Integer.parseInt(br.readLine());
		    String inputLine[] = br.readLine().trim().split(" ");
		    int arr[] = new int[n];
		    
		    //inserting elements in the array
		    for(int i=0; i<n; i++){
		        arr[i]=Integer.parseInt(inputLine[i]);
		    }
		    
		    Solution obj = new Solution();
		    
		    //calling maxAND() method of class AND
		    System.out.println(obj.maxAND(arr, n));
		}
	}
}

// } Driver Code Ends