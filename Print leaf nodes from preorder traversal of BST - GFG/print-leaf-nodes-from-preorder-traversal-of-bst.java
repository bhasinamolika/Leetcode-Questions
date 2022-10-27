//{ Driver Code Starts
//Initial Template for Java
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(read.readLine().trim());
        while(T-->0)
        {
            int N = Integer.parseInt(read.readLine());
            String input_line[] = read.readLine().trim().split("\\s+");
            int arr[]= new int[N];
            for(int i = 0; i < N; i++)
                arr[i] = Integer.parseInt(input_line[i]);
            Solution ob = new Solution();
            int[] ans = ob.leafNodes(arr, N);
            for(int i = 0; i < ans.length; i++)
            {
                System.out.print(ans[i] + " ");
            }
            System.out.println();
        }
    }
}

// } Driver Code Ends


//User function Template for Java
class Solution

{
    public int[] leafNodes(int arr[], int N)

    { 
        int n=N;

        ArrayList<Integer> al=new ArrayList<>();

        Stack<Integer> s=new Stack<>();

        s.push(arr[0]);

        for(int i=1;i<n;i++)

        {
            s.push(arr[i]);
            int count=0;

            Iterator value=s.iterator();

            while (value.hasNext()) {

                if((int)value.next()<arr[i])count++;

                                    }

          for(int j=0;j<count+1;j++)

          {

            if(count+1>2 && j==1)al.add(s.peek());

            s.pop();

          }

          

            s.push(arr[i]);

       }

     al.add(s.peek());

    

     int arrnew[]=new int[al.size()];

     for(int i=0;i<al.size();i++)

     {

        arrnew[i]=al.get(i);

     }

      return arrnew;

    }

}