class Solution {
    public int maxResult(int[] nums, int k) {
        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->b[1]-a[1]);// storing index and maxSum uptill that index
        int max=nums[0];
        pq.offer(new int[]{0,max});// by default we have the index 0 and maxSum will be the value stored at 0th index of nums
        for(int i=1;i<nums.length;i++){
            while((i-pq.peek()[0])>k)
                pq.poll();
            max = nums[i] + pq.peek()[1];
            pq.offer(new int[]{i,max});
            
        }
        return max;
        
    }
}