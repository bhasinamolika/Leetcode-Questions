class Solution {
    public int maxArea(int[] height) {
        int area=0;
        int i=0;
        int j=height.length-1;
        while(i<j){
            if(height[i]>height[j]){
                int temp=height[j]*(j-i);
                area=Math.max(area,temp);
                j--;
            }
            else{
                int temp=height[i]*(j-i);
                area=Math.max(area,temp);
                i++;
            }
        }
        return area;
    }
}