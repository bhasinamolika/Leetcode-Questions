class Solution {
    public int bestClosingTime(String customers) {
        int totalY=0;int totalN=0;
        //calculating presum of Y
        for(char c:customers.toCharArray()){
            if(c=='Y')totalY++;
            if(c=='N')totalN++;
        }
        
        int minI=(int)1e9;//maintaining minimum index
        int min_diff=(int)1e9;//maintaining minimum diff
        int maintainY=0;//going forward maintaining no of Y to be sbstracted from presum(total sum of Y)
    
        for(int i=0;i<customers.length();i++){
            //checking if (totalY-maintainY) is less than prev diff then update
            if((totalY-maintainY)<min_diff){
                min_diff=totalY-maintainY;
                minI=i;
            }
            if(customers.charAt(i)=='Y')maintainY++;
            else maintainY--;
        }
        
        //for outside case
        // if at string length mindiff is less than or equal totalN comparing the smallest index
        
        if(min_diff<=totalN){
            minI=Math.min(minI,customers.length());
        }
        //else if totalN is less then min index should be string length 
        else{
            minI=customers.length();
        }
        
        return minI;
    }
}