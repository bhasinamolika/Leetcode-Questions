class Solution {
public int countHousePlacements(int n) {
if(n==1)
{
return 4;
}
if(n==2)
{
return 9;
}
if(n==3)
{
return 25;
}
if(n==4)
{
return 64;
}
int arr[]=new int[n-1];
arr[0]=3;
arr[1]=5;
for(int i=2;i<n-1;i++)
{
arr[i]=(arr[i-1]+arr[i-2])%1000000007;

    }
    long res=(1l*arr[n-2]*arr[n-2])%1000000007;
    return (int)res%1000000007;
}
}