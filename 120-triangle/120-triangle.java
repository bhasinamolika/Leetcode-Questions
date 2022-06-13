class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        for(int i=n-2;i>=0;i--)
        {
            for(int j=0;j<i+1;j++)
            {
                int nextRowElement = triangle.get(i).get(j);
                int left = triangle.get(i+1).get(j);
                int right = triangle.get(i+1).get(j+1);
                
                int min = Math.min(left,right);
                
                triangle.get(i).set(j,nextRowElement+min);
            }
        }
        return triangle.get(0).get(0);
    }
}