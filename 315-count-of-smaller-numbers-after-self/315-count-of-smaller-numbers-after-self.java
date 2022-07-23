class Solution {
    public List<Integer> countSmaller(int[] nums) {
        int[] res = new int[nums.length];
        int[][] a = new int[nums.length][2]; // can also make a pair(value,index) rather than 2D matrix 
        for ( int i=0; i<nums.length; i++ ) {
            a[i][0] = nums[i];
            a[i][1] = i;
        }
        sort(a, res, 0, nums.length-1);
        List<Integer> list = new ArrayList<>();
        for ( int i=0; i<nums.length; i++ ) {
            list.add(res[i]);
            // System.out.println(a[i][0]+" "+a[i][1]);
        }
        return list;
    }
    public void sort ( int[][] a, int[] res, int l, int r ) {
        if ( l<r ) {
            int m = (l+r)/2;
            sort( a, res, l, m );
            sort( a, res, m+1, r );
            merge( a, res, l, m, r );
        }
    }
    public void merge ( int[][] a, int[] res, int l, int m, int r ) {
        int[][] left = Arrays.copyOfRange(a, l, m+1);
        int[][] right = Arrays.copyOfRange(a, m+1, r+1);
        int i = 0;
        int j = 0;
        int cnt = 0;
        int k = l;
        while ( i<left.length && j<right.length ) {
            if ( left[i][0]<=right[j][0] ) {
                res[left[i][1]] += cnt;
                a[k++] = left[i++];
            } else {
                cnt++;
                a[k++] = right[j++];
            }
        }
        while ( i<left.length ) {
            res[left[i][1]] += cnt;
            a[k++] = left[i++];
        }
        while ( j<right.length ) {
            a[k++] = right[j++];
        }
    }
}