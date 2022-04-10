class Solution {
    public String reverseWords(String s) {
        String word="";
        String ans="";
        s=s.trim();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)!=' ')
                word+=s.charAt(i);
            else if(s.charAt(i)==' ' && s.charAt(i-1)!=' '){
                ans=word+" "+ans;
                word="";
            }
        }
        ans=word+" "+ans;
        return ans.trim();
    }
}