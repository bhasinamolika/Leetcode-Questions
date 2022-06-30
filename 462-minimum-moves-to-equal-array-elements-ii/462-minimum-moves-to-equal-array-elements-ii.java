class Solution {
    public int minMoves2(int[] nums) {
        int n=nums.length;
        Arrays.sort(nums);
        int median=0;
        int ans=0;
        if(n%2==0){
            // if even number of elements
            median=nums[n/2];
            System.out.println(median);
        }
        else{
            median=nums[n/2];
            System.out.println(median);
        }
          for(int i=0;i<n;i++){
              ans+=(Math.abs(median-nums[i]));
          }  
        return ans;
    }
}