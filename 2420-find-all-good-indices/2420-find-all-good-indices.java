class Solution {
    public List<Integer> goodIndices(int[] nums, int k) {
        int n=nums.length;
        int nonIncreasing[]=new int[n];
        int nonDecreasing[]=new int[n];
        Arrays.fill(nonIncreasing,1);
        Arrays.fill(nonDecreasing,1);
        for(int i=1;i<n;i++){
            if(nums[i]<=nums[i-1])
                nonIncreasing[i]=nonIncreasing[i-1]+1;
            else
                nonIncreasing[i]=1;
        }
        for(int i=n-2;i>=0;i--){
            if(nums[i]<=nums[i+1])
                nonDecreasing[i]=nonDecreasing[i+1]+1;
            else
                nonDecreasing[i]=1;
        }
        List<Integer> ans=new ArrayList<>();
        for(int i=1;i<n-1;i++){
            if(nonIncreasing[i-1]>=k && nonDecreasing[i+1]>=k)
                ans.add(i);
        }
        return ans;
    }
}