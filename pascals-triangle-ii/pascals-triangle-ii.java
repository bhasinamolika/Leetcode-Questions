class Solution {
    public List<Integer> getRow(int rowIndex) {
        
        List<Integer> ans=new ArrayList<>();
        long val=1;
        for(int r=0;r<=rowIndex;r++){
            ans.add((int)val);
            val=val*(rowIndex-r)/(r+1);
        }
        
        return ans;
    }
}