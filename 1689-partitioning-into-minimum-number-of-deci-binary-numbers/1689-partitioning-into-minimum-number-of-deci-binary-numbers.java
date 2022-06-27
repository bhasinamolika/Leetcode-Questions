class Solution {
    public int minPartitions(String n) {
        char arr[]=n.toCharArray();
        int max=Integer.MIN_VALUE;
        for(char c :arr){
            max=Math.max(max,Integer.parseInt(c+""));
        }
        return max;
    }
}