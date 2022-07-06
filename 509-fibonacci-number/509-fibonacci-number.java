class Solution {
    public int fib(int n) {
        // recursion code
        // if(n==0 || n==1)
        //     return n;
        // return fib(n-1)+fib(n-2);
        // DP
        if(n==0)
            return 0;
        int aux[]=new int [n+1];
        aux[0]=0;
        aux[1]=1;
        for(int i=2;i<n+1;i++){
            aux[i]=aux[i-1]+aux[i-2];
        }
        return aux[n];
    }
}