// I misconstrued this question. This is fundamental question which actually taught me the difference between subarray and subsequence. The code which I wrote would have worked fine if the question asked was to find a wiggle SUBARRAY,but since we have to find a wiggle subsequence therefore the approach will be different.  
// class Solution {
//     public int wiggleMaxLength(int[] nums) {
//         int diffArr[]=new int[nums.length-1];
//         //arr[i] will store the diff between nums[i+1] and nums[i]
//         for(int i=0;i<diffArr.length;i++){
//             diffArr[i]=nums[i+1]-nums[i];
//         }
//         System.out.println(Arrays.toString(diffArr));
//         int maxLength=Integer.MIN_VALUE;
//         int len=1;
//         int currSign=diffArr[0]<0?-1:1;
//         for(int i=1;i<diffArr.length;i++){
//             if((diffArr[i]<0 && currSign==1) || diffArr[i]>0 && currSign==-1){
//                 len++;
//                 currSign=diffArr[i]<0?-1:1;
//             }
//             else{
//                 maxLength=Math.max(maxLength,len);
//                 len=1;
//             }
//         }
//         if(maxLength<0) maxLength=nums.length;
//         return maxLength;
//     }
// }
public class Solution {
    public int wiggleMaxLength(int[] nums) {
        if (nums.length < 2)
            return nums.length;
        int[] up = new int[nums.length];
        int[] down = new int[nums.length];
        for (int i = 1; i < nums.length; i++) {
            for(int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    up[i] = Math.max(up[i],down[j] + 1);
                } else if (nums[i] < nums[j]) {
                    down[i] = Math.max(down[i],up[j] + 1);
                }
            }
        }
        return 1 + Math.max(down[nums.length - 1], up[nums.length - 1]);
    }
}