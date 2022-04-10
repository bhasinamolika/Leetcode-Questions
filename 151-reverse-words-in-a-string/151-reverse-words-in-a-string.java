class Solution {
    public String reverseWords(String s) {
        s = s.replaceAll("\\s++", " ");
        String arr[]=s.split(" ");
        
        String ans="";
        for(int i=0;i<arr.length;i++){
            ans=arr[i]+" "+ans;
        }
        return ans.trim();
    }
}