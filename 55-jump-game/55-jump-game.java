class Solution {
    public boolean canJump(int[] n) {
        int s=0,k=n.length;
        for(int i=0;i<k;i++)
        {
            if(s<i)
                return false;
            s=Math.max(s,i+n[i]);
            if(s>=k-1)
                return true;
        }
        return true;
    }
}