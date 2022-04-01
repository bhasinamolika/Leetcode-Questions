class Solution {
    public String reverseWords(String s) {
        String ans="";
        
        String rev="";
        //s=s+" ";
        int len=s.length();
        //System.out.println(s);
        for(int i=0;i<len;i++){
            
            if(s.charAt(i)!=' ')
                rev=s.charAt(i)+rev;
            //System.out.println(rev);
            if(s.charAt(i)==' '){
                ans=ans+rev+' ';
                rev="";
            }
        }
        ans=ans+rev;
        return ans.trim();
    }
}