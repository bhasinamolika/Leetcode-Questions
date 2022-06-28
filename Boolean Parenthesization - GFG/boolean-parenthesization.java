// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            int N = Integer.parseInt(in.readLine());
            String S = in.readLine();
            
            Solution ob = new Solution();
            System.out.println(ob.countWays(N, S));
        }
    }
}// } Driver Code Ends


//User function Template for Java

class Solution{
    static int countWays(int N, String string){
        // code here
        int i = 0;
		int j = N - 1;
		boolean isTrue = true;
		HashMap<String, Integer> map = new HashMap<>();

		return solve(string, i, j, isTrue, map);
    }
    
    private static int solve(String string, int i, int j, boolean isTrue, HashMap<String, Integer> map) {

		int mod = 1003;
		if (i > j)
			return 0;
		if (i == j)
			if (isTrue == true) {

				return (string.charAt(i) == 'T') ? 1 : 0;
			} else {
				return (string.charAt(i) == 'F') ? 1 : 0;
			}

		String key = i + " " + j + " " + isTrue;
		// String key = String.valueOf(i) ;
		// key= key.concat(" ") ;
		// key = key.concat(String.valueOf(j)) ;
		// key= key.concat(" ") ;
		// key= key.concat(String.valueOf(value)) ;

		if (map.containsKey(key)) {

			return map.get(key);
		}

		long ans = 0;

		for (int k = i + 1; k <= j - 1; k += 2) {

			int lT = solve(string, i, k - 1, true, map);
			int lF = solve(string, i, k - 1, false, map);

			int rT = solve(string, k + 1, j, true, map);
			int rF = solve(string, k + 1, j, false, map);

			if (string.charAt(k) == '&') {

				if (isTrue) {

					ans = ans + lT * rT;
				} else {
					ans = ans + (lT * rF) + (lF * rT) + (lF * rF);
				}
			}

			else if (string.charAt(k) == '|') {
				if (isTrue) {
					ans = ans + (lT * rT) + (lF * rT) + (lT * rF);
				} else {
					ans = ans + (lF * rF);
				}
			}

			else if (string.charAt(k) == '^') {
				if (isTrue) {
					ans = ans + (lT * rF) + (lF * rT);
				} else {
					ans = ans + (lF * rF) + (lT * rT);
				}
			}
		}

		map.put(key, (int) (ans % mod));
		return (int) (ans % mod);
	}
}