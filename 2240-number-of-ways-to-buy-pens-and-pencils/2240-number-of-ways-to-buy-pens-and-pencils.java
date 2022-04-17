class Solution {
    public long waysToBuyPensPencils(int total, int cost1, int cost2) {
        if ( cost1 > total && cost2 > total ){
            return 1;
        }
        long count = 0;
        int a = 0;
        while ( total-(a*cost1) >= 0 ) {
                count += (( total - a*cost1) / cost2 )+ 1;
                a++;
        }
        return count;
    }
}