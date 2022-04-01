class Solution {
    public String reverseVowels(String s) {
        String vowels="";
        String ans="";
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            if(ch=='a'|| ch=='e' || ch=='i' || ch=='o' || ch=='u' || ch=='A' || ch=='E' || ch=='I' || ch=='O' || ch=='U')
                vowels=vowels+ch;
        }
        int i=vowels.length()-1;
        for(int k=0;k<s.length();k++){
            char ch=s.charAt(k);
            if(ch=='a'|| ch=='e' || ch=='i' || ch=='o' || ch=='u' || ch=='A' || ch=='E' || ch=='I' || ch=='O' || ch=='U')
                ans=ans+vowels.charAt(i--);
            else
                ans=ans+s.charAt(k);
        }
        return ans;
    }
}