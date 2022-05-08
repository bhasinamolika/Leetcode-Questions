class Solution {
    public int maxArea(int[] height) {
        int maxarea=Integer.MIN_VALUE;
        int i=0;
        int j=height.length-1;
        int currarea=0;
        while(i<j){
            currarea=(j-i)*Math.min(height[j],height[i]);
            maxarea=Math.max(maxarea,currarea);
            if(height[j]<height[i]) j--;
            else i++;
        }
        return maxarea;
    }
}