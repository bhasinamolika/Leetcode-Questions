class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes, (n1,n2) -> n2[1] - n1[1]);
        int ans=0;
        for(int i=0;i<boxTypes.length;i++){
            if(truckSize<=0) break;
            if(truckSize>=boxTypes[i][0]){
                ans+=boxTypes[i][0]*boxTypes[i][1];
                System.out.println(ans);
                truckSize-=boxTypes[i][0];
            }
            else{
                ans+=truckSize*boxTypes[i][1];
                truckSize-=boxTypes[i][0];
                System.out.println(ans);
            }
        }
        return ans;
    }
}