class Solution {
    public int maximumsSplicedArray(int[] nums1, int[] nums2) 
    {
        int n=nums1.length;
    
        long first[]=new long[n];
        long sum1=0; long sum2=0;
        
        for(int i=0;i<n;i++)
        {
            first[i]=nums2[i]-nums1[i];
            sum1+=nums1[i];
            sum2+=nums2[i];
        }
            
        long x=kadane(first,1);
        long y=kadane(first,-1);
        
        return (int)Math.max(sum1+x,sum2+y);
    }
    
    public long kadane(long a[],int p)
    {
        int n=a.length;
        long max=a[0]*p;long sum=0;
        
        for(int i=0;i<n;i++)
        {
            sum+=(a[i]*p);
            max=Math.max(sum,max);
            
            if(sum<0)
            sum=0;
        }
        
        return max;
    }
}