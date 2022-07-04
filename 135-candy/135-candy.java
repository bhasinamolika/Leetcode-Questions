class Solution {
    public int candy(int[] ratings) {
        int l2r[]=new int[ratings.length];
        Arrays.fill(l2r,1);
        int r2l[]=new int[ratings.length];
        Arrays.fill(r2l,1);
        int total=0;
        for(int i=1;i<l2r.length;i++){
            if(ratings[i]>ratings[i-1])
                l2r[i]=l2r[i-1]+1;
        }
        for(int i=r2l.length-2;i>=0;i--){
            if(ratings[i]>ratings[i+1])
                r2l[i]=r2l[i+1]+1;
        }
        for(int i=0;i<ratings.length;i++){
            total+=Math.max(r2l[i],l2r[i]);
        }
        return total;
    }
}