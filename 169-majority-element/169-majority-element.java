class Solution {
    public int majorityElement(int[] nums) {
        int maj=-1;
        int count=0;
        for(int ele:nums){
            if(count==0)
                maj=ele;
            
            if(ele==maj)
                count++;
            else
                count--;
        }
        return maj;
    }
}
//boyer moore's algorithm
